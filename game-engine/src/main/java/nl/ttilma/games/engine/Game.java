package nl.ttilma.games.engine;

import nl.ttilma.games.engine.competitor.Competitor;

public interface Game {
    void initial();
    void addCompetitor(Competitor competitor);
    void start();
    void terminate();
    void pause();
    void resume();
}
