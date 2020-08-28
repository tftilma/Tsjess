package nl.ttilma.games.chess.board;

import nl.ttilma.games.chess.behavior.ChessBehavior;
import nl.ttilma.games.chess.pieces.ChessPiece;

public class Move {
    private final Position fromPosition;
    private final Position toPosition;
    private ChessPiece capturedPiece;
    private ChessBehavior promotedBehavior;

    public Move(final Position fromPosition, final Position toPosition) {
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public Move(final Position fromPosition, final Position toPosition,  final ChessPiece capturedPiece) {
        this(fromPosition, toPosition);
        this.capturedPiece = capturedPiece;
    }

    public Move(final Position fromPosition, final Position toPosition,  final ChessPiece capturedPiece,
                final ChessBehavior promotedBehavior) {
        this(fromPosition, toPosition);
        this.capturedPiece = capturedPiece;
        this.promotedBehavior = promotedBehavior;
    }

    public Position getFromPosition() {
        return fromPosition;
    }

    public Position getToPosition() {
        return toPosition;
    }

    public ChessPiece getCapturedPiece() {
        return capturedPiece;
    }

    public ChessBehavior getPromotedBehavior() {
        return promotedBehavior;
    }

    public void setPromotedBehavior(ChessBehavior promotedBehavior) {
        this.promotedBehavior = promotedBehavior;
    }
}
