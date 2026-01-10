package nl.tftilma.tsjess.run;

import nl.tftilma.game.AbstractGame;
import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Player;

public class Tsjess extends AbstractGame  {
    private final ChessBoard board = new ChessBoard();
    private Player whitePlayer;
    private Player blackPlayer;

    public Tsjess(AbstractBoard board, Player whitePlayer, Player blackPlayer) {
        super(board);
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
    }

    public void init() {
        board.init();
    }

    public void run() {

    }

    static void main() {
        System.out.println("Starting Tsjess");
        Player whitePlayer = new Player(Player.KindPlayer.HUMAN, "Ikke");
        Player blackPlayer = new Player(Player.KindPlayer.HUMAN, "Jij");
        Tsjess tsjessGame = new Tsjess(new ChessBoard(),
                whitePlayer, blackPlayer);
        tsjessGame.init();
        tsjessGame.run();
        System.out.println("Quiting Tsjess");
    }
}
