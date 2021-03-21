package nl.ttilma.games.chess.engine.piece;

import nl.ttilma.games.chess.engine.behavior.QueenBehavior;
import nl.ttilma.games.chess.engine.board.ChessBoard;
import nl.ttilma.games.chess.engine.piece.ChessPieceId;

public class Queen extends AbstractChessPiece {
    public Queen(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new QueenBehavior(chessBoard, id));
    }
}
