package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.tftilma.game.board.Field.*;
import static nl.tftilma.tsjess.piece.PieceIndex.*;
import static org.junit.jupiter.api.Assertions.*;

import static nl.tftilma.tsjess.board.Position.*;

class BishopBehaviourTest {
    @Test
    void testGenerate() {
        ChessBoard board = new ChessBoard();
        board.emptyBoard();

        Piece bishop = board.findPiece(Color.BLACK, QB.ordinal());
        assertNotNull(bishop);
        assertInstanceOf(Bishop.class, bishop);
        board.setPiece(B7, bishop); // BQB on B7

        Piece blackPawn = board.findPiece(Color.BLACK, AP.ordinal());
        board.setPiece(A6, blackPawn); // BAP on a6

        Piece whitePawn = board.findPiece(Color.WHITE, EP.ordinal());
        assertNotNull(whitePawn);
        assertInstanceOf(Pawn.class, whitePawn);
        board.setPiece(E4, whitePawn); // WEP on e4


        List<Move> moveList = bishop.generate(null);
        assertNotNull(moveList);
        assertEquals(5, moveList.size());

        testMove(moveList.get(0), COL_A, ROW_8, null); // Bb7-a8
        testMove(moveList.get(1), COL_C, ROW_8, null); // Bb7-c8
        testMove(moveList.get(2), COL_C, ROW_6, null); // Bb7-c6
        testMove(moveList.get(3), COL_D, ROW_5, null); // Bb7-d5
        testMove(moveList.get(4), COL_E, ROW_4, whitePawn); // Bb7xe4
    }

    private void testMove(Move move, int toCol, int toRow, Piece captured) {
        assertEquals(COL_B, move.getFrom().getCol());
        assertEquals(ROW_7, move.getFrom().getRow());
        assertEquals(toCol, move.getTo().getCol());
        assertEquals(toRow, move.getTo().getRow());
        assertEquals(captured, move.getCaptured());
    }
}
