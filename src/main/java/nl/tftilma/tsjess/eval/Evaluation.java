package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;

public interface Evaluation {
    double eval(final ChessBoard board) throws ChessException;
}
