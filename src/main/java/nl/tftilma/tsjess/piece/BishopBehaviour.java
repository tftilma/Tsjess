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
        tryLeftUp(list);
        tryRightUp(list);
        tryLeftDown(list);
        tryRightDown(list);
        return list;
    }

    private void tryRightDown(List<Move> list) {
        tryDeltaMany(list, (b, f) -> {
            final Field toField;
            if (f.getCol() < 7 && f.getRow() > 0) {
                toField = b.getField(f.getCol() + 1, f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryLeftDown(List<Move> list) {
        tryDeltaMany(list, (b, f) -> {
            final Field toField;
            if (f.getCol() > 0 && f.getRow() > 0) {
                toField = b.getField(f.getCol() - 1, f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryRightUp(List<Move> list) {
        tryDeltaMany(list, (b, f) -> {
            final Field toField;
            if (f.getCol() < 7 && f.getRow() < 7) {
                toField = b.getField(f.getCol() + 1, f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryLeftUp(List<Move> list) {
        tryDeltaMany(list, (b, f) -> {
            final Field toField;
            if (f.getCol() > 0 && f.getRow() < 7) {
                toField = b.getField(f.getCol() - 1, f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }
}
