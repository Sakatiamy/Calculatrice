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
 * EcouteurVirgule
 *
 * @author CHAYEM Samy
 */
public class EcouteurVirgule implements ActionListener {

    ////////////////////////////// VARIABLES /////////////////////////////////
    private final CalculatriceModel _calculatrice;

    //////////////////////////// CONSTRUCTEURS ///////////////////////////////
    /**
     * Constructeur de la class EcouteurVirgule
     *
     * @param calculatrice modele
     */
    public EcouteurVirgule(CalculatriceModel calculatrice) {

        super();
        this._calculatrice = calculatrice;

    } // EcouteurVirgule(CalculatriceModel calculatrice)

    ////////////////////////////// FONCTIONS /////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent ae) {

        this._calculatrice.ajouterChiffreResultat(".");

    } // actionPerformed(ActionEvent ae)

} // class EcouteurVirgule
