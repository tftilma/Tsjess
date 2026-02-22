package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

import static nl.tftilma.tsjess.piece.PieceIndex.KK;

public class KingEval implements Evaluation {
    private final Engine engine;

    KingEval(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public double eval(final ChessBoard board) throws ChessException {
        double value = 0.0;
        boolean kingExists = board.exists(KK);
        if (kingExists) {
            // ehm always ?
            value += kingValue(board);
        }
        if (board.isMate()) {
            throw new MateException();
        }
        if (board.isStaleMate()) {
            throw new StaleMateException();
        }

        value += castledValue(board);
        value += kingSavetyValue(board);
        return value;
    }

    double castledValue(final ChessBoard board) {
        return engine.castledValue(board);
    }

    double kingSavetyValue(final ChessBoard board) {
        return engine.kingSavetyValue(board);
    }

    private double kingValue(final ChessBoard board) {
        return engine.kingValue(board);
    }
}
