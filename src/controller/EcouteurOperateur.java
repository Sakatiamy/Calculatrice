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
 * EcouteurOperateur
 *
 * @author CHAYEM Samy
 */
public class EcouteurOperateur implements ActionListener {

    ////////////////////////////// VARIABLES /////////////////////////////////
    private final CalculatriceModel _calculatrice;
    private final int _operateur;

    //////////////////////////// CONSTRUCTEURS ///////////////////////////////
    /**
     * Constructeur de la class EcouteurPlus
     *
     * @param calculatrice modele
     * @param operateur reference a l'operateur
     */
    public EcouteurOperateur(CalculatriceModel calculatrice, int operateur) {

        super();
        this._calculatrice = calculatrice;
        this._operateur = operateur;

    } // EcouteurOperateur(CalculatriceModel calculatrice, int operateur)

    ////////////////////////////// FONCTIONS /////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent ae) {

        this._calculatrice.operation(this._operateur);

    } // actionPerformed(ActionEvent ae)

} // class EcouteurOperateur
