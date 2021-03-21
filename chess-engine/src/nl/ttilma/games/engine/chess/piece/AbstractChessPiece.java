package nl.ttilma.games.engine.chess.piece;

public abstract class AbstractChessPiece {
    private Color color;

    protected AbstractChessPiece(final Color color) {
        this.color = color;
    }
}
