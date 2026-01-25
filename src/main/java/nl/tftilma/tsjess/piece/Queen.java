package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class Queen extends AbstractChessPiece {
    private final AbstractBehaviour behaviour;

    public Queen(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behaviour = new QueenBehaviour(this);
    }

    @Override
    protected AbstractBehaviour getBehaviour() {
        return behaviour;
    }

    @Override
    public String abbreviation() {
        return "q";
    }
}
