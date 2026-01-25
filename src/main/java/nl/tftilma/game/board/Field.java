package nl.tftilma.game.board;

public class Field {
    private final int col;
    private final int row;
    private Piece piece;

    public static Field A1;
    public static Field A2;
    public static Field A3;
    public static Field A4;
    public static Field A5;
    public static Field A6;
    public static Field A7;
    public static Field A8;

    public static Field B1;
    public static Field B2;
    public static Field B3;
    public static Field B4;
    public static Field B5;
    public static Field B6;
    public static Field B7;
    public static Field B8;

    public static Field C1;
    public static Field C2;
    public static Field C3;
    public static Field C4;
    public static Field C5;
    public static Field C6;
    public static Field C7;
    public static Field C8;

    public static Field D1;
    public static Field D2;
    public static Field D3;
    public static Field D4;
    public static Field D5;
    public static Field D6;
    public static Field D7;
    public static Field D8;

    public static Field E1;
    public static Field E2;
    public static Field E3;
    public static Field E4;
    public static Field E5;
    public static Field E6;
    public static Field E7;
    public static Field E8;

    public static Field F1;
    public static Field F2;
    public static Field F3;
    public static Field F4;
    public static Field F5;
    public static Field F6;
    public static Field F7;
    public static Field F8;

    public static Field G1;
    public static Field G2;
    public static Field G3;
    public static Field G4;
    public static Field G5;
    public static Field G6;
    public static Field G7;
    public static Field G8;

    public static Field H1;
    public static Field H2;
    public static Field H3;
    public static Field H4;
    public static Field H5;
    public static Field H6;
    public static Field H7;
    public static Field H8;


    public Field(final int col, final int row) {
        this.col = col;
        this.row = row;
        piece = null;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (piece == null) {
            sb.append(" ");
        } else {
            sb.append(piece);
        }
        return sb.toString();
    }
}
