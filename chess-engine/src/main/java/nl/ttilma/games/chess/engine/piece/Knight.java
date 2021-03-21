package nl.ttilma.games.chess.engine.piece;

import nl.ttilma.games.chess.engine.behavior.KnightBehavior;
import nl.ttilma.games.chess.engine.board.ChessBoard;

public class Knight extends AbstractChessPiece {
    public Knight(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new KnightBehavior(chessBoard, id));
    }
}
