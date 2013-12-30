package nl.home.ttilma.tsjess;

import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.engine.GameEngine;
import nl.home.ttilma.tsjess.engine.TsjessGameEngine;
import nl.home.ttilma.tsjess.gui.ConsoleTsjessGui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class TsjessPvP {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private ConsoleTsjessGui gui = new ConsoleTsjessGui();
    private GameEngine engine = new TsjessGameEngine();
    
    public static void main(String[] args) {
        logger.info("TsjessPvP (c) by Tsjisse Tilma");
        TsjessPvP tsjess = new TsjessPvP();
        tsjess.playGame();
        logger.info("Game over!");
    }
  
    private void playGame() {
        engine.setCompStarts(gui.askIfCompShouldStart());
        
        engine.initBoard();
        while (!engine.isGameFinished()) {
            play(gui.acceptMove(engine));
        }
    }

    private void play(Move move) {
        engine.play(move);
        gui.showBoard(engine.getBoard());
    }

}
