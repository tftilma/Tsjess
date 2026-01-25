package nl.tftilma.tsjess.engine;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.move.Move;

abstract class BotPlayer extends Player {
    protected Engine engine;

    public BotPlayer(final Engine engine) {
        super();
        this.engine = engine;
    }

    public boolean isBot() {
        return true;
    }

    public String mutterMate() {
        return "I got you now";
    }

    public String mutterLosingPiece() {
        return "Oops";
    }

    public Move think(final ChessBoard board) {
        return engine.think(board);
    }
}
