package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class King extends ChessPiece {
    private final Behaviour behaviour;

    public King(final Color color, PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behaviour = new KingBehaviour(this);
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }
}
