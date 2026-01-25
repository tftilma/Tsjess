package nl.tftilma.tsjess;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TsjessGameTest {

    @Test
    void testGame(){
        Tsjess game = new Tsjess(new ChessBoard(), Player.createHuman(), Player.createBot());
        assertNotNull(game);
        game.init();
        game.run();
    }
}
