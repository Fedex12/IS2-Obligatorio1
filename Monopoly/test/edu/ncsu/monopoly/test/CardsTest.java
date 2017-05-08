package edu.ncsu.monopoly.test;

import edu.ncsu.monopoly.Card;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.MoneyCard;
import edu.ncsu.monopoly.test.boardScenarios.GameBoardCCGainMoney;
import junit.framework.TestCase;

public class CardsTest extends TestCase {

    private Card ccCard, chanceCard;

    private GameMaster gameMaster;

    protected void setUp() {
        gameMaster = GameMaster.instance();
        gameMaster.setGameBoard(new GameBoardCCGainMoney());
        gameMaster.setNumberOfPlayers(1);
        gameMaster.reset();
        gameMaster.setGUI(new MockGUI());
        ccCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
        chanceCard = new MoneyCard("Lose 50 dollars", -50, Card.TYPE_CHANCE);
        gameMaster.getGameBoard().addCard(ccCard);
    }

    public void testCardType() {
        assertEquals(Card.TYPE_CC, ccCard.getCardType());
        assertEquals(Card.TYPE_CHANCE, chanceCard.getCardType());
    }
}
