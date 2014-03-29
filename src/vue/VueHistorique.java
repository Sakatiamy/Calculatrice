/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controller.EcouteurReinitialiserHistorique;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import model.CalculatriceModel;

/**
 * VueHistorique
 *
 * @author CHAYEM Samy
 */
public class VueHistorique extends JPanel implements Observer {

    ///////////////////////////// VARIABLE //////////////////////////////////
    private final CalculatriceModel _cm;
    private final JButton reinitialiser;
    private final JTextArea historique;
    private final JScrollPane jsp;

    /////////////////////////// CONSTRUCTEUR ///////////////////////////////
    /**
     * Constructeur de la class VueHistorique
     *
     * @param cm modele
     */
    public VueHistorique(CalculatriceModel cm) {

        this._cm = cm;
        GridLayout gl = new GridLayout(1, 1);
        this.setLayout(gl);
        JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

        // Onglet permettant d'afficher les résultats
        JPanel ongletResultat = new JPanel();
        GridLayout gl1 = new GridLayout(2, 1);
        ongletResultat.setLayout(gl1);

        this.reinitialiser = new JButton("Reset");
        this.reinitialiser.setFont(new Font("Arial", Font.PLAIN, 20));
        this.reinitialiser.setForeground(new Color(90, 94, 107));
        this.reinitialiser.addActionListener(new EcouteurReinitialiserHistorique(cm));

        this.historique = new JTextArea();
        this.historique.setEditable(false);
        this.historique.setFont(new Font("Arial", Font.PLAIN, 16));
        this.historique.setForeground(new Color(90, 94, 107));
        this.historique.setAlignmentX(JTextArea.RIGHT_ALIGNMENT);
        this.historique.setAlignmentY(CENTER_ALIGNMENT);

        this.jsp = new JScrollPane(this.historique);
        this.jsp.setPreferredSize(new Dimension(500, 100));
        ongletResultat.add(this.jsp);
        ongletResultat.add(this.reinitialiser);
        ongletResultat.setPreferredSize(new Dimension(500, 100));
        onglets.addTab("Historique des calculs", ongletResultat);

        add(onglets);

    } // VueHistorique(CalculatriceModel cm)

    ///////////////////////////// FONCTION //////////////////////////////////
    @Override
    public void update(Observable o, Object arg) {

        if (arg.toString().equals("4")) {

            String histoCalculs = "";
            for (String calcul : this._cm.getHistorique()) {

                histoCalculs = histoCalculs + "-> " + calcul + "\n";

            }
            this.historique.setText(histoCalculs);
            this.revalidate();
            this.repaint();

        }

    } // update(Observable o, Object arg)

} // class VueHistorique
