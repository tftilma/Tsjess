package nl.tftilma.game.board;

import nl.tftilma.tsjess.move.Move;


public abstract class AbstractBoard {
    private final int numCols;
    private final int numRows;

    private final Field[][] fields;

    protected AbstractBoard(final int numCols, final int numRows) {
        this.numCols = numCols;
        this.numRows = numRows;

        fields = new Field[numCols][numRows];
        for (int c=0; c<numCols; c++) {
            for (int r=0; r<numRows; r++) {
                fields[c][r] = new Field(c, r);
            }
        }

        setShortcuts(fields);
    }

    public abstract void setShortcuts(Field[][] fields);

    public int getNumCols() {
        return numCols;
    }

    public int getNumRows() {
        return numRows;
    }

    public Field getField(final Field field) {
        return getField(field.getCol(), field.getRow());
    }

    public Field getField(final int col, final int row) {
        return fields[col][row];
    }

    public abstract void play(final Move move);
}

