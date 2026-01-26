package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.BasicEngine;
import nl.tftilma.tsjess.engine.Engine;
import org.junit.jupiter.api.Test;

public class RookEvalTest {
    @Test
    void testKingEval() {
        Engine engine = new BasicEngine();
        RookEval rookEval = new RookEval(engine);
        rookEval.eval(new ChessBoard());
    }
}
