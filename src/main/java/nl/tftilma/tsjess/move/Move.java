package nl.tftilma.tsjess.move;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.piece.*;

public class Move {
    private final Field from;
    private final Field to;
    private final Piece captured;
    private AbstractBehaviour promotionBehaviour;

    public Move(final Field from, final Field to) {
        // most often used
        this.from = from;
        this.to = to;
        this.captured = to.getPiece();
        this.promotionBehaviour = null;
    }

    public Move(final Field from, final Field to, final AbstractBehaviour promotionBehaviour) {
        // constructor only for promotion in engine
        this(from, to);
        this.promotionBehaviour = promotionBehaviour;
    }

    public Move(final Field from, final Field to, final String promotionPiece) {
        // constructor for testing promotion
        this(from, to, BehaviourFactory.create(from, promotionPiece));
    }

    public Move(final Field from, final Field to, final Piece captured) {
        // constructor only used for en-passent
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
