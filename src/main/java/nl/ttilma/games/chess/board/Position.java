package nl.ttilma.games.chess.board;

public class Position {
    public static final Position A1 = new Position(0, 0);
    public static final Position B1 = new Position(1, 0);
    public static final Position C1 = new Position(2, 0);
    public static final Position D1 = new Position(3, 0);
    public static final Position E1 = new Position(4, 0);
    public static final Position F1 = new Position(5, 0);
    public static final Position G1 = new Position(6, 0);
    public static final Position H1 = new Position(7, 0);

    public static final Position A2 = new Position(0, 1);
    public static final Position B2 = new Position(1, 1);
    public static final Position C2 = new Position(2, 1);
    public static final Position D2 = new Position(3, 1);
    public static final Position E2 = new Position(4, 1);
    public static final Position F2 = new Position(5, 1);
    public static final Position G2 = new Position(6, 1);
    public static final Position H2 = new Position(7, 1);

    public static final Position A3 = new Position(0, 2);
    public static final Position B3 = new Position(1, 2);
    public static final Position C3 = new Position(2, 2);
    public static final Position D3 = new Position(3, 2);
    public static final Position E3 = new Position(4, 2);
    public static final Position F3 = new Position(5, 2);
    public static final Position G3 = new Position(6, 2);
    public static final Position H3 = new Position(7, 2);

    public static final Position A4 = new Position(0, 3);
    public static final Position B4 = new Position(1, 3);
    public static final Position C4 = new Position(2, 3);
    public static final Position D4 = new Position(3, 3);
    public static final Position E4 = new Position(4, 3);
    public static final Position F4 = new Position(5, 3);
    public static final Position G4 = new Position(6, 3);
    public static final Position H4 = new Position(7, 3);

    public static final Position A5 = new Position(0, 4);
    public static final Position B5 = new Position(1, 4);
    public static final Position C5 = new Position(2, 4);
    public static final Position D5 = new Position(3, 4);
    public static final Position E5 = new Position(4, 4);
    public static final Position F5 = new Position(5, 4);
    public static final Position G5 = new Position(6, 4);
    public static final Position H5 = new Position(7, 4);

    public static final Position A6 = new Position(0, 5);
    public static final Position B6 = new Position(1, 5);
    public static final Position C6 = new Position(2, 5);
    public static final Position D6 = new Position(3, 5);
    public static final Position E6 = new Position(4, 5);
    public static final Position F6 = new Position(5, 5);
    public static final Position G6 = new Position(6, 5);
    public static final Position H6 = new Position(7, 5);

    public static final Position A7 = new Position(0, 6);
    public static final Position B7 = new Position(1, 6);
    public static final Position C7 = new Position(2, 6);
    public static final Position D7 = new Position(3, 6);
    public static final Position E7 = new Position(4, 6);
    public static final Position F7 = new Position(5, 6);
    public static final Position G7 = new Position(6, 6);
    public static final Position H7 = new Position(7, 6);

    public static final Position A8 = new Position(0, 7);
    public static final Position B8 = new Position(1, 7);
    public static final Position C8 = new Position(2, 7);
    public static final Position D8 = new Position(3, 7);
    public static final Position E8 = new Position(4, 7);
    public static final Position F8 = new Position(5, 7);
    public static final Position G8 = new Position(6, 7);
    public static final Position H8 = new Position(7, 7);

    private int col;
    private int row;

    public Position() {
    }

    public Position(final int col, final int row) {
        this();
        set(col, row);
    }

    public void set(final int col, final int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(final int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(final int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof Position)) {
            return false;
        }
        Position toPos = (Position) other;
        return this.col == toPos.col && this.row == toPos.row;
    }
}
