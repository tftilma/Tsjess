package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.BasicEngine;
import nl.tftilma.tsjess.engine.Engine;
import org.junit.jupiter.api.Test;

public class PawnEvalTest {
    @Test
    void testPawnEval() {
        Engine engine = new BasicEngine();
        PawnEval pawnEval = new PawnEval(engine);
        pawnEval.eval(new ChessBoard());
    }
}
