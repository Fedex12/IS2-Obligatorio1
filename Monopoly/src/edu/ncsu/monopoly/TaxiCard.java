/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ncsu.monopoly;

import static java.awt.SystemColor.window;
import javax.swing.JOptionPane;

/**
 *
 * @author Federico
 */
public class TaxiCard extends Card {

    int type;

    public TaxiCard(int cardType) {
        type = cardType;
    }

    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
        int pos = 0;
        while (pos <= 0 || pos > GameMaster.MAX_PLAYER) {
            String resp = JOptionPane.showInputDialog(window, "You can move between one and six positions, enter the number of positions you want to advance.");

            try {
                pos = Integer.parseInt(resp);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please input a number");
            }
            if (pos <= 0 || pos > 8) {
                JOptionPane.showMessageDialog(null, "Please input a number between one and six");
            } else {
                GameMaster.instance().movePlayer(currentPlayer, pos);
            }
        }

    }

    public int getCardType() {
        return type;
    }

    public String getLabel() {
        return "Puedes tomar un taxi y moverte entre una y seis posiciones.";
    }
}
