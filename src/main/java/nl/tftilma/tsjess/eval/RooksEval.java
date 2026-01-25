package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

class RooksEval implements Evaluation {
    private final Engine engine;

    RooksEval(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public double eval(final ChessBoard board) {
        return rooksConnectedBonus(board)
                + activityRooks(board);
    }

    double activityRooks(final ChessBoard board) {
        return 0.1;
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
