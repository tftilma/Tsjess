package nl.tftilma.tsjess.run;

import nl.tftilma.tsjess.board.ChessBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TsjessGameTest {

    @Test
    void testGame(){
        Tsjess game = new Tsjess(new ChessBoard());
        assertNotNull(game);
        game.init();
        game.run();
    }
}
