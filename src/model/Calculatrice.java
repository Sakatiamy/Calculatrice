package model;

/**
 * Calculatrice
 *
 * @author CHAYEM Samy
 */
public abstract class Calculatrice implements Expression {

    ///////////////////////// VARIABLES /////////////////////////////
    private final double _operande1;
    private final double _operande2;

    //////////////////////// CONSTRUCTEUR ///////////////////////////
    public Calculatrice(double operande1, double operande2) {

        this._operande1 = operande1;
        this._operande2 = operande2;

    } // Calculatrice(double operande1, double operande2)

    ////////////////////////// FONCTIONS /////////////////////////////
    @Override
    public abstract double resultat();

    @Override
    public int nbOperateur() {

        return 1;

    } // nbOperateur()

    @Override
    public int nbOperande() {

        return 2;

    } // nbOperande()

    @Override
    public abstract String toString();

} // abstract class Calculatrice
