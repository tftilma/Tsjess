package nl.ttilma.games.chess.pieces;

import nl.ttilma.games.chess.behavior.KingBehavior;
import nl.ttilma.games.chess.board.ChessBoard;

public class King extends ChessPiece {
    public King(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new KingBehavior(chessBoard, id));
    }

}
