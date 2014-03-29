package model;

/**
 * Nombre
 *
 * @author CHAYEM Samy
 */
public class Nombre implements Expression {

    ////////////////////////// VARIABLES //////////////////////////
    private final double entier;

    ///////////////////////// CONSTRUCTEUR ////////////////////////
    public Nombre(double nombre) {

        this.entier = nombre;

    } // Nombre(double nombre)

    /////////////////////////// FONCTIONS //////////////////////////
    @Override
    public double resultat() {

        return this.entier;

    } // resultat()

    @Override
    public int nbOperateur() {

        return 0;

    } // nbOperateur()

    @Override
    public int nbOperande() {

        return 1;

    } // nbOperande()

    @Override
    public String toString() {

        return "" + this.entier;

    } // toString()

} // class Nombre
