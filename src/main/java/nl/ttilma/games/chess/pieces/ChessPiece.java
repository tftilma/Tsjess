package nl.ttilma.games.chess.pieces;

import nl.ttilma.games.chess.behavior.ChessBehavior;
import nl.ttilma.games.chess.board.ChessBoard;
import nl.ttilma.games.chess.board.Color;
import nl.ttilma.games.chess.board.Move;
import nl.ttilma.games.chess.board.Position;

import java.util.List;

public class ChessPiece {
    private final ChessPieceId id;
    private ChessBoard chessBoard;
    private Position pos;
    private ChessBehavior behavior;
    private boolean captured;
    private boolean initialSquare;

    protected ChessPiece(final ChessBoard chessBoard, final ChessPieceId id, final ChessBehavior behavior) {
        this.chessBoard = chessBoard;
        this.id = id;
        this.behavior = behavior;

        captured = false;
        initialSquare = true;
    }

    public ChessPieceId getId() {
        return id;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(final Position pos) {
        this.pos = pos;
    }

    public int getCol() {
        return pos.getCol();
    }

    public int getRow() {
        return pos.getRow();
    }

    public ChessBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(final ChessBehavior behavior) {
        this.behavior = behavior;
    }

    public void capture() {
        this.captured = true;
    }

    public void uncapture() {
        this.captured = false;
    }

    public List<Move> generateMoves() {
        return this.getBehavior().generateMoves();
    }

    public Color getColor() {
        return id.getColor();
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public boolean isCaptured() {
        return captured;
    }

    public boolean isInitialSquare() {
        return initialSquare;
    }
}
