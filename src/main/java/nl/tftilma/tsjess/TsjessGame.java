package nl.tftilma.tsjess;

import nl.tftilma.game.AbstractGame;
import nl.tftilma.tsjess.board.ChessBoard;

public class TsjessGame extends AbstractGame {
    private final ChessBoard board = new ChessBoard();

    public void init() {
        board.init();
    }

    public void run() {

    }


}
