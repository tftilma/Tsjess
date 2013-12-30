package nl.home.ttilma.tsjess.gui;

import nl.home.ttilma.game.board.Board;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.engine.GameEngine;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class ConsoleTsjessGui extends AbstractTsjessGui{
    public void showBoard(Board board) {
        board.print();
    }

    public boolean askIfCompShouldStart() {
        // TODO Auto-generated method stub
        return false;
    }

    public Move acceptMove(GameEngine engine) {
        Move move = null;
        do {
            Position fromField = askFromField();
            Position toField = toFromField();
            move = new Move(fromField, toField);
        } while (!engine.isValid(move));
        return move;
    }

    private Position toFromField() {
        // TODO Auto-generated method stub
        return null;
    }

    private Position askFromField() {
        // TODO Auto-generated method stub
        return null;
    }
}
