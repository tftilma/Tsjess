package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class Pawn extends AbstractChessPiece {
    private AbstractBehaviour behaviour;

    public Pawn(final Color color, final int idx, final ChessBoard board) {
        super(color, idx, board);
        behaviour = new PawnBehaviour(this);
    }

    @Override
    protected AbstractBehaviour getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(final AbstractBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public String abbreviation() {
        return "x";
    }
}
