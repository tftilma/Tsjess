package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

public class KingEval implements Evaluation {
    private final Engine engine;

    KingEval(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public double eval(final ChessBoard board) throws ChessException {
        if (board.isMate()) {
            throw new MateException();
        }
        if (board.isStaleMate()) {
            throw new StaleMateException();
        }

        double value = 0.0;
        value += castledValue(board);
        value += kingSavityValue(board);
        return value;
    }

    double castledValue(final ChessBoard board) {
        return engine.castledValue(board);
    }

    double kingSavityValue(final ChessBoard board) {
        return engine.kingSavetyValue(board);
    }
}
