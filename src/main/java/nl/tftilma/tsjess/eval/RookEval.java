package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

class RookEval implements Evaluation {
    private final Engine engine;

    RookEval(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public double eval(final ChessBoard board) {
        return rooksConnectedBonus(board);
    }

    double rookValue(ChessBoard board,  int pieceIdx) {
        return engine.rookValue(board, pieceIdx);
    }

    double rooksConnectedBonus(final ChessBoard board) {
        if (rooksConnected(board)) {
            return engine.rooksConnectedValue(board);
        } else {
            return 0.0d;
        }
    }

    boolean rooksConnected(final ChessBoard board) {
        return true;
    }
}
