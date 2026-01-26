package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.BasicEngine;
import nl.tftilma.tsjess.engine.Engine;
import org.junit.jupiter.api.Test;

class KnightEvalTest {
    @Test
    void testKnightEval() {
        Engine engine = new BasicEngine();
        KnightEval knightEval = new KnightEval(engine);
        knightEval.eval(new ChessBoard());
    }
}
