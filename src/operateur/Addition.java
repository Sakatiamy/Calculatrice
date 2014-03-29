package operateur;

import model.Calculatrice;

/**
 * Addition
 *
 * @author CHAYEM Samy
 */
public class Addition extends Calculatrice {

    ///////////////////////// VARIABLES ///////////////////////////
    private final double _exp1;
    private final double _exp2;

    //////////////////////// CONSTRUCTEUR /////////////////////////
    public Addition(double exp1, double exp2) {

        super(exp1, exp2);
        this._exp1 = exp1;
        this._exp2 = exp2;

    } // Addition(double exp1, double exp2)

    ///////////////////////// FONCTIONS ////////////////////////////
    @Override
    public double resultat() {

        return this._exp1 + this._exp2;

    } // resultat()

    @Override
    public String toString() {

        return "(" + this._exp1 + " + " + this._exp2 + ")";

    } // toString()

} // class Addition
