/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CalculatriceModel;

/**
 *
 * @author CHAYEM Samy
 */
public class EcouteurSupprimer implements ActionListener {

    ////////////////////////////// VARIABLES /////////////////////////////////
    private final CalculatriceModel _calculatrice;

    //////////////////////////// CONSTRUCTEURS ///////////////////////////////
    /**
     * Constructeur de la class EcouteurSupprimer
     *
     * @param calculatrice modele
     */
    public EcouteurSupprimer(CalculatriceModel calculatrice) {

        super();
        this._calculatrice = calculatrice;

    } // EcouteurSupprimer(CalculatriceModel calculatrice)

    ////////////////////////////// FONCTIONS /////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent ae) {

        this._calculatrice.supprimerChiffre();

    } // actionPerformed(ActionEvent ae)

} // class EcouteurSupprimer
