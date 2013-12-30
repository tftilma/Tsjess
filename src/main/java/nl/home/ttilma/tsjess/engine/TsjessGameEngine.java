package nl.home.ttilma.tsjess.engine;

import java.util.List;

import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.engine.AbstractGameEngine;
import nl.home.ttilma.game.engine.GameEngine;
import nl.home.ttilma.tsjess.board.ChessBoard;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class TsjessGameEngine extends AbstractGameEngine<ChessBoard> implements GameEngine {
    public TsjessGameEngine() {
        super(new ChessBoard());
    }
    
    public void initBoard() {
        getBoard().initialBoard();
    }

    @Override
    public void play(Move move) {
        getBoard().play(move);
    }
   
    @Override
    public Move thinkMove() {
        //List<Move> moveList = getBoard().moveGen();
        return null;
    }

    @Override
    public boolean isValid(Move move) {
        List<Move> moveList = getBoard().moveGen();
        return moveList.contains(move);
    }
}
