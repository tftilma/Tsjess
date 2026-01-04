package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.tftilma.tsjess.piece.PieceIndex.KN;
import static org.junit.jupiter.api.Assertions.*;

class RookBehaviourTest {
    @Test
    void testTryRookNotPlaced() {
        ChessBoard board = new ChessBoard();
        Rook rook = new Rook(Color.WHITE, PieceIndex.KR, board);
        assertNotNull(rook.getBehaviour());
        List<Move> moveList = rook.generate(null);
        assertNotNull(moveList);
        assertTrue(moveList.isEmpty());
    }

    @Test
    void testTryRookPlaced() {
        ChessBoard board = new ChessBoard();
        Rook rook = new Rook(Color.WHITE, PieceIndex.KR, board);
        board.emptyBoard();
        board.setPiece(3, 1, rook);

        Piece knight = board.findPiece(Color.BLACK, KN.ordinal());
        assertInstanceOf(Knight.class, knight);
        board.setPiece(3, 7, knight);

        List<Move> moveList = rook.generate(null);
        assertNotNull(moveList);
        assertFalse(moveList.isEmpty());

        assertEquals(14, moveList.size());

        testMove(moveList.get(0), 2, 1, null); // Rd2-c2
        testMove(moveList.get(1), 1, 1, null); // Rd2-b2
        testMove(moveList.get(2), 0, 1, null); // Rd2-a2

        testMove(moveList.get(3), 4, 1, null); // Rd2-e2
        testMove(moveList.get(4), 5, 1, null); // Rd2-f2
        testMove(moveList.get(5), 6, 1, null); // Rd2-g2
        testMove(moveList.get(6), 7, 1, null); // Rd2-h2

        testMove(moveList.get(7), 3, 2, null); // Rd2-d3
        testMove(moveList.get(8), 3, 3, null); // Rd2-d4
        testMove(moveList.get(9), 3, 4, null); // Rd2-d5
        testMove(moveList.get(10), 3, 5, null); // Rd2-d6
        testMove(moveList.get(11), 3, 6, null); // Rd2-d7
        testMove(moveList.get(12), 3, 7, knight); // Rd2xd8

        testMove(moveList.get(13), 3, 0, null);
    }

    private void testMove(Move move, int toCol, int toRow, Piece captured) {
        assertEquals(3, move.getFrom().getCol());
        assertEquals(1, move.getFrom().getRow());
        assertEquals(toCol, move.getTo().getCol());
        assertEquals(toRow, move.getTo().getRow());
        assertEquals(captured, move.getCaptured());
    }
}
