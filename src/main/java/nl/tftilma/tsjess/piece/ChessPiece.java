package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

import java.util.List;

public abstract class ChessPiece implements Piece {
    private final ChessBoard board;
    private final Color color;
    private final int idx;
    private Field field;

    public ChessPiece(final Color color, final int idx, final ChessBoard board) {
        this.color = color;
        this.idx = idx;
        this.board = board;
    }

    public ChessPiece(final Color color, final PieceIndex pieceIdx, final ChessBoard board) {
        this.color = color;
        this.idx = pieceIdx.ordinal();
        this.board = board;
    }

    public void place(final Field field) {
        this.field = field;
    }

    public void capture() {
        this.field = null;
    }

    public Color getColor() {
        return color;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }



    public int getIdx() {
        return idx;
    }

    protected abstract Behaviour getBehaviour();

    public final List<Move> generate(final Move prevMove) {
        return getBehaviour().generate(prevMove);
    }

    public ChessBoard getBoard() {
        return board;
    }

    public Field getField() {
        return field;
    }
}
