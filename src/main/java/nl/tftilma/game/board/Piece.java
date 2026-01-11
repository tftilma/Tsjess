package nl.tftilma.game.board;

import java.util.List;

import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;


public interface Piece {
    void init(final Field field);

    void place(final Field field);

    void capture();

    boolean isCaptured();

    Color getColor();

    int getIdx();

    List<Move> generate(final Move prevMove);

    ChessBoard getBoard();

    Field getField();

    String abbreviation();

}
