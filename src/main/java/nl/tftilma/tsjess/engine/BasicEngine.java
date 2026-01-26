package nl.tftilma.tsjess.engine;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.move.Move;

/**
 * In this basic engine, we don't care about the board
 */
public class BasicEngine implements Engine {
    @Override
    public Move think(final ChessBoard board) {
        return null;
    }

    @Override
    public double kingValue(ChessBoard board) {
        return 99999.0d;
    }

    @Override
    public double pawnValue(ChessBoard board, int pieceIdx) {
        return 1.0d;
    }

    @Override
    public double knightValue(final ChessBoard board, int pieceIdx) {
        return 3.0d;
    }

    @Override
    public double bishopValue(final ChessBoard board, int pieceIdx) {
        return 3.05d;
    }

    @Override
    public double rookValue(ChessBoard board, int pieceIdx) {
        return 5.0d;
    }

    @Override
    public double queenValue(final ChessBoard board, final int pieceIdx) {
        return 9.0d;
    }

    @Override
    public double knightPairValue(final ChessBoard board) {
        return 0.07d;
    }

    @Override
    public double bishopPairValue(final ChessBoard board) {
        return 0.4d;
    }

    @Override
    public double rooksConnectedValue(final ChessBoard board) {
        return 0.07d;
    }

    @Override
    public double castledValue(ChessBoard board) {
        return 0.8;
    }

    @Override
    public double kingSavetyValue(ChessBoard board) {
        return 0;
    }
}
