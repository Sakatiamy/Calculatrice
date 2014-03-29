/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.JMenuBar;
import model.CalculatriceModel;

/**
 * Class VueMenu
 *
 * @author CHAYEM Samy
 */
public class VueMenu extends JMenuBar {

    /**
     * ***************************VARIABLES*****************************
     */
    private final CalculatriceModel _calculatrice;

    /**
     * ***************************CONSTRUCTEURS*****************************
     */
    /**
     * Constructeur de la class VueMenus
     *
     * @param calculatrice modele
     */
    public VueMenu(CalculatriceModel calculatrice) {

        this._calculatrice = calculatrice;
        BarreOptions bo = new BarreOptions(calculatrice);
        this.add(bo);

    } // VueMenu(CalculatriceModel calculatrice)

} // class VueMenus
