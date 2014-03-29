package main;

import java.util.Scanner;
import model.Expression;
import model.Nombre;
import operateur.Addition;
import operateur.Division;
import operateur.Multiplication;
import operateur.Soustraction;

/**
 * TestCalculatrice
 *
 * @author CHAYEM Samy
 */
public class TestCalculatrice {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Entrer une valeur: ");
        double op1 = scan.nextDouble();
        double op2;
        String operateur = "";
        Expression total = new Nombre(op1);
        double operande = total.nbOperande();
        double ope = total.nbOperateur();

        while (!operateur.equals("=")) {

            System.out.println("Entrer un operateur (+,-,*,/,=): ");
            operateur = scan.next();

            if (operateur.equals("+")) {

                System.out.println("Entrer une valeur: ");
                op2 = scan.nextDouble();
                total = new Addition(total.resultat(), op2);
                operande++;
                ope++;
                System.out.println("Resultat: " + total.toString() + " = " + total.resultat());

            }

            if (operateur.equals("-")) {

                System.out.println("Entrer une valeur: ");
                op2 = scan.nextDouble();
                total = new Soustraction(total.resultat(), op2);
                operande++;
                ope++;
                System.out.println("Resultat: " + total.toString() + " = " + total.resultat());

            }

            if (operateur.equals("*")) {

                System.out.println("Entrer une valeur: ");
                op2 = scan.nextDouble();
                total = new Multiplication(total.resultat(), op2);
                operande++;
                ope++;
                System.out.println("Resultat: " + total.toString() + " = " + total.resultat());

            }

            if (operateur.equals("/")) {

                System.out.println("Entrer une valeur: ");
                op2 = scan.nextDouble();
                total = new Division(total.resultat(), op2);
                operande++;
                ope++;
                System.out.println("Resultat: " + total.toString() + " = " + total.resultat());

            }

        }

        System.out.println("Resultat final: " + total.resultat());
        System.out.println("Nombre d'operandes: " + operande);
        System.out.println("Nombre d'operateurs: " + ope);

    } // main(String[] args)

} // class TestCalculatrice
