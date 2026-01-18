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
        //System.out.println(cb);

        assertEquals("""
        CHESSBOARD
         - - - - - - -\s
         - - - - - - -\s
         - - - - - - -\s
         - - - - - - -\s
         - - - - - - -\s
         - - - - - - -\s
         - - - - - - -\s
         - - - - - - -\s
        Captured:\s
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
        // this game from "SChaken voor Computers" tests all typical chess moves
        ChessBoard cb = new ChessBoard();
        cb.init();
        System.out.println(cb);

        cb.play(new Move(E2, E4)); // 1.e2-e4
        System.out.println(cb);

        cb.play(new Move(D7, D5)); // 1...d7-d5
        System.out.println(cb);

        cb.play(new Move(E4, D5)); // 2.e4xd5
        System.out.println(cb);

        cb.play(new Move(E7, E5)); // 2...e7-e5
        System.out.println(cb);

        cb.play(new Move(D5, E6, cb.getField(E5).getPiece())); // 3.d7xe6 e.p.
        System.out.println(cb);

        cb.play(new Move(B8, C6)); // 3...Nb8-c6
        System.out.println(cb);

        cb.play(new Move(G1, F3)); // 4.Ng1-f3
        System.out.println(cb);

        cb.play(new Move(D8, D6)); // 4...Qd8-d6
        System.out.println(cb);

        cb.play(new Move(F1, B5)); // 5.Bf1-b5
        System.out.println(cb);

        cb.play(new Move(C8, D7)); // 5...Bc8-d7
        System.out.println(cb);

        cb.play(new Move(E1, G1)); // 6.0-0 TODO
        System.out.println(cb);

        cb.play(new Move(E8, C8)); // 6...0-0-0 TODO
        System.out.println(cb);

        cb.play(new Move(E6, F7)); // 6.e6xf7
        System.out.println(cb);

        cb.play(new Move(F8, E7)); // 6...Bf8-e7
        System.out.println(cb);

        //cb.play(new Move(F7, G8, new QueenBehaviour(cb.getField(G8).getPiece()))); // 7.f7xg8(Q)
        cb.play(new Move(F7, G8, "Q")); // 7.f7xg8(Q)
        System.out.println(cb);

        cb.play(new Move(H8, G8)); // 7...Rh8xg8
        System.out.println(cb);

    }



}
