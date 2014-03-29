/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import menu.VueMenu;
import model.CalculatriceModel;
import vue.VueChiffre;
import vue.VueHistorique;
import vue.VueOperateur;
import vue.VueResultat;

/**
 * CalculatriceGraphique
 *
 * @author CHAYEM Samy
 */
public class CalculatriceGraphique extends JFrame {

    /**
     * ***************************VARIABLES*****************************
     */
    private static CalculatriceGraphique calculatrice;
    private final CalculatriceModel cm;
    private final VueMenu vm;
    private final VueChiffre vc;
    private final VueOperateur vo;
    private final VueResultat vr;
    private final VueHistorique vh;

    int startX, startY, endX, endY;
    Color color = Color.BLACK;

    /////////////////////////// CONSTRUCTEURS ////////////////////////////
    /**
     * Constructeur de la class CalculatriceGraphique
     */
    public CalculatriceGraphique() {

        super("Calculatrice");
        this.setBackground(new Color(206, 206, 206));

        this.cm = new CalculatriceModel();
        this.vm = new VueMenu(this.cm);
        this.setJMenuBar(vm);

        this.vr = new VueResultat(this.cm);
        this.cm.addObserver(vr);

        this.vc = new VueChiffre(this.cm);
        this.cm.addObserver(vc);

        this.vo = new VueOperateur(this.cm);
        this.cm.addObserver(vo);

        this.vh = new VueHistorique(this.cm);
        this.cm.addObserver(vh);

        // Split entre les chiffres et les operateurs
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                this.vc, this.vo);

        // Split entre la vue des boutons et la vue de l'historique
        JSplitPane splitPane3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                splitPane1, this.vh);
        this.add(splitPane3, BorderLayout.NORTH);

        // Split entre la vue des options et la vue du schema
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                this.vr, splitPane3);
        this.add(splitPane2, BorderLayout.NORTH);

        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    } // Graphique()

    /**
     * ***************************FONCTIONS*****************************
     */
    /**
     * Permet de lancer l'application en mode graphique
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        calculatrice = new CalculatriceGraphique();

    } // main(String[] args)

} // class CalculatriceGrpahique
