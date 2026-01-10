package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.move.Move;

import java.util.ArrayList;
import java.util.List;

import static nl.tftilma.tsjess.board.Position.*;


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
        if (getChessPiece().isInit()) {
            final Field field = getChessPiece().getField();
            // king must be on e1(white) or e8(black)
            int homeRank = valueForColor(ROW_1, ROW_8);
            ChessBoard board = getChessPiece().getBoard();
            AbstractChessPiece pieceOnH18 = (AbstractChessPiece) board.getField(COL_H, homeRank).getPiece();
            if (pieceOnH18 != null && pieceOnH18.isInit()) {
                if (pieceOnH18.getColor() != getChessPiece().getColor()) {
                    // the piece on H1 has not moved but has different color, ehm how ?
                    throw new IllegalStateException();
                } else if (!(pieceOnH18 instanceof Rook)) {
                    // piece on H1 (H8) has not yet moved, but its also not a rook, ehm how ?
                    throw new IllegalStateException();
                } else {
                    // yay it is our rook and it has not yet moved!
                    checkFieldsAndAddMove(list, field, homeRank, board, COL_G, COL_F, COL_G);
                }
            }
        }
    }

    private void checkFieldsAndAddMove(List<Move> list, Field field, int homeRank, ChessBoard board, int toCol, int... cols) {
        boolean stop = false;
        for (int col: cols) {
            if (board.getField(col, homeRank).getPiece() != null) {
                // short castle: field F1/G1 (F8/G8) is NOT empty
                // long castle: field D1/C1/B1 (D8,C8, B8) is NOT empty
                stop = true;
                break;
            }
        }
        if (!stop) {
            if (!isCheck() && !isCheck(toCol, homeRank)) {
                list.add(new Move(field, board.getField(toCol, homeRank)));
            }
        }
    }

    private void tryLongCastle(List<Move> list) {
        if (getChessPiece().isInit()) {
            final Field field = getChessPiece().getField();
            // king must be on e1(white) or e8(black)
            int homeRank = valueForColor(ROW_1, ROW_8);
            ChessBoard board = getChessPiece().getBoard();
            AbstractChessPiece pieceOnA18 = (AbstractChessPiece) board.getField(COL_A, homeRank).getPiece();
            if (pieceOnA18 != null && pieceOnA18.isInit()) {
                if (pieceOnA18.getColor() != getChessPiece().getColor()) {
                    // the piece on A1(A8) has not moved but has different color, ehm how ?
                    throw new IllegalStateException();
                } else if (!(pieceOnA18 instanceof Rook)) {
                    // piece on A1 (A8) has not yet moved, but its also not a rook, ehm how ?
                    throw new IllegalStateException();
                } else {
                    // yay it is our rook and it has not yet moved!
                    checkFieldsAndAddMove(list, field, homeRank, board, COL_C, COL_D, COL_C, COL_B);
                }
            }
        }

    }

    private boolean isCheck() {
        // is our king in check right now?
        // TODO
        return false;
    }

    private boolean isCheck(final int col, final int row) {
        // assuming we move our king to (col, row), could be no change, are we in check?
        // TODO
        return false;
    }
}

