package nl.ttilma.games.chess.engine.piece;

import nl.ttilma.games.chess.engine.behavior.ChessBehavior;
import nl.ttilma.games.chess.engine.board.ChessBoard;

public abstract class AbstractChessPiece extends  ChessPiece {
    private Color color;
    private ChessPieceId id;
    private boolean initial;
    private boolean dead;

    protected AbstractChessPiece(ChessBoard chessBoard, ChessPieceId id, ChessBehavior behavior) {
        super(chessBoard, id, behavior);
    }

//    protected AbstractChessPiece(final ChessBoard board, final ChessPieceId id) {
//        super(board, id);
//        this.color = board;
//        this.id = id;
//        initial = true;
//        dead = false;
//    }

    public Color getColor() {
        return color;
    }

    public ChessPieceId getId() {
        return id;
    }

    public void setId(ChessPieceId id) {
        this.id = id;
    }

    public boolean isInitial() {
        return initial;
    }

    public void setInitial(final boolean initial) {
        this.initial = initial;
    }


    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

}
