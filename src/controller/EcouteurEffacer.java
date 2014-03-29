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
public class EcouteurEffacer implements ActionListener {

    ////////////////////////////// VARIABLES /////////////////////////////////
    private final CalculatriceModel _calculatrice;

    //////////////////////////// CONSTRUCTEURS ///////////////////////////////
    /**
     * Constructeur de la class EcouteurEffacer
     *
     * @param calculatrice modele
     */
    public EcouteurEffacer(CalculatriceModel calculatrice) {

        super();
        this._calculatrice = calculatrice;

    } // EcouteurEffacer(CalculatriceModel calculatrice)

    ////////////////////////////// FONCTIONS /////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent ae) {

        this._calculatrice.effacer();

    } // actionPerformed(ActionEvent ae)

} // class EcouteurEffacer
