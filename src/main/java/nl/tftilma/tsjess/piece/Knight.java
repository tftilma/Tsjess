package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class Knight extends AbstractChessPiece {
    private final AbstractBehaviour behaviour;

    public Knight(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behaviour = new KnightBehaviour(this);
    }

    @Override
    protected AbstractBehaviour getBehaviour() {
        return behaviour;
   }
}
