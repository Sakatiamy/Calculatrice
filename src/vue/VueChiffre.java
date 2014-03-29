/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controller.EcouteurChiffre;
import controller.EcouteurSupprimer;
import controller.EcouteurVirgule;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.CalculatriceModel;

/**
 * VueChiffre
 *
 * @author CHAYEM Samy
 */
public class VueChiffre extends JPanel implements Observer {

    ///////////////////////////// VARIABLES /////////////////////////////////
    private CalculatriceModel _cm;
    private final GridLayout gl;
    private final char[] lettres;
    private final ArrayList<JButton> boutons;
    private JButton chiffre;
    private JButton hexa;
    private JButton supr;
    private JButton point;

    //////////////////////////// CONSTRUCTEUR ///////////////////////////////
    /**
     * Constructeur de la class VueChiffre
     *
     * @param cm modele
     */
    public VueChiffre(CalculatriceModel cm) {

        gl = new GridLayout(6, 3);
        this.setLayout(gl);
        this.lettres = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};

        // Ajout des chiffres de 0 a 9
        for (int i = 1; i <= 9; i++) {

            this.chiffre = new JButton(i + "");
            this.chiffre.addActionListener(new EcouteurChiffre(cm, i + ""));
            add(this.chiffre);

        }

        // Ajout de la virgule
        this.point = new JButton(".");
        this.point.addActionListener(new EcouteurVirgule(cm));
        add(this.point);

        // Ajout du zero
        this.chiffre = new JButton("0");
        this.chiffre.addActionListener(new EcouteurChiffre(cm, "0"));
        add(this.chiffre);

        // Ajout du bouton supprimer
        this.supr = new JButton("<-");
        this.supr.addActionListener(new EcouteurSupprimer(cm));
        add(this.supr);

        // Boutons hexadecimaux
        this.boutons = new ArrayList<>();
        for (int j = 0; j < 6; j++) {

            this.hexa = new JButton(this.lettres[j] + "");
            this.hexa.addActionListener(new EcouteurChiffre(cm, this.lettres[j] + ""));
            this.hexa.setEnabled(false);
            add(this.hexa);
            this.boutons.add(this.hexa);

        }

    } // VueChiffre(CalculatriceModel cm)

    ////////////////////////////// FONCTIONS ////////////////////////////////
    @Override
    public void update(Observable o, Object arg) {

        // Mise a jour de l'etat du bouton pour supprimer un caractere
        switch (arg.toString()) {

            case "2":
                this.supr.setEnabled(false);
                break;

            case "3":
                this.supr.setEnabled(true);
                break;

        }

        // Gestion de l'option hexadecimal
        switch (arg.toString()) {

            case "5":
                // On affiche les boutons hexa
                for (JButton b : this.boutons) {

                    b.setEnabled(true);

                }
                this.point.setEnabled(false);
                break;

            case "6":

                // On masque les boutons hexa
                for (JButton b : this.boutons) {

                    b.setEnabled(false);

                }
                this.point.setEnabled(true);
                break;

        }

    } // update(Observable o, Object arg)

} // class VueChiffre
