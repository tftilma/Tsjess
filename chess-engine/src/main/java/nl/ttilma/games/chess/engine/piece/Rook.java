package nl.ttilma.games.chess.engine.piece;

import nl.ttilma.games.chess.engine.behavior.RookBehavior;
import nl.ttilma.games.chess.engine.board.ChessBoard;

public class Rook extends ChessPiece {
    public Rook(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id,  new RookBehavior(chessBoard, id));
    }
}
