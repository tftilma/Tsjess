package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

public class Knight extends ChessPiece {
    private final Behaviour behavior;

    public Knight(final Color color, final PieceIndex idx, final ChessBoard board) {
        super(color, idx, board);
        behavior = new KnightBehaviour(this);
    }

    @Override
    public Behaviour getBehaviour() {
        return behavior;
   }
}
