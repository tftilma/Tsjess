package nl.ttilma.games.engine;


import nl.ttilma.games.engine.competitor.Competitor;
import nl.ttilma.games.engine.competitor.CompetitorKind;

import java.util.ArrayList;
import java.util.List;

public abstract class TimedGame implements Game {
    private List<Competitor> competitorList = new ArrayList<>();
    private boolean paused;
    private boolean ended;
    private Competitor current;

    @Override
    public void initial() {
        paused = true;
        ended = false;
        current = null;
    }

    @Override
    public void addCompetitor(final Competitor competitor) {
        competitorList.add(competitor);
    }

    @Override
    public void start() {
        paused = false;
        ended = false;
        current = competitorList.get(0);
    }

    @Override
    public void terminate() {
        paused = true;
        ended = true;
    }

    @Override
    public void pause() {
        paused = false;
    }

    @Override
    public void resume() {
        paused = true;
    }

    public boolean isEnded() {
        return ended;
    }

    public void turn() {
        if (!isEnded()) {
            if (current.getKind() == CompetitorKind.HUMAN) {
                askMove();
            } else {
                thinkMove();
            }
        }
    }

    protected abstract void thinkMove();


    public abstract void  askMove();
}
