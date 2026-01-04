package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.tftilma.tsjess.piece.PieceIndex.*;
import static org.junit.jupiter.api.Assertions.*;

class BishopBehaviourTest {
    @Test
    void testTryRookPlaced() {
        ChessBoard board = new ChessBoard();
        board.emptyBoard();

        Piece bishop = board.findPiece(Color.BLACK, QB.ordinal());
        assertNotNull(bishop);
        assertInstanceOf(Bishop.class, bishop);
        board.setPiece(1, 6, bishop); // BQB on B7

        Piece blackPawn = board.findPiece(Color.BLACK, AP.ordinal());
        board.setPiece(0, 5, blackPawn); // BAP on a6

        Piece whitePawn = board.findPiece(Color.WHITE, EP.ordinal());
        assertNotNull(whitePawn);
        assertInstanceOf(Pawn.class, whitePawn);
        board.setPiece(4, 3, whitePawn); // WEP on e4


        List<Move> moveList = bishop.generate(null);
        assertNotNull(moveList);
        assertEquals(5, moveList.size());

        testMove(moveList.get(0), 0, 7, null); // Bb7-a8
        testMove(moveList.get(1), 2, 7, null); // Bb7-c8
        testMove(moveList.get(2), 2, 5, null); // Bb7-c6
        testMove(moveList.get(3), 3, 4, null); // Bb7-d5
        testMove(moveList.get(4), 4, 3, whitePawn); // Bb7xe4
    }

    private void testMove(Move move, int toCol, int toRow, Piece captured) {
        assertEquals(1, move.getFrom().getCol());
        assertEquals(6, move.getFrom().getRow());
        assertEquals(toCol, move.getTo().getCol());
        assertEquals(toRow, move.getTo().getRow());
        assertEquals(captured, move.getCaptured());
    }
}
