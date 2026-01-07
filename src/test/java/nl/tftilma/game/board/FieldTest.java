package nl.tftilma.game.board;

import nl.tftilma.tsjess.board.Color;
import nl.tftilma.tsjess.piece.AbstractBehaviour;
import nl.tftilma.tsjess.piece.AbstractChessPiece;
import nl.tftilma.tsjess.piece.PieceIndex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    @Test
    void testFieldWithoutPiece(){
        Field field = new Field(1, 3);
        assertNotNull(field);
        assertNull(field.getPiece());
        assertEquals(1, field.getCol());
        assertEquals(3, field.getRow());
    }

    @Test
    void testFieldWithPiece(){
        Field field = new Field(2, 7);
        field.setPiece(new AbstractChessPiece(Color.WHITE, PieceIndex.KN, null) {
            @Override
            protected AbstractBehaviour getBehaviour() {
                return null;
            }
        });
        assertNotNull(field);
        assertNotNull(field.getPiece());
        assertEquals(Color.WHITE, field.getPiece().getColor());
        assertEquals(PieceIndex.KN.ordinal(), field.getPiece().getIdx());

        assertEquals(2, field.getCol());
        assertEquals(7, field.getRow());

        field.removePiece();
        assertNull(field.getPiece());
    }
}
