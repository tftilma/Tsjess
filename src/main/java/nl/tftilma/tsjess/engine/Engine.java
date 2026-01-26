package nl.tftilma.tsjess.engine;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.move.Move;

public interface Engine {
    Move think(ChessBoard board);

    double kingValue(ChessBoard board);
    double pawnValue(ChessBoard board, int pieceIdx);
    double knightValue(ChessBoard board, int pieceIdx);
    double bishopValue(ChessBoard board, int pieceIdx);
    double rookValue(ChessBoard board, int pieceIdx);
    double queenValue(ChessBoard board, int pieceIdx);

    double knightPairValue(ChessBoard board);
    double bishopPairValue(ChessBoard board);
    double rooksConnectedValue(ChessBoard board);
    double castledValue(ChessBoard board);
    double kingSavetyValue(ChessBoard board);

}
