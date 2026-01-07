package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.move.Move;

import java.util.ArrayList;
import java.util.List;


class RookBehaviour extends AbstractBehaviour {
    RookBehaviour(AbstractChessPiece rook) {
        super(rook);
    }

    @Override
    List<Move> generate(final Move prevMove) {
        List<Move> list = new ArrayList<>();
        final Field field = getChessPiece().getField();
        if (field == null) {
            // this piece is not yet placed on the board!
            return list;
        }

        tryLeft(list, true);
        tryRight(list, true);
        tryUp(list, true);
        tryDown(list, true);
        return list;
    }
}
