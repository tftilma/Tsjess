package nl.ttilma.games.chess.pieces;

import nl.ttilma.games.chess.behavior.BishopBehavior;
import nl.ttilma.games.chess.board.ChessBoard;

public class Bishop extends ChessPiece  {
    public Bishop(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new BishopBehavior(chessBoard, id));
    }
}
