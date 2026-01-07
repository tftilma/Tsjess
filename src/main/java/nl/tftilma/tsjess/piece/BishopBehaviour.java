package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.move.Move;

import java.util.ArrayList;
import java.util.List;

class BishopBehaviour extends AbstractBehaviour {
    BishopBehaviour(final AbstractChessPiece bishop) {
        super(bishop);
    }

    @Override
    List<Move> generate(Move prevMove) {
        List<Move> list = new ArrayList<>();
        final Field field = getChessPiece().getField();
        if (field == null) {
            // this piece is not yet placed on the board!
            return list;
        }
        tryLeftUp(list, true);
        tryRightUp(list, true);
        tryLeftDown(list, true);
        tryRightDown(list, true);

        return list;
    }

}
