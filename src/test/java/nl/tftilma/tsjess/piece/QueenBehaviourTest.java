package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.tftilma.tsjess.piece.PieceIndex.*;
import static org.junit.jupiter.api.Assertions.*;

import static nl.tftilma.tsjess.board.Position.*;

class QueenBehaviourTest {
    @Test
    void testGenerate() {
        ChessBoard board = new ChessBoard();

        Piece queen = board.findPiece(Color.WHITE, QQ.ordinal());
        assertNotNull(queen);
        assertInstanceOf(Queen.class, queen);
        board.setPiece(COL_H, ROW_7, queen); // WQQ on h7

        Piece blackRook = board.findPiece(Color.BLACK, KR.ordinal());
        board.setPiece(COL_G, ROW_8, blackRook); // BKR on g8

        Piece whiteRook = board.findPiece(Color.WHITE, KR.ordinal());
        board.setPiece(COL_H, ROW_5, whiteRook); // WKR on h5

        List<Move> moveList = queen.generate(null);
        assertNotNull(moveList);
        assertEquals(16, moveList.size());

        testMove(moveList.get(0), COL_G, ROW_7, null); // Qh7-g7
        testMove(moveList.get(1), COL_F, ROW_7, null); // Qh7-f7
        testMove(moveList.get(2), COL_E, ROW_7, null); // Qh7-e7
        testMove(moveList.get(3), COL_D, ROW_7, null); // Qh7-d7
        testMove(moveList.get(4), COL_C, ROW_7, null); // Qh7-c7
        testMove(moveList.get(5), COL_B, ROW_7, null); // Qh7-b7
        testMove(moveList.get(6), COL_A, ROW_7, null); // Qh7-a7

        testMove(moveList.get(7), COL_H, ROW_8, null); // Qh7-h8

        testMove(moveList.get(8), COL_H, ROW_6, null); // Qh7-h6

        testMove(moveList.get(9), COL_G, ROW_8, blackRook); // Qh7xg8

        testMove(moveList.get(10), COL_G, ROW_6, null); // Qh7-g6
        testMove(moveList.get(11), COL_F, ROW_5, null); // Qh7-f5
        testMove(moveList.get(12), COL_E, ROW_4, null); // Qh7-e4
        testMove(moveList.get(13), COL_D, ROW_3, null); // Qh7-d3
        testMove(moveList.get(14), COL_C, ROW_2, null); // Qh7-c2
        testMove(moveList.get(15), COL_B, ROW_1, null); // Qh7-b1
    }

    private void testMove(Move move, int toCol, int toRow, Piece captured) {
        assertEquals(COL_H, move.getFrom().getCol());
        assertEquals(ROW_7, move.getFrom().getRow());
        assertEquals(toCol, move.getTo().getCol());
        assertEquals(toRow, move.getTo().getRow());
        assertEquals(captured, move.getCaptured());
    }
}
