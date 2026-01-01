package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.Move;

import java.util.ArrayList;
import java.util.List;


class RookBehaviour extends Behaviour {
    RookBehaviour(ChessPiece rook) {
        super(rook);
    }

    List<Move> generate(final Move prevMove) {
        List<Move> list = new ArrayList<>();
        tryLeft(list);
        tryRight(list);
        tryForward(list);
        tryBackwards(list);
        return list;
    }

    private void tryRight(List<Move> list) {
        tryDeltaMany(list, (b, f) -> {
            Field toField;
            if (f.getCol() <= 6) {
                toField = b.getField(f.getCol() + 1, f.getRow());
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryLeft(List<Move> list) {
        tryDeltaMany(list, (b, f) -> {
            final Field toField;
            if (f.getCol() >= 1) {
                toField = b.getField(f.getCol() - 1, f.getRow());
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryForward(List<Move> list) {
        tryDeltaMany(list, (b, f) -> {
            final Field toField;
            if (f.getRow() <= 6) {
                toField = b.getField(f.getCol(), f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }


    private void tryBackwards(List<Move> list) {
        tryDeltaMany(list, (b, f) -> {
            final Field toField;
            if (f.getRow() >= 1) {
                toField = b.getField(f.getCol(), f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }
}
