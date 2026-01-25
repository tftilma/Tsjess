package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {

    @Test
    void testBishop() {
        Bishop bishop = new Bishop(Color.WHITE, PieceIndex.QB, null);
        assertInstanceOf(BishopBehaviour.class, bishop.getBehaviour());
        assertNull(bishop.getBoard());
        assertEquals(Color.WHITE, bishop.getColor());
        assertEquals(PieceIndex.QB.ordinal(), bishop.getIdx());
    }
}
