package nl.ttilma.games.chess.pieces;

import nl.ttilma.games.chess.behavior.RookBehavior;
import nl.ttilma.games.chess.board.ChessBoard;

public class Rook extends ChessPiece {
    public Rook(final ChessBoard chessBoard, ChessPieceId id) {
        super(chessBoard, id, new RookBehavior(chessBoard, id));
    }
}
