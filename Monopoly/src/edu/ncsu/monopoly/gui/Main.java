package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.GameMaster;

public class Main {

    

    public static void main(String[] args) {
        GameMaster master = GameMaster.instance();
        
        if (args.length > 0&& args[0].equals("test")) {
                master.setTestMode(true);
            }
        HomeMenu inicio = new HomeMenu();
        inicio.setVisible(true);           
       // master.startGame();
    }
}
