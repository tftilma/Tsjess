package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RookTest {
    @Test
    void testRook() {
        Rook rook = new Rook(Color.BLACK, PieceIndex.KR, null);
        assertInstanceOf(BishopBehaviour.class, rook.getBehaviour());
        assertNull(rook.getBoard());
        assertEquals(Color.BLACK, rook.getColor());
        assertEquals(PieceIndex.KR.ordinal(), rook.getIdx());
    }}
