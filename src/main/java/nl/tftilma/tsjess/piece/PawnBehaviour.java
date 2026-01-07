package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;

import java.util.ArrayList;
import java.util.List;

public class PawnBehaviour extends AbstractBehaviour {

    public PawnBehaviour(final Pawn pawn) {
        super(pawn);
    }

    @Override
    public List<Move> generate(final Move prevMove) {
        List<Move> list = new ArrayList<>();
        final Field field = getChessPiece().getField();
        if (field == null) {
            // this piece is not yet placed on the board!
            return list;
        }
        tryCapture(list);
        if (tryOneForward(list)) {
            tryDoubleForward(list);
        }
        tryEnPassent(list, prevMove);
        return list;
    }


    private void tryCapture(List<Move> list) {
        final Field fromField = getChessPiece().getField();
        ChessBoard board = getChessPiece().getBoard();
        final int pawnDeltaRow = getChessPiece().isWhite() ? 1 : -1;
        if (fromField.getCol() > 0 ) {
            Field toField = board.getField(fromField.getCol() - 1, fromField.getRow() + pawnDeltaRow);
            createCaptureMove(list, fromField, toField);
        }
        if (fromField.getCol() < 7 ) {
            Field toField = board.getField(fromField.getCol() + 1, fromField.getRow() + pawnDeltaRow);
            createCaptureMove(list, fromField, toField);
        }
    }

    private boolean isCapture(Field fromField, Field toField) {
        return fromField.getPiece().getColor() !=
               toField.getPiece().getColor();
    }

    private void createCaptureMove(List<Move> list, Field fromField, Field toField) {
        if (toField.getPiece() != null && isCapture(fromField, toField)) {
            int promoRow = getPromoRow();
            if (toField.getRow() == promoRow) {
                promote(list, toField);
            } else {
                list.add(new Move(fromField, toField));
            }
        }
    }

    private int getPromoRow() {
        return getChessPiece().isWhite() ? 7 : 0;
    }

    private boolean tryOneForward(List<Move> list) {
        final Field field = getChessPiece().getField();
        ChessBoard board = getChessPiece().getBoard();
        Field toField = board.getField(field.getCol(), field.getRow() + valueForColor(1, -1));
        if (toField.getPiece() != null) {
            return false;
        }

        if (toField.getRow() == getPromoRow()) {
            promote(list, toField);
        } else {
            list.add(new Move(field, toField));
        }

        return true;
    }

    private boolean isOnInitialPosition() {
        return getChessPiece().getField().getRow() == valueForColor(1, 6);
    }

    private int valueForColor(int forWhite, int forBlack) {
        return getChessPiece().isWhite() ? forWhite : forBlack;
    }

    private void tryDoubleForward(List<Move> list) {
        if (isOnInitialPosition()) {
            final Field fromField = getChessPiece().getField();
            final ChessBoard board = getChessPiece().getBoard();
            Field toField = board.getField(fromField.getCol(),
                    fromField.getRow() + valueForColor(2, -2));
            if (toField.getPiece() == null) {
                list.add(new Move(fromField, toField));
            }
        }
    }

    private void promote(List<Move> list, Field toField) {
        final Field fromField = getChessPiece().getField();

        list.add(promoteQueen(fromField, toField));
        list.add(promoteRook(fromField, toField));
        list.add(promoteKnight(fromField, toField));
        list.add(promoteBishop(fromField, toField));
    }

    private Move promoteBishop(final Field field, final Field toField) {
        return new Move(field, toField, new BishopBehaviour(getChessPiece()));
    }

    private Move promoteKnight(final Field field, final Field toField) {
        return new Move(field, toField, new KnightBehaviour(getChessPiece()));
    }

    private Move promoteRook(final Field field, final Field toField) {
        return new Move(field, toField, new RookBehaviour(getChessPiece()));
    }

    private Move promoteQueen(final Field field, final Field toField) {
        return new Move(field, toField, new QueenBehaviour(getChessPiece()));
    }

    private void tryEnPassent(List<Move> list, Move prevMove) {
        if (prevMove != null) {
            final Field fromField = getChessPiece().getField();
            if (isEither (prevMove.getTo().getCol(), fromField.getCol()+1, fromField.getCol()-1)) {
                return;
            }
            if (fromField.getRow() != valueForColor(4, 3)) {
                return;
            }
            if (isDoublePawnMove(prevMove)) {
                Piece enemyPawn = prevMove.getFrom().getPiece();
                Field toField = getChessPiece().getBoard().getField(
                        prevMove.getTo().getCol(),
                        prevMove.getTo().getRow() + valueForColor(1, -1));
                list.add(new Move(fromField, toField, enemyPawn));
            }
        }
    }

    private boolean isEither(int val, int x, int y) {
        return val == x || val == y;
    }

    private boolean isDoublePawnMove(Move prevMove) {
        return  prevMove.getFrom().getRow() == valueForColor(6, 1) &&
                prevMove.getTo().getRow() == valueForColor(4, 3) &&
                prevMove.getFrom().getPiece() instanceof Pawn;
    }
}
