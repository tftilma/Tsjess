package nl.ttilma.games.chess.engine.behavior;

import nl.ttilma.games.chess.engine.board.ChessBoard;
import nl.ttilma.games.chess.engine.piece.Color;
import nl.ttilma.games.chess.engine.move.Move;
import nl.ttilma.games.chess.engine.board.Position;
import nl.ttilma.games.chess.engine.piece.ChessPiece;
import nl.ttilma.games.chess.engine.piece.ChessPieceId;

import java.util.ArrayList;
import java.util.List;

public class KingBehavior extends ChessBehavior {

    public KingBehavior(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id);
    }

    @Override
    public List<Move> generateMoves() {
        List<Move> moveList = new ArrayList<>();
        tryDeltaStep(moveList, -1, -1);
        tryDeltaStep(moveList, 0, -1);
        tryDeltaStep(moveList, 1, -1);

        tryDeltaStep(moveList,-1, 0);
        tryDeltaStep(moveList,1, 0);

        tryDeltaStep(moveList,-1, 1);
        tryDeltaStep(moveList, 0, 1);
        tryDeltaStep(moveList,1, 1);

        if (isInit) {
            if (!isCheck()) {
                // if King no longer on initial square it cannot castle either way
                tryShortCastle(moveList);
                tryLongCastle(moveList);
            }
        }
        return moveList;
    }

    private boolean isCheck() {
        // TODO
        return false;
    }

    private boolean isCheckOn(Position pos) {
        // TODO
        return false;
    }


    private void tryShortCastle(List<Move> moveList) {
        ChessPiece kingRook;
        if (this.getColor() == Color.WHITE) {
            kingRook = chessBoard.getPieceById(ChessPieceId.WKR);
        } else {
            kingRook = chessBoard.getPieceById(ChessPieceId.BKR);
        }

        if (kingRook.isCaptured()) {
            // the king-rook has already been captured
            return;
        }

        if (!kingRook.isInitialSquare()) {
            // the king-rook has moved, short-castle no longer allowed
            return;
        }

        if (this.getColor() == Color.WHITE) {
            if (chessBoard.getPieceByPos(Position.F1) != null) {
                return;  // no piece on F1 allowed
            }
            if (isCheckOn(Position.F1)) {
                return; //no check on F1 allowed
            }
            if (chessBoard.getPieceByPos(Position.G1) != null) {
                return; // no piece on G1 allowed
            }
            if (isCheckOn(Position.G1)) {
                return; //no check on G1 allowed
            }
            Move move = new Move(Position.E1, Position.G1);
            moveList.add(move);
        } else {
            if (chessBoard.getPieceByPos(Position.F8) != null) {
                return;  // no piece on F8 allowed
            }
            if (isCheckOn(Position.F8)) {
                return; //no check on F8 allowed
            }

            if (chessBoard.getPieceByPos(Position.G8) != null) {
                return;  // no piece on G8 allowed
            }
            if (isCheckOn(Position.G8)) {
                return; //no check on G8 allowed
            }

            Move move = new Move(Position.E8, Position.G8);
            moveList.add(move);
        }
    }

    private  void tryLongCastle(List<Move> moveList) {
        ChessPiece queenRook;
        if (this.getColor() == Color.WHITE) {
            queenRook = chessBoard.getPieceById(ChessPieceId.WQR);
        } else {
            queenRook = chessBoard.getPieceById(ChessPieceId.BQR);
        }

        if (!queenRook.isCaptured()) {
            // the queen-rook has already been captured
            return;
        }

        if (!queenRook.isInitialSquare()) {
            // the queen-rook has moved, long-castle no longer allowed
            return;
        }

        if (this.getColor() == Color.WHITE) {
            if (chessBoard.getPieceByPos(Position.D1) != null) {
                return;  // no piece on D1 allowed
            }
            if (isCheckOn(Position.D1)) {
                return; //no check on D1 allowed
            }
            if (chessBoard.getPieceByPos(Position.C1) != null) {
                return; // no piece on C1 allowed
            }
            if (isCheckOn(Position.C1)) {
                return; //no check on C1 allowed
            }
            if (chessBoard.getPieceByPos(Position.B1) != null) {
                return; // no piece on B1 allowed
            }
            Move move = new Move(Position.E1, Position.C1);
            moveList.add(move);
        } else {
            if (chessBoard.getPieceByPos(Position.D8) != null) {
                return;  // no piece on D8 allowed
            }
            if (isCheckOn(Position.D8)) {
                return; //no check on D1 allowed
            }
            if (chessBoard.getPieceByPos(Position.C8) != null) {
                return;  // no piece on C8 allowed
            }
            if (isCheckOn(Position.C8)) {
                return; //no check on C8 allowed
            }

            if (chessBoard.getPieceByPos(Position.B8) != null) {
                return;  // no piece on B8 allowed
            }
            Move move = new Move(Position.E8, Position.C8);
            moveList.add(move);
        }
    }
}
