package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.BasicEngine;
import nl.tftilma.tsjess.engine.Engine;
import org.junit.jupiter.api.Test;


class BishopEvalTest {
    @Test
    void testBishopEval()  {
        Engine engine = new BasicEngine();
        BishopEval bishopEval = new BishopEval(engine);
        bishopEval.eval(new ChessBoard());
    }
}
