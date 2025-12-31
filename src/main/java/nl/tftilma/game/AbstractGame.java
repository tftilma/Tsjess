package nl.tftilma.game;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.Move;

public abstract class AbstractGame {
    public void playMove(final Move move) {
        Field from = move.getFrom();

    }
}
