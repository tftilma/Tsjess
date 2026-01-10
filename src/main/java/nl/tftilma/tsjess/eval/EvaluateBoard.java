package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;

public class EvaluateBoard implements Evaluation {
    private RooksEval rooksEval = new RooksEval();
    private BishopEval bishopEval = new BishopEval();


    @Override
    public double eval(ChessBoard board) {
        double val = rooksEval.eval(board)
                + bishopEval.eval(board);
        if (!board.isWhiteToMove()) {
            val *= -1;
        }
        return val;
    }
}
