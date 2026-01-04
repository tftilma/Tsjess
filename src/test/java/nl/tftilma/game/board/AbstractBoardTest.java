package nl.tftilma.game.board;

import nl.tftilma.game.board.AbstractBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbstractBoardTest {

    static class TestBoard extends AbstractBoard {
        protected TestBoard(int numCols, int numRows) {
            super(numCols, numRows);
        }
    };

    @Test
    void basicBoardTest() {
        TestBoard testBoard = new TestBoard(4, 5);
        assertNotNull(testBoard);
        assertEquals(4, testBoard.getNumCols());
        assertEquals(5, testBoard.getNumRows());

        assertNotNull(testBoard.getField(0, 0));
    }
}
