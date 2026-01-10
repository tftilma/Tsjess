package nl.tftilma.tsjess.run;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TsjessGameTest {

    @Test
    void testGame(){
        Tsjess game = new Tsjess(new ChessBoard(), Player.human(), Player.comp());
        assertNotNull(game);
        game.init();
        game.run();
    }
}
