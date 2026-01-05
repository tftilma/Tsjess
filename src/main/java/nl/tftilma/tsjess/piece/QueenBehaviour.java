package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.move.Move;

import java.util.ArrayList;
import java.util.List;


public class QueenBehaviour extends Behaviour {
    QueenBehaviour(final ChessPiece queen) {
        super(queen);
    }

    List<Move> generate(Move prevMove) {
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

        tryLeftUp(list, true);
        tryRightUp(list, true);
        tryLeftDown(list, true);
        tryRightDown(list, true);
        return list;
    }

}
