package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;


public class Bishop extends ChessPiece {
    private final Behaviour behavior;

    public Bishop(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behavior = new BishopBehaviour(this);
    }

    protected Behaviour getBehaviour() {
        return behavior;
    }
}
