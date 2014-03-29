package operateur;

import model.Calculatrice;

/**
 * Soustraction
 *
 * @author CHAYEM Samy
 */
public class Soustraction extends Calculatrice {

    ////////////////////////// VARIABLES /////////////////////////
    private final double _exp1;
    private final double _exp2;

    ///////////////////////// CONSTRUCTEUR ////////////////////////
    public Soustraction(double exp1, double exp2) {

        super(exp1, exp2);
        this._exp1 = exp1;
        this._exp2 = exp2;

    } // Soustraction(double exp1, double exp2)

    /////////////////////////// FONCTIONS //////////////////////////
    @Override
    public double resultat() {

        return this._exp1 - this._exp2;

    } // resultat()

    @Override
    public String toString() {

        return "(" + this._exp1 + " - " + this._exp2 + ")";

    } // toString()

} // class Soustraction
