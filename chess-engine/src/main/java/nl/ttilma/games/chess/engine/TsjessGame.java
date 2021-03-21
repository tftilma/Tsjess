package nl.ttilma.games.chess.engine;

import nl.ttilma.games.engine.Game;
import nl.ttilma.games.engine.TimedGame;
import nl.ttilma.games.chess.gui.TsjessGui;

public class TsjessGame extends TimedGame implements Game {
    private final TsjessGui gui;
    private final TsjessEngine engine;

    public TsjessGame(final TsjessGui gui, final TsjessEngine engine) {
       this.gui = gui;
        this.engine = engine;
    }

    @Override
    protected void thinkMove() {
        gui.thinkMove();
    }

    @Override
    public void askMove() {
        gui.askMove();
    }

    public void run() {
        gui.askWhitePlayer();
        gui.askBlackPlayer();
        gui.askWhiteTimer();
        gui.askBlackTimer();
        gui.start();
    }
}
