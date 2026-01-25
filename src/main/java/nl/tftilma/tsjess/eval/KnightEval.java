package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

import static nl.tftilma.tsjess.piece.PieceIndex.*;

public class KnightEval implements Evaluation {
    private final Engine engine;

    KnightEval(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public double eval(final ChessBoard board) {
        double value = 0.0;
        boolean knExists = board.exists(KN);
        boolean qnExists = board.exists(QN);
        if (knExists) {
            value += knightValue(board, KN.ordinal());
        }
        if (qnExists) {
            value += knightValue(board, QN.ordinal());
        }
        value += (knExists && qnExists) ? knightPairValue(board) : 0.0;
        return value;
    }

    private double knightPairValue(ChessBoard board) {
        return engine.knightPairValue(board);
    }

    private double knightValue(ChessBoard board, int pieceIdx) {
        return engine.knightValue(board, pieceIdx);
    }
}
