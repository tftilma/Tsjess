package nl.ttilma.games.chess.engine.piece;

import nl.ttilma.games.chess.engine.behavior.KingBehavior;
import nl.ttilma.games.chess.engine.board.ChessBoard;

public class King extends AbstractChessPiece {
    public King(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new KingBehavior(chessBoard, id));
    }
}
