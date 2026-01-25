package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

import java.util.List;

public abstract class AbstractChessPiece implements Piece {
    private final ChessBoard board;
    private final Color color;
    private final int idx;
    private Field field;
    private boolean init = true;

    AbstractChessPiece(final Color color, final int idx, final ChessBoard board) {
        this.color = color;
        this.idx = idx;
        this.board = board;
    }

    public AbstractChessPiece(final Color color, final PieceIndex pieceIdx, final ChessBoard board) {
        this.color = color;
        this.idx = pieceIdx.ordinal();
        this.board = board;
    }

    @Override
    public void init(final Field field) {
        this.field = field;
        field.setPiece(this);
        this.init = true;
    }

    @Override
    public void place(final Field field) {
        this.field = field;
        this.init = false;
    }

    @Override
    public void capture() {
        this.field = null;
    }

    @Override
    public boolean isCaptured() {
        return field == null;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    @Override
    public int getIdx() {
        return idx;
    }

    protected abstract AbstractBehaviour getBehaviour();

    @Override
    public final List<Move> generate(final Move prevMove) {
        return getBehaviour().generate(prevMove);
    }

    @Override
    public ChessBoard getBoard() {
        return board;
    }

    @Override
    public Field getField() {
        return field;
    }


    @Override
    public String toString() {
        if (isWhite()) {
            return this.abbreviation().toLowerCase();
        } else {
            return this.abbreviation().toUpperCase();
        }
    }

    public boolean isInit() {
        return init;
    }

    public int valueForColor(int forWhite, int forBlack) {
        return isWhite() ? forWhite : forBlack;
    }
}
