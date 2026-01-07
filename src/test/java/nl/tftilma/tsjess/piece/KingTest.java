package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest {
    @Test
    void testKing() {
        King king = new King(Color.WHITE, PieceIndex.KK, null);
        assertInstanceOf(KingBehaviour.class, king.getBehaviour());
        assertNull(king.getBoard());
        assertEquals(Color.WHITE, king.getColor());
        assertEquals(PieceIndex.KK.ordinal(), king.getIdx());
    }
}
