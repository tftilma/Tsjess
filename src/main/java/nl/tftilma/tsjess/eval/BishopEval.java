package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

import static nl.tftilma.tsjess.piece.PieceIndex.*;

class BishopEval implements Evaluation {
    private final Engine engine;

    BishopEval(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public double eval(final ChessBoard board) {
        double value = 0.0;
        boolean kbExists = board.exists(KB);
        boolean qbExists = board.exists(QB);
        if (kbExists) {
            value += bishopValue(board, KB.ordinal());
        }
        if (qbExists) {
            value += bishopValue(board, QB.ordinal());
        }
        value += (kbExists && qbExists) ? bishopPairValue(board) : 0.0;
        return value;
    }

    private double bishopPairValue(ChessBoard board) {
        return engine.bishopPairValue(board);
    }

    private double bishopValue(ChessBoard board, int pieceIdx) {
        return engine.bishopValue(board, pieceIdx);
    }
}
