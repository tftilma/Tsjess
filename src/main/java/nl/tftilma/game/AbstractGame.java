package nl.tftilma.game;

import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.move.Move;

public abstract class AbstractGame {
    private final AbstractBoard board;

    public AbstractGame(final AbstractBoard board) {
        this.board = board;
    }

    public void playMove(final Move move) {
        Field from = move.getFrom();
        Field to = move.getTo();

    }
}
