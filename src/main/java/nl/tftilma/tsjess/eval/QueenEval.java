package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

import static nl.tftilma.tsjess.piece.PieceIndex.QQ;

public class QueenEval implements Evaluation {
    private final Engine engine;

    QueenEval(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public double eval(final ChessBoard board) {
        if (!board.exists(QQ)) {
            return 0.0d;
        } else {
            return queenValue(board) +
                    activityQueen(board);
        }
    }

    double queenValue(final ChessBoard board) {
        return engine.queenValue(board, QQ.ordinal());
    }

    double activityQueen(final ChessBoard board) {
        return engine.queenValue(board, QQ.ordinal());
    }

}
