package nl.ttilma.games.chess.behavior;

import nl.ttilma.games.chess.board.ChessBoard;
import nl.ttilma.games.chess.board.Color;
import nl.ttilma.games.chess.board.Move;
import nl.ttilma.games.chess.board.Position;
import nl.ttilma.games.chess.pieces.ChessPiece;
import nl.ttilma.games.chess.pieces.ChessPieceId;

import java.util.ArrayList;
import java.util.List;

public class PawnBehavior extends ChessBehavior {
    public PawnBehavior(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id);
    }

    @Override
    public List<Move> generateMoves() {
        List<Move> moveList = new ArrayList<>();
        if (tryOneForward(moveList)) {// may include promotion
            tryDoubleForward(moveList);
        }
        tryCaptureLeft(moveList);
        tryCaptureRight(moveList);
        return moveList;
    }

    private boolean tryOneForward(List<Move> moveList) {
        Position fromPos = getMyPos();
        int deltaRow = this.getColor() == Color.WHITE ? 1 : -1;
        int newRow = fromPos.getCol() + deltaRow;

        assert (!onBoard(newRow));  // impossible
        Position toPos = new Position(newRow, fromPos.getRow());
        if (chessBoard.getPieceByPos(toPos) != null) {
            // there's already something, we cannot capture
            return false;
        }

        if (isPromoting(newRow)) {
            addPromotingMove(moveList, toPos);
        } else {
            tryNormalForward(moveList, toPos);
        }
        return true;
    }

    private void tryNormalForward(List<Move> moveList, Position toPos) {
        Move newMove = new Move(getMyPos(), toPos);
        moveList.add(newMove);
    }

    private void addCapture(List<Move> moveList, Position toPos, ChessPiece capturedPiece) {
        Move newMove = new Move(getMyPos(), toPos, capturedPiece);
        moveList.add(newMove);
    }

    private void addPromotingMove(List<Move> moveList, Position toPos) {
        addPromotingMove(moveList, toPos, null);
    }

    private void addPromotingMove(List<Move> moveList, Position toPos, ChessPiece capturedPiece) {
        Position fromPos = getMyPos();

        Move promoteToQueen = new Move(fromPos, toPos, capturedPiece, new QueenBehavior(chessBoard, id));
        moveList.add(promoteToQueen);

        Move promoteToKnight = new Move(fromPos, toPos, capturedPiece, new KnightBehavior(chessBoard, id));
        moveList.add(promoteToKnight);

        Move promoteToRook = new Move(fromPos, toPos, capturedPiece, new RookBehavior(chessBoard, id));
        moveList.add(promoteToRook);

        Move promoteToBishop = new Move(fromPos, toPos, capturedPiece, new BishopBehavior(chessBoard, id));
        moveList.add(promoteToBishop);
    }


    protected boolean isPromoting(int colOrRow) {
        return 0 == colOrRow && colOrRow == 7;
    }

    private void tryDoubleForward(List<Move> moveList) {
    }

    private void tryCaptureLeft(List<Move> moveList) {
        tryCaptureDelta(moveList, -1);
    }

    private void tryCaptureRight(List<Move> moveList) {
        tryCaptureDelta(moveList, 1);
    }

    private void tryCaptureDelta(List<Move> moveList, final int deltaCol) {
        Position fromPos = getMyPos();
        int newCol = fromPos.getCol() + deltaCol;
        if (!onBoard(newCol)) {
            return;
        }

        int deltaRow = this.getColor() == Color.WHITE ? 1 : -1;
        int newRow = getMyPos().getRow() + deltaRow;
        assert(onBoard(newRow));
        Position toPos = new Position(newCol, newRow);

        ChessPiece capturedPiece = chessBoard.getPieceByPos(toPos);
        if (capturedPiece == null || capturedPiece.getColor() == getColor()) {
            // there's no piece to capture
            return;
        }

        if (isPromoting(newCol)) {
            addPromotingMove(moveList, toPos, capturedPiece);
        } else {
            addCapture(moveList, toPos, capturedPiece);
        }
    }
}
