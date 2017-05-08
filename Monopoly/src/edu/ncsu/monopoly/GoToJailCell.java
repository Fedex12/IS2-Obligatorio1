package edu.ncsu.monopoly;

public class GoToJailCell extends Cell {

    public GoToJailCell() {
        setName("Go to Jail");
    }

    public void playAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();        
        GameMaster.instance().sendToJail(currentPlayer);
    }
}
