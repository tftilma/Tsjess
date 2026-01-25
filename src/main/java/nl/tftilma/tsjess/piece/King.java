package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

import static nl.tftilma.tsjess.board.Position.*;

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

    @Override
    public String abbreviation() {
        return "k";
    }


    public boolean isInit() {
        if (super.isInit()) {
            final Field field = getField();
            // king must be on e1(white) or e8(black)
            int homeRank = valueForColor(ROW_1, ROW_8);
            if (field.getCol() != COL_E) {
                throw new IllegalStateException();
            }
            if (field.getRow() != homeRank) {
                throw new IllegalStateException();
            }
            return true;
        } else {
            return false;
        }

    }
}
