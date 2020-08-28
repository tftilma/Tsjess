package nl.ttilma.games.chess.behavior;

import nl.ttilma.games.chess.board.ChessBoard;
import nl.ttilma.games.chess.board.Move;
import nl.ttilma.games.chess.pieces.ChessPieceId;

import java.util.ArrayList;
import java.util.List;

public class BishopBehavior extends ChessBehavior {
    public BishopBehavior(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id);
    }

    @Override
    public List<Move> generateMoves() {
        List<Move> moveList = new ArrayList<>();
        tryDelta(moveList, 1, 1);
        tryDelta(moveList, -1, 1);
        tryDelta(moveList, -1, -1);
        tryDelta(moveList, 1, -1);
        return moveList;
    }
}
