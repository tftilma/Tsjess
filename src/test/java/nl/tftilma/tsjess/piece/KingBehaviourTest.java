package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;
import nl.tftilma.tsjess.move.Move;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.tftilma.tsjess.board.Position.*;
import static nl.tftilma.tsjess.piece.PieceIndex.*;
import static org.junit.jupiter.api.Assertions.*;

class KingBehaviourTest {
    @Test
    void testGenerate() {
        ChessBoard board = new ChessBoard();

        King king = (King) board.findPiece(Color.WHITE, KK.ordinal());
        assertNotNull(king);
        assertInstanceOf(King.class, king);
        king.init(board.getField(COL_E, ROW_1)); // BQB on B7

        Piece queenRook = board.findPiece(Color.WHITE, QR.ordinal());
        board.initPiece(COL_A, ROW_1, queenRook); // white queen rook on a1
        Piece kingRook = board.findPiece(Color.WHITE, KR.ordinal());
        board.initPiece(COL_H, ROW_1, kingRook); // white king rook on h1

        Piece blackRook = board.findPiece(Color.BLACK, KR.ordinal());
        board.initPiece(COL_F, ROW_2, blackRook); // black (king) rook on F2

        List<Move> moveList = king.generate(null);
        assertNotNull(moveList);
        assertEquals(7, moveList.size());

        testMove(king, moveList.getFirst(), COL_D, ROW_2, null); // Ke1-d2
        testMove(king, moveList.get(1), COL_E, ROW_2, null); // Ke1-e2
        testMove(king, moveList.get(2), COL_F, ROW_2, blackRook); // Ke1xf2
        testMove(king, moveList.get(3), COL_D, ROW_1, null); // Ke1-d1
        testMove(king, moveList.get(4), COL_F, ROW_1, null); // Ke1-f1

        testMove(king, moveList.get(5), COL_G, ROW_1, null); // 0-0
        // TODO actually wrong because Rf2 checks f1!
        testMove(king, moveList.get(6), COL_C, ROW_1, null); // 0-0-0
    }

    private void testMove(King king, final Move move,
            final int col, final int row,
            final Piece captured) {
        assertEquals(king.getClass(), move.getFrom().getPiece().getClass());
        assertEquals(COL_E, move.getFrom().getCol());
        assertEquals(ROW_1, move.getFrom().getRow());
        assertEquals(col, move.getTo().getCol());
        assertEquals(row, move.getTo().getRow());
        if (captured == null){
            assertNull(move.getCaptured());
        } else {
            assertEquals(captured.hashCode(), move.getCaptured().hashCode());
        }
    }
}
