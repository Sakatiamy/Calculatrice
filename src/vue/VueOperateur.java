/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controller.EcouteurEffacer;
import controller.EcouteurEgal;
import controller.EcouteurOperateur;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.CalculatriceModel;

/**
 *
 * @author CHAYEM Samy
 */
public class VueOperateur extends JPanel implements Observer {

    ///////////////////////////// VARIABLES /////////////////////////////////
    private CalculatriceModel _cm;
    private final GridLayout gl;
    private final JButton effacer;
    private final JButton plus;
    private final JButton moins;
    private final JButton diviser;
    private final JButton multiplier;
    private final JButton egal;

    //////////////////////////// CONSTRUCTEUR ///////////////////////////////
    /**
     * Constructeur de la class VueOperateur
     *
     * @param cm modele
     */
    public VueOperateur(CalculatriceModel cm) {

        gl = new GridLayout(6, 1);
        this.setLayout(gl);

        this.effacer = new JButton("Effacer");
        this.effacer.addActionListener(new EcouteurEffacer(cm));
        add(this.effacer);

        this.plus = new JButton("+");
        this.plus.addActionListener(new EcouteurOperateur(cm, 0));
        add(this.plus);

        this.moins = new JButton("-");
        this.moins.addActionListener(new EcouteurOperateur(cm, 1));
        add(this.moins);

        this.multiplier = new JButton("x");
        this.multiplier.addActionListener(new EcouteurOperateur(cm, 2));
        add(this.multiplier);

        this.diviser = new JButton("/");
        this.diviser.addActionListener(new EcouteurOperateur(cm, 3));
        add(this.diviser);

        this.egal = new JButton("=");
        this.egal.addActionListener(new EcouteurEgal(cm));
        add(this.egal);

    } // VueOperateur(CalculatriceModel cm)

    ////////////////////////////// FONCTIONS ////////////////////////////////
    @Override
    public void update(Observable o, Object arg) {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } // update(Observable o, Object arg)

} // class VueOperateur
