package nl.ttilma.games.chess.engine.behavior;

import nl.ttilma.games.chess.engine.board.ChessBoard;
import nl.ttilma.games.chess.engine.move.Move;
import nl.ttilma.games.chess.engine.piece.ChessPieceId;

import java.util.ArrayList;
import java.util.List;

public class RookBehavior extends ChessBehavior {
    public RookBehavior(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id);
    }

    @Override
    public List<Move> generateMoves() {
        List<Move> moveList = new ArrayList<>();
        tryDelta(moveList, 0, 1);
        tryDelta(moveList, 1, 0);
        tryDelta(moveList, -1, 0);
        tryDelta(moveList, 0, -1);

        return moveList;
    }

}
