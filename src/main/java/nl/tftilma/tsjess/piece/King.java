package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class King extends AbstractChessPiece {
    private final AbstractBehaviour behaviour;

    public King(final Color color, PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behaviour = new KingBehaviour(this);
    }

    @Override
    protected AbstractBehaviour getBehaviour() {
        return behaviour;
    }
}
