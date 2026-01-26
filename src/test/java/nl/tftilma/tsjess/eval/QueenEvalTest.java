package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.BasicEngine;
import nl.tftilma.tsjess.engine.Engine;
import org.junit.jupiter.api.Test;

public class QueenEvalTest {
    @Test
    void testQueenEval() {
        Engine engine = new BasicEngine();
        QueenEval queenEval = new QueenEval(engine);
        queenEval.eval(new ChessBoard());
    }
}
