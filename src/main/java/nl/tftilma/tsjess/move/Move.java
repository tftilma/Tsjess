package nl.tftilma.tsjess.move;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.piece.AbstractBehaviour;

public class Move {
    private final Field from;
    private final Field to;
    private final Piece captured;
    private AbstractBehaviour promotionBehaviour;

    public Move(final Field from, final Field to) {
        this.from = from;
        this.to = to;
        this.captured = to.getPiece();
        this.promotionBehaviour = null;
    }

    public Move(final Field from, final Field to, final AbstractBehaviour promotionBehaviour) {
        this(from, to);
        this.promotionBehaviour = promotionBehaviour;
    }

    public Move(final Field from, final Field to, final Piece captured) {
        this.from = from;
        this.to = to;
        this.captured = captured; // because en-passent
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

    public AbstractBehaviour getPromotionBehaviour() {
        return promotionBehaviour;
    }
}
