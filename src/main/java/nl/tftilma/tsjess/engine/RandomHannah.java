package nl.tftilma.tsjess.engine;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.move.Move;

public class RandomHannah extends BotPlayer {
    public RandomHannah() {
        super(new RandomEngine());
    }

    @Override
    public String getName() {
        return "Random Hannah";
    }
}
