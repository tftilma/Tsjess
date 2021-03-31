package nl.ttilma.games.chess.engine.piece;

import nl.ttilma.games.chess.engine.behavior.BishopBehavior;
import nl.ttilma.games.chess.dom.board.ChessBoard;

public class Bishop extends ChessPiece {
    public Bishop(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new BishopBehavior(chessBoard, id));
    }
}
