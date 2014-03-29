/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;
import operateur.Addition;
import operateur.Division;
import operateur.Multiplication;
import operateur.Soustraction;

/**
 * CalculatriceModel
 *
 * @author CHAYEM Samy
 */
public class CalculatriceModel extends Observable {

    ////////////////////////////// VARIABLES //////////////////////////////
    private Expression exp;
    private String resultat;
    private ArrayList<String> historique;
    private boolean testEgalite;
    private boolean modeHexadecimal;
    public boolean fin;

    /*
     * 0 - addition
     * 1 - soustraction
     * 2 - multiplication
     * 3 - division
     */
    private int operateur;

    //////////////////////////// CONSTRUCTEURS ////////////////////////////
    /**
     * Constructeur de la class CalculatriceModele
     */
    public CalculatriceModel() {

        this.resultat = "";
        this.exp = null;
        this.historique = new ArrayList<>();
        this.historique.add(null);
        this.testEgalite = false;
        this.modeHexadecimal = false;
        this.fin = false;

    } // GraphiqueModele()

    ////////////////////////////// FONCTIONS //////////////////////////////
    /**
     * Permet d'ajouter un chiffre a l'affichage
     *
     * @param chiffre chiffre a ajouter
     */
    public void ajouterChiffreResultat(String chiffre) {

        if (this.testEgalite) {

            // On debute un nouveau calcul
            this.resultat = chiffre;
            this.exp = null;
            this.historique.add(null);

        } else {

            if (this.resultat.contains(".") && chiffre.equals(".")) {

                // Il y a deja une virgule dans le nombre
                System.out.println("Impossible d'ajouter une virgule !");

            } else {

                // On demarre le premier calcule
                this.resultat = this.resultat + chiffre;

            }

        }
        this.testEgalite = false;
        setChanged();
        notifyObservers("1");
        setChanged();
        notifyObservers("3");

    } // ajouterChiffreResultat(String chiffre)

    /**
     * Permet de supprimer la derniere entree saisie
     */
    public void supprimerChiffre() {

        if (!this.resultat.isEmpty()) {

            // On supprime le dernier chiffre si le string n'est pas vide
            this.resultat = this.resultat.substring(0, this.resultat.length() - 1);

        }

        setChanged();
        notifyObservers("1");

    } // supprimerChiffre()

    /**
     * Permet de reagir au clic sur un operateur
     *
     * @param ope reference a l'operateur clique
     */
    public void operation(int ope) {

        if (!this.resultat.isEmpty()) {

            if (this.historique.isEmpty() || this.historique.get(this.historique.size() - 1) == null) {

                // On rentre le premier nombre
                if (this.modeHexadecimal) {

                    this.exp = new Nombre(this.convertirHexaToDouble(this.resultat));

                } else {

                    this.exp = new Nombre(Double.parseDouble(this.resultat));

                }
                this.historique.set(this.historique.size() - 1, this.resultat);
                this.resultat = "";

            }
            this.calculerResultat();
            this.operateur = ope;
            this.testEgalite = false;
            this.resultat = "";

            setChanged();
            notifyObservers("1");
            setChanged();
            notifyObservers("3");

        }

    } // operation(int ope)

    /**
     * Permet de calculer le resultat final
     */
    public void calculerResultat() {

        if (!this.resultat.isEmpty() && !this.resultat.replaceAll("0", "").replace(".", "").isEmpty()
                && this.exp != null && !this.historique.isEmpty()) {

            String temp1 = this.resultat; //this.historique.get(this.historique.size()-1) + this.resultat;

            Double nb;
            if (this.modeHexadecimal) {

                // Convertion hexa/double
                nb = this.convertirHexaToDouble(this.resultat);

            } else {

                // Mode normal
                nb = Double.parseDouble(this.resultat);

            }

            switch (this.operateur) {

                case 0:
                    // Addition
                    temp1 = this.historique.get(this.historique.size() - 1) + " + " + this.resultat;
                    this.exp = new Addition(this.exp.resultat(), nb);
                    break;

                case 1:
                    // Soustraction
                    temp1 = this.historique.get(this.historique.size() - 1) + " - " + this.resultat;
                    this.exp = new Soustraction(this.exp.resultat(), nb);
                    break;

                case 2:
                    // Multiplication
                    temp1 = this.historique.get(this.historique.size() - 1) + " x " + this.resultat;
                    this.exp = new Multiplication(this.exp.resultat(), nb);
                    break;

                case 3:
                    // Division
                    temp1 = this.historique.get(this.historique.size() - 1) + " / " + this.resultat;
                    this.exp = new Division(this.exp.resultat(), nb);
                    break;

                default:
                    break;

            }

            String temp2;
            if (this.modeHexadecimal) {

                // Convertion double/hexa
                temp2 = temp1 + " = " + this.convertirDoubleToHexa(this.exp.resultat());

            } else {

                // Mode normal
                temp2 = temp1 + " = " + this.exp.resultat();

            }

            this.historique.set(this.historique.size() - 1, temp2);
            this.resultat = this.exp.resultat() + "";
            this.testEgalite = true;

            setChanged();
            notifyObservers("1");
            setChanged();
            notifyObservers("2");
            setChanged();
            notifyObservers("4");

        } else if (!this.resultat.isEmpty() && this.resultat.replaceAll("0", "").replace(".", "").isEmpty()) {

            JOptionPane.showMessageDialog(null, "<html>"
                    + "<center><strong>Infinity !</strong></center><br><br>"
                    + "</html>", "À propos...", JOptionPane.INFORMATION_MESSAGE);

        }

    } // calculerResultat()

    /**
     * Permet de passer en mode hexa ou non
     *
     * @param etat true si mode hexa, false sinon
     */
    public void modeHexadecimal(boolean etat) {

        if (etat) {

            // On passe en mode hexa
            this.modeHexadecimal = true;
            setChanged();
            notifyObservers("5");

        } else {

            // On revient au mode normal
            this.modeHexadecimal = false;
            setChanged();
            notifyObservers("6");
            this.effacer();

        }

    } // modeHexadecimal(boolean etat)

    /**
     * Permet de convertir un String hexadecimal en double
     *
     * @param s String hexadecimal a convertir en double
     * @return le resutat en double
     */
    public double convertirHexaToDouble(String s) {

        System.out.println("AVANT: " + s + " | APRES: " + s.replaceAll("(?<=^\\d+)\\.0*$", ""));
        int decimal = Integer.parseInt(s.replaceAll("(?<=^\\d+)\\.0*$", ""), 16);

        return Double.parseDouble(decimal + "");

    } // convertirHexaToDouble(String s)

    /**
     * Permet de convertir un double en String hexadecimal
     *
     * @param d double a convertir en String hexadecimal
     * @return le resutat en String Hexadecimal
     */
    public String convertirDoubleToHexa(Double d) {

        String hex = Double.toHexString(d);

        return hex;

    } // convertirHexaToDouble(Double d)

    /**
     * Permet d'effacer
     */
    public void effacer() {

        this.exp = null;
        this.resultat = "";

        setChanged();
        notifyObservers("1");

    } // effacer()

    /**
     * Permet de reinitialiser l'historique
     */
    public void reinitialiserHistorique() {

        this.resultat = "";
        this.exp = null;
        this.historique = new ArrayList<>();
        this.historique.add(null);
        this.testEgalite = false;
        this.modeHexadecimal = false;
        setChanged();
        notifyObservers("4");

    } // reinitialiserHistorique()

    /**
     * ************** GETTER/SETTER ********************
     */
    /**
     * Permet de recuperer la valeur saisie par l'utilisateur
     *
     * @return la valeur saisie par l'utilisateur
     */
    public String getResultat() {

        return this.resultat;

    } // getResultat()

    /**
     * Permet de recuperer l'historique des calculs
     *
     * @return la liste des calculs
     */
    public ArrayList<String> getHistorique() {

        return historique;

    } // getHistorique()

} // class CalculatriceModel
