package nl.ttilma.games.chess.behavior;

import nl.ttilma.games.chess.board.ChessBoard;
import nl.ttilma.games.chess.board.Move;
import nl.ttilma.games.chess.pieces.ChessPieceId;

import java.util.ArrayList;
import java.util.List;

public class KnightBehavior extends ChessBehavior {
    public KnightBehavior(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id);
    }

    @Override
    public List<Move> generateMoves() {
        List<Move> moveList = new ArrayList<>();
        tryDeltaStep(moveList, 1, 2);
        tryDeltaStep(moveList, -1, 2);
        tryDeltaStep(moveList, 2, 1);
        tryDeltaStep(moveList,-2, 1);

        tryDeltaStep(moveList,1,-2);
        tryDeltaStep(moveList,-1, -2);
        tryDeltaStep(moveList, 2, -1);
        tryDeltaStep(moveList,-2, -1);
        return moveList;
    }
}
