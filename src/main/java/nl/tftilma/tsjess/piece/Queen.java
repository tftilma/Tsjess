package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class Queen extends ChessPiece {
    private final Behaviour behaviour;

    public Queen(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behaviour = new QueenBehaviour(this);
    }

    public Behaviour getBehaviour() {
        return behaviour;
    }
}
