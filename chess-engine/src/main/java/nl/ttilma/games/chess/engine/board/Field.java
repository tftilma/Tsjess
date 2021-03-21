package nl.ttilma.games.chess.engine.board;

import nl.ttilma.games.chess.engine.piece.ChessPiece;

public class Field {
    private ChessPiece piece;

    public ChessPiece getPiece() {
        return piece;
    }

    public void setPiece(final ChessPiece piece) {
        this.piece = piece;
    }
}
