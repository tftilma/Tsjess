package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QueenTest {
    @Test
    void testQueen() {
        Queen queen = new Queen(Color.WHITE, PieceIndex.QQ, null);
        assertInstanceOf(QueenBehaviour.class, queen.getBehaviour());
        assertNull(queen.getBoard());
        assertEquals(Color.WHITE, queen.getColor());
        assertEquals(PieceIndex.QQ.ordinal(), queen.getIdx());
    }
}