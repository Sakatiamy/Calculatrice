/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import model.CalculatriceModel;

/**
 *
 * @author CHAYEM Samy
 */
public class BarreOptions extends JMenu {

    ////////////////////////////// VARIABLES /////////////////////////////////
    private final CalculatriceModel _calculatrice;
    private final JCheckBoxMenuItem hexa;

    //////////////////////////// CONSTRUCTEUR ////////////////////////////////
    /**
     * Constructeur de la class BarreOptions
     *
     * @param calculatrice modele
     */
    public BarreOptions(final CalculatriceModel calculatrice) {

        super("Options");
        this._calculatrice = calculatrice;

        // item permettant de quitter l'application
        this.hexa = new JCheckBoxMenuItem("Mode hexadecimal");
        this.hexa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
                KeyEvent.CTRL_MASK));
        this.hexa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _calculatrice.modeHexadecimal(hexa.getState());
            }
        });
        add(this.hexa);

    } // BarreOptions(final CalculatriceModel calculatrice)

} // class BarreOptions
