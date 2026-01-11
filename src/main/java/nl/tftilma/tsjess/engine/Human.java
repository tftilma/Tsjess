package nl.tftilma.tsjess.engine;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.move.Move;

public class Human extends Player{
    public Human() {
        super();
    }

    public boolean isBot() {
        return false;
    }

    @Override
    public Move think(final ChessBoard board) {
        String playersMoveStr;
        do {
            System.out.print("Your move: ");
            //playersMoveStr = System.console().readLine();
            playersMoveStr = "e2-e4";
        } while(!isValidMove(board, playersMoveStr));
        return convert(board, playersMoveStr);
    }

    private boolean isValidMove(final ChessBoard board, final String playersMoveStr) {
        // TODO
        return true;
    }

    private Move convert(final ChessBoard board, final String playersMoveStr) {
        // TODO
        return null;
    }
}
