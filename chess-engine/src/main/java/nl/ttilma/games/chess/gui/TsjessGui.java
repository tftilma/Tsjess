package nl.ttilma.games.chess.gui;

public interface TsjessGui {
    void askMove();
    void thinkMove();

    void askWhitePlayer();
    void askBlackPlayer();

    void askWhiteTimer();
    void askBlackTimer();

    void start();
    void terminate();
}
