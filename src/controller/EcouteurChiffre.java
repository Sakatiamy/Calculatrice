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
 * EcouteurChiffre
 *
 * @author CHAYEM Samy
 */
public class EcouteurChiffre implements ActionListener {

    ////////////////////////////// VARIABLES /////////////////////////////////
    private final CalculatriceModel _calculatrice;
    private final String _chiffre;

    //////////////////////////// CONSTRUCTEURS ///////////////////////////////
    /**
     * Constructeur de la class EcouteurChiffre
     *
     * @param calculatrice modele
     */
    /**
     * Constructeur de la class EcouteurChiffre
     *
     * @param calculatrice modele
     * @param chiffre chiffre
     */
    public EcouteurChiffre(CalculatriceModel calculatrice, String chiffre) {

        super();
        this._calculatrice = calculatrice;
        this._chiffre = chiffre;

    } // EcouteurChiffre(CalculatriceModel calculatrice, String chiffre)

    ////////////////////////////// FONCTIONS /////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent ae) {
        this._calculatrice.fin = false;
        this._calculatrice.ajouterChiffreResultat(this._chiffre);
    } // actionPerformed(ActionEvent ae)

} // class EcouteurChiffre
