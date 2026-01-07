package nl.tftilma.game.board;

public class Field {
    private final int col;
    private final int row;
    private Piece piece = null;

    public Field(final int col, final int row) {
        this.col = col;
        this.row = row;
    }

    public void setPiece(final Piece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
