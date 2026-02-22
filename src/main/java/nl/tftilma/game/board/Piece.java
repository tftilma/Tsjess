package nl.tftilma.game.board;

import java.util.List;

import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;


public interface Piece {
    boolean isInit();

    void init(final Field field);

    void place(final Field field);

    Field getField();

    void capture();

    boolean isCaptured();

    ChessBoard getBoard();

    boolean isWhite();

    Color getColor();

    int getIdx();

    List<Move> generate(final Move prevMove);

    String abbreviation();
}
