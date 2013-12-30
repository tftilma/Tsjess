package nl.home.ttilma.tsjess.piece;

import java.util.List;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.tsjess.board.ChessBoard;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class Bishop extends AbstractChessPiece {
    public Bishop(Color color) {
        super(color);
    }
    
    public Bishop(Position pos, Color color) {
        super(pos, color);
    }

    @Override
    public void moveGen(ChessBoard board, List<Move> moveList) {
        tryAndCreateMoves(board, moveList, -1, 1, 7);
        tryAndCreateMoves(board, moveList, 1, 1, 7);
        tryAndCreateMoves(board, moveList, -1, -1, 7);
        tryAndCreateMoves(board, moveList, 1, -1, 7);
    }
    
    public String print() {
        return isWhite() ? "B" : "b";
    }
}
