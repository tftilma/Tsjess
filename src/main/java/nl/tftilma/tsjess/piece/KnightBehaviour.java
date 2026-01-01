package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.Move;

import java.util.ArrayList;
import java.util.List;


class KnightBehaviour extends Behaviour {
    KnightBehaviour(final ChessPiece knight) {
        super(knight);
    }

    List<Move> generate(final Move prevMove) {
        List<Move> list = new ArrayList<>();
        tryLeftForwardForward(list);
        tryRightForwardForward(list);
        tryLeftLeftForward(list);
        tryRightRightForward(list);

        tryLeftLeftBack(list);
        tryRightRightBack(list);
        tryLeftBackBack(list);
        tryRightBackBack(list);
        return list;
    }

    private void tryLeftForwardForward(List<Move> list) {
        tryDeltaOne(list, (b, f) -> {
            Field toField;
            if (f.getCol() >= 1 && f.getRow() <= 5) {
                toField = b.getField(f.getCol() - 1, f.getRow() + 2);
            } else {
                toField = null;
            }
            return toField;
        });
    }
    private void tryRightForwardForward(List<Move> list) {
        tryDeltaOne(list, (b, f) -> {
            Field toField;
            if (f.getCol() <= 6 && f.getRow() <= 5) {
                toField = b.getField(f.getCol() + 1, f.getRow() + 2);
            } else {
                toField = null;
            }
            return toField;
        });
    }
    private void tryLeftLeftForward(List<Move> list) {
        tryDeltaOne(list, (b, f) -> {
            Field toField;
            if (f.getCol() >= 2 && f.getRow() <= 6) {
                toField = b.getField(f.getCol() - 2, f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryRightRightForward(List<Move> list) {
        tryDeltaOne(list, (b, f) -> {
            Field toField;
            if (f.getCol() <= 5 && f.getRow() <= 6) {
                toField = b.getField(f.getCol() + 2, f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryLeftLeftBack(List<Move> list) {
        tryDeltaOne(list, (b, f) -> {
            Field toField;
            if (f.getCol() >= 2 && f.getRow() >= 1) {
                toField = b.getField(f.getCol() - 2, f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryRightRightBack(List<Move> list) {
        tryDeltaOne(list, (b, f) -> {
            Field toField;
            if (f.getCol() <= 5 && f.getRow() >= 1) {
                toField = b.getField(f.getCol() + 2, f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryLeftBackBack(List<Move> list) {
        tryDeltaOne(list, (b, f) -> {
            Field toField;
            if (f.getCol() >= 1 && f.getRow() >= 2) {
                toField = b.getField(f.getCol() - 1, f.getRow() - 2);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryRightBackBack(List<Move> list) {
        tryDeltaOne(list, (b, f) -> {
            Field toField;
            if (f.getCol() <= 6 && f.getRow() >= 2) {
                toField = b.getField(f.getCol() + 1, f.getRow() - 2);
            } else {
                toField = null;
            }
            return toField;
        });
    }
}
