package nl.ttilma.games.chess.pieces;

import nl.ttilma.games.chess.behavior.ChessBehavior;
import nl.ttilma.games.chess.behavior.PawnBehavior;
import nl.ttilma.games.chess.board.ChessBoard;

public class Pawn extends ChessPiece {
    private boolean promoteable = true;

    public Pawn(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new PawnBehavior(chessBoard, id));
    }

    public boolean isPromoteable() {
        return promoteable;
    }

    public void promote(ChessBehavior newBehavior) {
        if (!promoteable) {
            throw new AlreadyPromotedException();
        }
        this.setBehavior(newBehavior);
        this.promoteable = false;
    }

    public void unpromote() {
        if (promoteable) {
            throw new NotYetPromotedException();
        }
        this.setBehavior(new PawnBehavior(getChessBoard(), getId()));
        this.promoteable = true;
    }

}
