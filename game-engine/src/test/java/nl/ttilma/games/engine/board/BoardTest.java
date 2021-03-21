package nl.ttilma.games.engine.board;

import nl.ttilma.games.engine.piece.PieceIndex;
import org.junit.Test;

public class BoardTest {
    @Test
    public void testBoard() {
        final Field fields[] = new Field[9];
        final PieceIndex pieceIndices[] = null;
        Board board = new Board(fields, pieceIndices);
    }
}
