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
 * EcouteurReinitialiserHistorique
 *
 * @author CHAYEM Samy
 */
public class EcouteurReinitialiserHistorique implements ActionListener {

    ////////////////////////////// VARIABLES /////////////////////////////////
    private final CalculatriceModel _calculatrice;

    //////////////////////////// CONSTRUCTEURS ///////////////////////////////
    /**
     * Constructeur de la class EcouteurReinitialiserHistorique
     *
     * @param calculatrice modele
     */
    public EcouteurReinitialiserHistorique(CalculatriceModel calculatrice) {

        super();
        this._calculatrice = calculatrice;

    } // EcouteurReinitialiserHistorique(CalculatriceModel calculatrice)

    ////////////////////////////// FONCTIONS /////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent ae) {

        this._calculatrice.reinitialiserHistorique();

    } // actionPerformed(ActionEvent ae)

} // class EcouteurReinitialiserHistorique
