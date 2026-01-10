package nl.tftilma.tsjess.eval;

import nl.tftilma.tsjess.board.ChessBoard;

class RooksEval implements Evaluation {
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
            // depending on opening, and state of game
            return 0.17d;
        } else {
            return 0.0d;
        }
    }

    boolean rooksConnected(final ChessBoard board) {
        return true;
    }
}
