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
 * EcouteurEgal
 *
 * @author CHAYEM Samy
 */
public class EcouteurEgal implements ActionListener {

    ////////////////////////////// VARIABLES /////////////////////////////////
    private final CalculatriceModel _calculatrice;

    //////////////////////////// CONSTRUCTEURS ///////////////////////////////
    /**
     * Constructeur de la class EcouteurEgal
     *
     * @param calculatrice modele
     */
    public EcouteurEgal(CalculatriceModel calculatrice) {

        super();
        this._calculatrice = calculatrice;

    } // EcouteurEgal(CalculatriceModel calculatrice)

    ////////////////////////////// FONCTIONS /////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent ae) {

        this._calculatrice.calculerResultat();
        this._calculatrice.fin = true;
    } // actionPerformed(ActionEvent ae)

} // class EcouteurEgal
