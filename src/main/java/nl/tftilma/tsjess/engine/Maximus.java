package nl.tftilma.tsjess.engine;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.move.Move;

public class Maximus extends BotPlayer {
    public Maximus() {
        super(new BasicEngine());
    }

    @Override
    public String getName() {
        return "Maximus";
    }

    @Override
    public Move think(ChessBoard board) {
        return engine.think(board);
    }

 }
