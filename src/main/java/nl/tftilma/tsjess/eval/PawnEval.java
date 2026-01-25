package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.engine.Engine;

public class PawnEval implements Evaluation {
    private final Engine engine;

    PawnEval(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public double eval(final ChessBoard board) {
        return 0;
    }

    double pawnValue(ChessBoard board,  int pieceIdx) {
        return engine.pawnValue(board, pieceIdx);
    }
}
