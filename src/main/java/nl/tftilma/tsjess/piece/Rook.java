package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class Rook extends AbstractChessPiece {
    private final AbstractBehaviour behaviour;

    public Rook(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behaviour = new RookBehaviour(this);
    }

    @Override
    protected AbstractBehaviour getBehaviour() {
        return behaviour;
    }

    @Override
    public String abbreviation() {
        return "r";
    }
}
