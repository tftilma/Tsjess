package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.BasicEngine;
import nl.tftilma.tsjess.engine.Engine;
import org.junit.jupiter.api.Test;

public class KingEvalTest {
    @Test
    void testKingEval() throws ChessException {
        Engine engine = new BasicEngine();
        KingEval kingEval = new KingEval(engine);
        kingEval.eval(new ChessBoard());
    }
}
