package nl.ttilma.games.engine;

import nl.ttilma.games.engine.board.Board;
import nl.ttilma.games.engine.competitor.CompetitorKind;

import java.util.List;

public abstract class BoardGame {
    private Board board;

    public BoardGame(final Board board, final List<CompetitorKind> competitors) {

    }

    public abstract void setUp();


}
