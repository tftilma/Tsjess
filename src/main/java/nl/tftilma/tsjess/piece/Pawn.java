package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;


public class Pawn extends ChessPiece {
    private final Behaviour behavior;

    public Pawn(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behavior = new PawnBehaviour(this);
    }

    public Pawn(final Color color, final int idx, final ChessBoard board) {
        super(color, idx, board);
        behavior = new PawnBehaviour(this);
    }

    public Behaviour getBehaviour() {
        return behavior;
    }
}
