package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.Move;

import java.util.ArrayList;
import java.util.List;

class BishopBehaviour extends Behaviour {
    BishopBehaviour(final ChessPiece bishop) {
        super(bishop);
    }

    List<Move> generate(Move prevMove) {
        List<Move> list = new ArrayList<>();
        final Field field = getChessPiece().getField();
        if (field == null) {
            // this piece is not yet placed on the board!
            return list;
        }
        tryBishop(list);

        return list;
    }

}
