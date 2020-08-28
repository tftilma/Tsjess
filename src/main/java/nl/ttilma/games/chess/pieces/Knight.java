package nl.ttilma.games.chess.pieces;

import nl.ttilma.games.chess.behavior.KnightBehavior;
import nl.ttilma.games.chess.board.ChessBoard;

public class Knight extends ChessPiece {
    public Knight(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new KnightBehavior(chessBoard, id));
    }
}
