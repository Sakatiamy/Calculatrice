package model;

/**
 * Expression
 *
 * @author CHAYEM Samy
 */
public interface Expression {

    double resultat();

    int nbOperateur();

    int nbOperande();

    @Override
    String toString();

} // interface Expression
