package nl.tftilma.tsjess.board;

import nl.tftilma.tsjess.move.Move;
import org.junit.jupiter.api.Test;

import static nl.tftilma.game.board.Field.*;
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

    @Test
    void testPlayGame1() {
        ChessBoard cb = new ChessBoard();
        cb.init();
        System.out.println(cb);

        cb.play(new Move(E2, E4));
        System.out.println(cb);

        cb.play(new Move(E7, E5));
        System.out.println(cb);

        cb.play(new Move(G1, F3));
        System.out.println(cb);

        cb.play(new Move(G8, F6));
        System.out.println(cb);

        cb.play(new Move(F3, E5));
        System.out.println(cb);
    }

    @Test
    void testPlayGame2() {
        ChessBoard cb = new ChessBoard();
        cb.init();
        System.out.println(cb);

        cb.play(new Move(E2, E4));
        System.out.println(cb);

        cb.play(new Move(D7, D5));
        System.out.println(cb);

        cb.play(new Move(E4, D5));
        System.out.println(cb);

        cb.play(new Move(E7, E5));
        System.out.println(cb);

        cb.play(new Move(D5, E6, cb.getField(E5).getPiece())); // d7xe6 e.p.
        System.out.println(cb);
    }



}
