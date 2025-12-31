package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class Rook extends ChessPiece {
    private final Behaviour behavior;

    public Rook(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behavior = new RookBehaviour(this);
    }

    public Behaviour getBehaviour() {
        return behavior;
    }
}
