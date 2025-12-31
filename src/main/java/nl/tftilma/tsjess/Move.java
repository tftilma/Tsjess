package nl.tftilma.tsjess;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;

public class Move {
    private final Field from;
    private final Field to;
    private Piece captured;

    public Move(final int fromCol, final int fromRow, final int toCol, final int toRow) {
        this(new Field(fromCol, fromRow), new Field(toCol, toRow));
    }

    public Move(final int fromCol, final int fromRow, final int toCol, final int toRow, final Piece captured) {
        this(new Field(fromCol, fromRow), new Field(toCol, toRow), captured);
    }

    public Move(final Field from, final Field to) {
        this.from = from;
        this.to = to;
        this.captured = null;
    }

    public Move(final Field from, final Field to, final Piece captured) {
        this(from, to);
        this.captured = captured;
    }

    public Field getFrom() {
        return from;
    }

    public Field getTo() {
        return to;
    }

    public Piece getCaptured() {
        return captured;
    }

}
