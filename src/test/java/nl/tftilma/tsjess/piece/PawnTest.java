package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.board.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {
    @Test
    void testPawn() {
        Pawn pawn = new Pawn(Color.BLACK, PieceIndex.FP.ordinal(), null);
        assertInstanceOf(PawnBehaviour.class, pawn.getBehaviour());
        assertNull(pawn.getBoard());
        assertEquals(Color.BLACK, pawn.getColor());
        assertEquals(PieceIndex.FP.ordinal(), pawn.getIdx());
    }
}
