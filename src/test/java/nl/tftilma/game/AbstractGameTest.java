package nl.tftilma.game;

import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.game.board.Field;
import nl.tftilma.tsjess.move.Move;
import org.junit.jupiter.api.Test;

public class AbstractGameTest {
     @Test
    void testAbstractGame() {
         class MyGame extends AbstractGame {
             public MyGame(AbstractBoard board) {
                 super(board);
             }
         }
         AbstractBoard abstractBoard = new AbstractBoard(2, 2) {
             @Override
             public void setShortcuts(Field[][] fields) {

             }

             @Override
             public void play(Move move) {}
         };
         MyGame myGame = new MyGame(abstractBoard);
         myGame.playMove(new Move(
                 new Field(0,0),
                 new Field(1,1)
                 ));

     }
}
