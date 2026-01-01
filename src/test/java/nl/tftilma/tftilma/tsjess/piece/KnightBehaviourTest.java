package nl.tftilma.tftilma.tsjess.piece;

import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;
import nl.tftilma.tsjess.piece.Knight;
import nl.tftilma.tsjess.piece.Queen;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.tftilma.tsjess.piece.PieceIndex.*;
import static org.junit.jupiter.api.Assertions.*;

class KnightBehaviourTest {
    @Test
    void testTryKnightPlaced() {
        ChessBoard board = new ChessBoard();
        board.emptyBoard();

        Piece knight = board.findPiece(Color.WHITE, KN.ordinal());
        assertNotNull(knight);
        assertInstanceOf(Knight.class, knight);
        board.setPiece(6, 0, knight); // WKN on G1

        Piece queen = board.findPiece(Color.BLACK, QQ.ordinal());
        assertNotNull(queen);
        assertInstanceOf(Queen.class, queen);
        board.setPiece(5, 2, queen); // BQQ on f3

        List<Move> moveList = knight.generate(null);
        assertNotNull(moveList);
        assertEquals(3, moveList.size());

        testMove(moveList.get(0), 5, 2, queen); // Ng1xf3
        testMove(moveList.get(1), 7, 2, null); // Ng1-h3
        testMove(moveList.get(2), 4, 1, null); // Ng1-e2
    }

    private void testMove(Move move, int toCol, int toRow, Piece captured) {
        assertEquals(6, move.getFrom().getCol());
        assertEquals(0, move.getFrom().getRow());
        assertEquals(toCol, move.getTo().getCol());
        assertEquals(toRow, move.getTo().getRow());
        assertEquals(captured, move.getCaptured());
    }
}
