package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

public class EvaluateBoard implements Evaluation {
    private final Engine engine;

    private final KnightEval knightEval;
    private final BishopEval bishopEval;
    private final RooksEval rooksEval;
    private final QueenEval queenEval;

    public EvaluateBoard(final Engine engine) {
        this.engine = engine;
        knightEval = new KnightEval(engine);
        bishopEval = new BishopEval(engine);
        rooksEval = new RooksEval(engine);
        queenEval = new QueenEval(engine);
    }

    @Override
    public double eval(final ChessBoard board) throws ChessException {
        double val = knightEval.eval(board)
                + bishopEval.eval(board)
                + rooksEval.eval(board)
                + queenEval.eval(board);
        if (!board.isWhiteToMove()) {
            val *= -1;
        }
        return val;
    }
}
