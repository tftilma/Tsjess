package nl.tftilma.game.board;

import java.util.List;

import nl.tftilma.tsjess.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;


public interface Piece {
    void place(final Field field);

     void capture();

    Color getColor();

    int getIdx();

    List<Move> generate(final Move prevMove);

    ChessBoard getBoard();

    Field getField();
}
