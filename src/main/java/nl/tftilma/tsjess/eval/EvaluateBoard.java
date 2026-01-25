package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

public class EvaluateBoard implements Evaluation {
    private final PawnEval pawnEval;
    private final KnightEval knightEval;
    private final BishopEval bishopEval;
    private final RooksEval rooksEval;
    private final QueenEval queenEval;
    private final KingEval kingEval;

    public EvaluateBoard(final Engine engine) {
        pawnEval = new PawnEval(engine);
        knightEval = new KnightEval(engine);
        bishopEval = new BishopEval(engine);
        rooksEval = new RooksEval(engine);
        queenEval = new QueenEval(engine);
        kingEval = new KingEval(engine);
    }

    @Override
    public double eval(final ChessBoard board) throws ChessException {
        double val = pawnEval.eval(board)
                + knightEval.eval(board)
                + bishopEval.eval(board)
                + rooksEval.eval(board)
                + queenEval.eval(board)
                + kingEval.eval(board);
        if (!board.isWhiteToMove()) {
            val *= -1;
        }
        return val;
    }
}
