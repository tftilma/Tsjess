package nl.ttilma.games.chess.board;

import nl.ttilma.games.chess.pieces.ChessPiece;

public class Field {
    private ChessPiece piece;

    public ChessPiece getPiece() {
        return piece;
    }

    public void setPiece(final ChessPiece piece) {
        this.piece = piece;
    }
}
