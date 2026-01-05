package nl.tftilma.tsjess.run;

import nl.tftilma.game.AbstractGame;
import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.tsjess.board.ChessBoard;

public class Tsjess extends AbstractGame  {
    private final ChessBoard board = new ChessBoard();

    public Tsjess(AbstractBoard board) {
        super(board);
    }

    public void init() {
        board.init();
    }

    public void run() {

    }

    static void main() {
        System.out.println("Starting Tsjess");
        Tsjess tsjessGame = new Tsjess(new ChessBoard());
        tsjessGame.init();
        tsjessGame.run();
        System.out.println("Quiting Tsjess");
    }
}
