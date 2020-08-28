package nl.ttilma.games.chess.behavior;

import nl.ttilma.games.chess.board.ChessBoard;
import nl.ttilma.games.chess.board.Color;
import nl.ttilma.games.chess.board.Move;
import nl.ttilma.games.chess.board.Position;
import nl.ttilma.games.chess.pieces.ChessPiece;
import nl.ttilma.games.chess.pieces.ChessPieceId;

import java.util.List;

public abstract class ChessBehavior {
    protected final ChessPieceId id;
    protected ChessBoard chessBoard;
    protected boolean isInit;

    ChessBehavior(final ChessBoard chessBoard, final ChessPieceId id) {
        this.chessBoard = chessBoard;
        this.id = id;
        this.isInit = true;
    }

    public abstract List<Move> generateMoves();

    public ChessPieceId getId() {
        return id;
    }

    public Color getColor() {
        return id.getColor();
    }

    public Position getMyPos() {
        return chessBoard.getPosByPieceId(this.id);
    }

    public boolean tryDeltaStep(List<Move> moveList, int deltaCol, int deltaRow) {

        Position fromPos = chessBoard.getPosByPieceId(this.id);
        int newCol = fromPos.getCol() + deltaCol;
        if (!onBoard(newCol)) {
            return false;
        }

        int newRow = fromPos.getRow() + deltaRow;
        if (!onBoard(newRow)) {
            return false;
        }

        Position toPos  = new Position(newCol, newRow);
        ChessPiece capturedPiece = chessBoard.getPieceByPos(toPos);
        ChessPiece thisPiece = chessBoard.getPieceById(this.getId());
        boolean isCapture = capturedPiece != null;
        if (isCapture && capturedPiece.getColor() == thisPiece.getColor()) {
            return false;
        }

        Move move = new Move(fromPos, toPos, capturedPiece);
        moveList.add(move);
        return !isCapture;
    }

    protected boolean onBoard(int colOrRow) {
        return 0 <= colOrRow && colOrRow <= 7;
    }

    public void tryDelta(List<Move> moveList, final int deltaCol, final int deltaRow) {
        int newDeltaCol = deltaCol;
        int newDeltaRow = deltaRow;
        boolean newKeepGoing = true;
        do {
            newKeepGoing = tryDeltaStep(moveList, newDeltaCol, newDeltaRow);
            newDeltaCol += deltaCol;
            newDeltaRow += deltaRow;

        } while (newKeepGoing);
    }
}
