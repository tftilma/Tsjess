package nl.ttilma.games.chess.gui;

public interface ChessGui {
    void askMove();
    void thinkMove();

    void askWhitePlayer();
    void askBlackPlayer();

    void askWhiteTimer();
    void askBlackTimer();

    void start();
    void terminate();
}
