package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;

public class BehaviourFactory {
    private BehaviourFactory() {
        // no instance
    }

    public static AbstractBehaviour create(final Field from, final String behaviourPiece) {
        return switch (behaviourPiece) {
            case "Q" -> new QueenBehaviour(from.getPiece());
            case "R" -> new RookBehaviour(from.getPiece());
            case "N" -> new KnightBehaviour(from.getPiece());
            case "B" -> new BishopBehaviour(from.getPiece());
            default -> throw new IllegalStateException();
        };
    }
}
