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
public class Knight extends AbstractChessPiece {
    public Knight(Color color) {
        super(color);
    }
    
    public Knight(Position pos, Color color) {
        super(pos, color);
    }

    @Override
    public void moveGen(ChessBoard board, List<Move> moveList) {
        tryAndCreateMoves(board, moveList,  1,  2, 1); 
        tryAndCreateMoves(board, moveList,  2,  1, 1); 
        tryAndCreateMoves(board, moveList, -1,  2, 1); 
        tryAndCreateMoves(board, moveList, -2,  1, 1); 
        
        tryAndCreateMoves(board, moveList,  1, -2, 1);
        tryAndCreateMoves(board, moveList,  2, -1, 1);
        tryAndCreateMoves(board, moveList, -1, -2, 1);
        tryAndCreateMoves(board, moveList, -2, -1, 1);
    }
    
    public String print() {
        return isWhite() ? "N" : "n";
    }
}
