package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;

class BishopEval implements Evaluation {

    @Override
    public double eval(final ChessBoard board) {
        return bishopPair(board) ? 0.4d : 0.0;
    }

    boolean bishopPair(final ChessBoard board) {
        return true;
    }
}
