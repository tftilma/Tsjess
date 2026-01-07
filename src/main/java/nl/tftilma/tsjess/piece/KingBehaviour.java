package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.move.Move;

import java.util.ArrayList;
import java.util.List;


class KingBehaviour extends AbstractBehaviour {
    KingBehaviour(final King king) {
        super(king);
    }

    @Override
    List<Move> generate(Move prevMove) {
        List<Move> list = new ArrayList<>();
        final Field field = getChessPiece().getField();
        if (field == null) {
            // this piece is not yet placed on the board!
            return list;
        }

        tryLeftUp(list, false);
        tryUp(list, false);
        tryRightUp(list, false);

        tryLeft(list, false);
        tryRight(list, false);

        tryLeftDown(list, false);
        tryDown(list, false);
        tryRightDown(list, false);

        tryShortCastle(list);
        tryLongCastle(list);
        return list;
    }

    private void tryShortCastle(List<Move> list) {
        // TODO
    }

    private void tryLongCastle(List<Move> list) {
        // TODO
    }
}
