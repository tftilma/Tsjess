package nl.tftilma.tsjess;

import nl.tftilma.game.AbstractGame;
import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Player;
import nl.tftilma.tsjess.move.Move;

public class Tsjess extends AbstractGame  {
    private final ChessBoard board = new ChessBoard();
    private final Player whitePlayer;
    private final Player blackPlayer;

    public Tsjess(AbstractBoard board, Player whitePlayer, Player blackPlayer) {
        super(board);
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
    }

    public void init() {
        board.init();
    }

    public void run() {
        System.out.println(board);
        //Move move = whitePlayer.think(board);
        //playMove(move);

        //System.out.println(board);
        //move = blackPlayer.think(board);
        //playMove(move);
    }

    static void main() {
        System.out.println("Starting Tsjess");
        Tsjess tsjessGame = new Tsjess(new ChessBoard(), Player.createHuman(), Player.createHuman());
        tsjessGame.init();
        tsjessGame.run();
        System.out.println("Quiting Tsjess");
    }
}
