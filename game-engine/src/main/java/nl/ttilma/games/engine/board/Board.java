package nl.ttilma.games.engine.board;

import nl.ttilma.games.engine.piece.PieceIndex;

public class Board {
    private Field fields[];
    private PieceIndex pieceIndices[];

    public Board(final Field fields[], final PieceIndex pieceIndices[]) {
        this.fields = fields;
        this.pieceIndices = pieceIndices;
    }

    public Field[] getFields() {
        return fields;
    }

    public PieceIndex[] getPieceIndices() {
        return pieceIndices;
    }
}
