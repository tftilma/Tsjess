package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KnightTest {
    @Test
    void testKnight() {
        Knight knight = new Knight(Color.WHITE, PieceIndex.QN, null);
        assertInstanceOf(KnightBehaviour.class, knight.getBehaviour());
        assertNull(knight.getBoard());
        assertEquals(Color.WHITE, knight.getColor());
        assertEquals(PieceIndex.QN.ordinal(), knight.getIdx());
    }
}
