package nl.tftilma.tsjess.engine;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.move.Move;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public abstract class Player {
    private String name = "anonymous";
    private Engine engine;
    
    protected Player() {
    }

    public static Player createHuman() {
        return new Human();
    }

    public static Player createBot() {
        return new RandomHannah();
    }

    public Player setName(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isBot();

    public abstract Move think(ChessBoard board);

    protected boolean isValidMove(final ChessBoard board, final String playersMoveStr) {
        // TODO
        return true;
    }

    protected Move convert(final ChessBoard board, final String playersMoveStr) {
        // TODO
        return null;
    }
}
