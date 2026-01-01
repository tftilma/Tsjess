package nl.tftilma.tftilma.tsjess;

import nl.tftilma.tsjess.TsjessGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TsjessGameTest {

    @Test
    void testGame(){
        TsjessGame game = new TsjessGame();
        assertNotNull(game);
        game.init();
        game.run();
    }
}
