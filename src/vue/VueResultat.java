/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.CalculatriceModel;

/**
 * VueResultat
 *
 * @author CHAYEM Samy
 */
public class VueResultat extends JPanel implements Observer {

    ///////////////////////////// VARIABLE //////////////////////////////////
    private final CalculatriceModel _cm;
    private final JTextField resultat;

    /////////////////////////// CONSTRUCTEUR ///////////////////////////////
    /**
     * Constructeur de la class VueResultat
     *
     * @param cm modele
     */
    public VueResultat(CalculatriceModel cm) {

        this._cm = cm;
        this.setBackground(Color.WHITE);
        GridLayout gl = new GridLayout(1, 1);
        this.setLayout(gl);

        // Panel permettant d'afficher les résultats
        JPanel ongletResultat = new JPanel();
        ongletResultat.setBackground(Color.WHITE);
        GridLayout gl1 = new GridLayout(1, 1);
        ongletResultat.setLayout(gl1);

        this.resultat = new JTextField();
        this.resultat.setEditable(false);
        this.resultat.setFont(new Font("Arial", Font.PLAIN, 20));
        this.resultat.setForeground(new Color(90, 94, 107));
        this.resultat.setHorizontalAlignment(JTextField.RIGHT);
        this.resultat.setAlignmentY(CENTER_ALIGNMENT);
        ongletResultat.setPreferredSize(new Dimension(400, 50));
        ongletResultat.add(this.resultat);

        add(ongletResultat);

    } // VueResultat(CalculatriceModel cm)

    ///////////////////////////// FONCTION //////////////////////////////////
    @Override
    public void update(Observable o, Object arg) {

        if (arg.toString().equals("1")) {

            this.resultat.setText(this._cm.getResultat());
            this.revalidate();
            this.repaint();

        }

    } // update(Observable o, Object arg)

} // class VueResultat
