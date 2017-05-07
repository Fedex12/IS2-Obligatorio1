package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.ArchivoLog;
import edu.ncsu.monopoly.GameBoard;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.test.boardScenarios.GameBoardFull;
import javax.swing.JOptionPane;

public class Main {

    private static int inputNumberOfPlayers(MainWindow window) {
        ArchivoLog archivo = new ArchivoLog();
        int numPlayers = 0;
        while (numPlayers <= 0 || numPlayers > GameMaster.MAX_PLAYER) {
            String numberOfPlayers = JOptionPane.showInputDialog(window, "How many players");
            archivo.crearLog("Se ingresaron "+numberOfPlayers+" jugadores.");
            if (numberOfPlayers == null) {
                System.exit(0);
            }
            try {
                numPlayers = Integer.parseInt(numberOfPlayers);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(window, "Please input a number");
            }
            if (numPlayers <= 0 || numPlayers > GameMaster.MAX_PLAYER) {
                JOptionPane.showMessageDialog(window, "Please input a number between one and eight");
            } else {
                GameMaster.instance().setNumberOfPlayers(numPlayers);
            }
        }
        return numPlayers;
    }

    public static void main(String[] args) {
        GameMaster master = GameMaster.instance();
        MainWindow window = new MainWindow();
        GameBoard gameBoard = null;
        if (args.length > 0) {
            if (args[0].equals("test")) {
                master.setTestMode(true);
            }
            try {
                Class c = Class.forName(args[1]);
                gameBoard = (GameBoard) c.newInstance();
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(window, "Class Not Found.  Program will exit");
                System.exit(0);
            } catch (IllegalAccessException e) {
                JOptionPane.showMessageDialog(window, "Illegal Access of Class.  Program will exit");
                System.exit(0);
            } catch (InstantiationException e) {
                JOptionPane.showMessageDialog(window, "Class Cannot be Instantiated.  Program will exit");
                System.exit(0);
            }
        } else {
            gameBoard = new GameBoardFull();
        }

        
        HomeMenu inicio = new HomeMenu();
        inicio.setVisible(true);
                
       // master.startGame();
    }
}
