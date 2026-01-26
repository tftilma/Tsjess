package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.BasicEngine;
import nl.tftilma.tsjess.engine.Engine;
import org.junit.jupiter.api.Test;

class EvaluateBoardTest {
    @Test
    void testEvaluateEmptyBoard() throws ChessException {
        Engine engine = new BasicEngine();
        EvaluateBoard evaluateBoard = new EvaluateBoard(engine);
        evaluateBoard.eval(new ChessBoard());
    }

    @Test
    void testEvaluateStartBoard() throws ChessException {
        Engine engine = new BasicEngine();
        EvaluateBoard evaluateBoard = new EvaluateBoard(engine);
        ChessBoard board = new ChessBoard();
        board.init();
        evaluateBoard.eval(board);
    }
}
