package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;

import java.util.List;
import java.util.function.BiFunction;

public abstract class AbstractBehaviour {
    private final Piece chessPiece;

    AbstractBehaviour(final Piece chessPiece) {
        this.chessPiece = chessPiece;
    }

    abstract List<Move> generate(Move prevMove);

    protected Piece getChessPiece() {
        return chessPiece;
    }

    protected void tryRight(List<Move> list, boolean many) {
        tryDelta(list, many, (b, f) -> {
            Field toField;
            if (f.getCol() <= 6) {
                toField = b.getField(f.getCol() + 1, f.getRow());
            } else {
                toField = null;
            }
            return toField;
        });
    }

    protected void tryLeft(List<Move> list, boolean many) {
        tryDelta(list, many, (b, f) -> {
            final Field toField;
            if (f.getCol() >= 1) {
                toField = b.getField(f.getCol() - 1, f.getRow());
            } else {
                toField = null;
            }
            return toField;
        });
    }

    protected void tryUp(List<Move> list, boolean many) {
        tryDelta(list, many, (b, f) -> {
            final Field toField;
            if (f.getRow() <= 6) {
                toField = b.getField(f.getCol(), f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    protected void tryDown(List<Move> list, boolean many) {
        tryDelta(list, many, (b, f) -> {
            final Field toField;
            if (f.getRow() >= 1) {
                toField = b.getField(f.getCol(), f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    protected void tryRightDown(List<Move> list, boolean many) {
        tryDelta(list, many, (b, f) -> {
            final Field toField;
            if (f.getCol() < 7 && f.getRow() > 0) {
                toField = b.getField(f.getCol() + 1, f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    protected void tryLeftDown(List<Move> list, boolean many) {
        tryDelta(list, many, (b, f) -> {
            final Field toField;
            if (f.getCol() > 0 && f.getRow() > 0) {
                toField = b.getField(f.getCol() - 1, f.getRow() - 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    protected void tryRightUp(List<Move> list, boolean many) {
        tryDelta(list, many, (b, f) -> {
            final Field toField;
            if (f.getCol() < 7 && f.getRow() < 7) {
                toField = b.getField(f.getCol() + 1, f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    protected void tryLeftUp(List<Move> list, boolean many) {
        tryDelta(list, many, (b, f) -> {
            final Field toField;
            if (f.getCol() > 0 && f.getRow() < 7) {
                toField = b.getField(f.getCol() - 1, f.getRow() + 1);
            } else {
                toField = null;
            }
            return toField;
        });
    }

    protected void tryDelta(List<Move> list, boolean many, BiFunction<ChessBoard, Field, Field> func) {
        final Field field = chessPiece.getField();
        ChessBoard board = chessPiece.getBoard();
        boolean stop = false;
        Field toField = func.apply(board, field);
        while (!stop && toField != null) {
            final Piece foundPiece = toField.getPiece();
            if (foundPiece == null) {
                list.add(new Move(field, toField));
            } else {
                stop = true;
                if (foundPiece.getColor() != chessPiece.getColor()) {
                    // capture
                    list.add(new Move(field, toField));
                }
            }
            if (!many) {
                stop = true;
            }

            if (!stop) {
                // NEXT move!
                toField = func.apply(board, toField);
            }
        }
    }

    public int valueForColor(int forWhite, int forBlack) {
        return getChessPiece().isWhite() ? forWhite : forBlack;
    }

}
