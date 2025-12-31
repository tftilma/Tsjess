package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.Move;
import nl.tftilma.tsjess.board.ChessBoard;

import java.util.List;
import java.util.function.BiFunction;

public abstract class Behaviour {
    private final ChessPiece chessPiece;

    Behaviour(final ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    abstract List<Move> generate(Move prevMove);

    protected ChessPiece getChessPiece() {
        return chessPiece;
    }

    protected void tryDeltaOne(List<Move> list, BiFunction<ChessBoard, Field, Field> func) {
        ChessPiece me = getChessPiece();
        if (me.getField() == null) {
            // this piece is not yet placed on the board!
            return;
        }
        ChessBoard board = me.getBoard();

        Field toField = func.apply(board, me.getField());
        if (toField != null) {
            Piece foundPiece = toField.getPiece();
            if (foundPiece == null) {
                list.add(new Move(me.getField(), toField));
            } else {

                if (foundPiece.getColor() != me.getColor()) {
                    // capture
                    list.add(new Move(me.getField(), toField, foundPiece));
                }
            }
        }
    }

    protected void tryDeltaMany(List<Move> list, BiFunction<ChessBoard, Field, Field> func) {
        ChessPiece me = getChessPiece();
        if (me.getField() == null) {
            // this piece is not yet placed on the board!
            return;
        }
        ChessBoard board = me.getBoard();
        boolean stop = false;
        Field toField = func.apply(board, me.getField());
        while (!stop && toField != null) {
            Piece foundPiece = toField.getPiece();
            if (foundPiece == null) {
                list.add(new Move(me.getField(), toField));
            } else {
                stop = true;
                if (foundPiece.getColor() != me.getColor()) {
                    // capture
                    list.add(new Move(me.getField(), toField, foundPiece));
                }
            }

            if (!stop) {
                // NEXT move!
                toField = func.apply(board, toField);
            }
        }
    }
}
