package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.move.Move;

import java.util.ArrayList;
import java.util.List;


class KnightBehaviour extends AbstractBehaviour {
    KnightBehaviour(final AbstractChessPiece knight) {
        super(knight);
    }

    @Override
    List<Move> generate(final Move prevMove) {
        List<Move> list = new ArrayList<>();
        final Field field = getChessPiece().getField();
        if (field == null) {
            // this piece is not yet placed on the board!
            return list;
        }

        tryLeftUpUp(list);
        tryRightUpUp(list);
        tryLeftLeftUp(list);
        tryRightRightUp(list);

        tryLeftLeftDown(list);
        tryRightRightDown(list);
        tryLeftDownDown(list);
        tryRightDownDown(list);
        return list;
    }

    private void tryLeftUpUp(List<Move> list) {
        tryDelta(list, false, (b, f) -> {
            Field toField;
            if (f.getCol() >= 1 && f.getRow() <= 5) {
                toField = b.getField(f.getCol() - 1, f.getRow() + 2);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryRightUpUp(List<Move> list) {
        tryDelta(list, false, (b, f) -> {
            Field toField;
            if (f.getCol() <= 6 && f.getRow() <= 5) {
                toField = b.getField(f.getCol() + 1, f.getRow() + 2);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryLeftLeftUp(List<Move> list) {
        tryDelta(list, false, (b, f) -> {
            Field toField;
            if (f.getCol() >= 2 && f.getRow() <= 6) {
                toField = b.getField(f.getCol() - 2, f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryRightRightUp(List<Move> list) {
        tryDelta(list, false, (b, f) -> {
            Field toField;
            if (f.getCol() <= 5 && f.getRow() <= 6) {
                toField = b.getField(f.getCol() + 2, f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryLeftLeftDown(List<Move> list) {
        tryDelta(list, false, (b, f) -> {
            Field toField;
            if (f.getCol() >= 2 && f.getRow() >= 1) {
                toField = b.getField(f.getCol() - 2, f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryRightRightDown(List<Move> list) {
        tryDelta(list, false, (b, f) -> {
            Field toField;
            if (f.getCol() <= 5 && f.getRow() >= 1) {
                toField = b.getField(f.getCol() + 2, f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryLeftDownDown(List<Move> list) {
        tryDelta(list, false, (b, f) -> {
            Field toField;
            if (f.getCol() >= 1 && f.getRow() >= 2) {
                toField = b.getField(f.getCol() - 1, f.getRow() - 2);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    private void tryRightDownDown(List<Move> list) {
        tryDelta(list, false, (b, f) -> {
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
