package nl.tftilma.tsjess.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChessBoardTest {
    @Test
    void testToStringEmptyBoard() {
        ChessBoard cb = new ChessBoard();
        assertTrue(cb.toString().contains("CHESSBOARD\n"));
        assertTrue(cb.toString().contains("numCols=8\n"));
        assertTrue(cb.toString().contains("numRows=8\n"));
        //System.out.println(cb);

        assertEquals("""
        CHESSBOARD
        numCols=8
        numRows=8
          -  -  -  -  -  -  - \s
          -  -  -  -  -  -  - \s
          -  -  -  -  -  -  - \s
          -  -  -  -  -  -  - \s
          -  -  -  -  -  -  - \s
          -  -  -  -  -  -  - \s
          -  -  -  -  -  -  - \s
          -  -  -  -  -  -  - \s
        """, cb.toString());
    }
}
