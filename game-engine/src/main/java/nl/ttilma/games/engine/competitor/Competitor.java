package nl.ttilma.games.engine.competitor;

public class Competitor {
    private CompetitorKind kind;


    public Competitor(final CompetitorKind kind) {
        this.kind = kind;
    }

    public CompetitorKind getKind() {
        return kind;
    }

    public void setKind(final CompetitorKind kind) {
        this.kind = kind;
    }
}
