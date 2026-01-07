package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;


public class Bishop extends AbstractChessPiece {
    private final AbstractBehaviour behaviour;

    public Bishop(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behaviour = new BishopBehaviour(this);
    }

    @Override
    protected AbstractBehaviour getBehaviour() {
        return behaviour;
    }

    @Override
    public String abbreviation() {
        return "b";
    }


}
