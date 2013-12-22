package nl.home.ttilma.tsjess.piece;

import java.util.List;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.piece.AbstractPiece;
import nl.home.ttilma.game.piece.Piece;
import nl.home.ttilma.tsjess.board.ChessBoard;

/**
 * 
 * @author tft
 *
 */
public class Rook extends AbstractPiece<ChessBoard> implements Piece<ChessBoard> {
    public Rook(Color color) {
        super(color);
    }

    public Rook(Position pos, Color color) {
        super(pos, color);
    }

    @Override
    public void moveGen(ChessBoard board, List<Move> moveList) {
        tryAndCreateMoves(board, moveList,  0,  1, 7); // forward
        tryAndCreateMoves(board, moveList, -1,  0, 7); // left
        tryAndCreateMoves(board, moveList,  1,  0, 7); // right
        tryAndCreateMoves(board, moveList,  0, -1, 7); // back
    }

    public String print() {
        return isWhite() ? "R" : "r";
    }
}
