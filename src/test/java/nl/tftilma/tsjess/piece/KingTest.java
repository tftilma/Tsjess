package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;
import org.junit.jupiter.api.Test;

import static nl.tftilma.tsjess.board.Position.COL_E;
import static nl.tftilma.tsjess.board.Position.ROW_1;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest {
    @Test
    void testKing() {
        ChessBoard board = new ChessBoard();
        King king = new King(Color.WHITE, PieceIndex.KK, board);
        king.init(board.getField(COL_E, ROW_1));
        assertInstanceOf(KingBehaviour.class, king.getBehaviour());
        assertEquals(board, king.getBoard());
        assertEquals(Color.WHITE, king.getColor());
        assertEquals(PieceIndex.KK.ordinal(), king.getIdx());
        assertEquals("k", king.abbreviation());
        assertTrue(king.isInit());
        assertEquals(1, king.valueForColor(1, 2));
    }
}
