package edu.ncsu.monopoly;

public interface MonopolyGUI {

    void enableEndTurnBtn(int playerIndex);

    void enablePlayerTurn(int playerIndex);

    void enablePurchaseBtn(int playerIndex);

    int[] getDiceRoll();

    boolean isDrawCardButtonEnabled();

    boolean isEndTurnButtonEnabled();

    boolean isGetOutOfJailButtonEnabled();

    boolean isTradeButtonEnabled(int i);

    void movePlayer(int index, int from, int to);

    RespondDialog openRespondDialog(TradeDeal deal);

    TradeDialog openTradeDialog();

    void setBuyHouseEnabled(boolean b);

    void setDrawCardEnabled(boolean b);

    void setEndTurnEnabled(boolean enabled);

    void setGetOutOfJailEnabled(boolean b);

    void setPurchasePropertyEnabled(boolean enabled);

    void setRollDiceEnabled(boolean b);

    void setTradeEnabled(int index, boolean b);

    void showBuyHouseDialog(Player currentPlayer);

    void showMessage(String string);

    int showUtilDiceRoll();

    void startGame();

    void update();
}
