package nl.tftilma.tsjess.move;

import nl.tftilma.tsjess.board.ChessBoard;
import org.junit.jupiter.api.Test;

class MoveGeneratorTest {
    @Test
    void testMoveGeneratorOnEmptyBoard() {
        MoveGenerator moveGenerator = new MoveGenerator();
        moveGenerator.generate(new ChessBoard());
    }
}
