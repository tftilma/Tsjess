package nl.tftilma.tsjess.board;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class Player {
    public enum KindPlayer {
        HUMAN, COMPUTER;
    }

    private final KindPlayer kindPlayer;
    private final String name;
    
    public Player(KindPlayer kindPlayer, final String name) {
        this.kindPlayer = kindPlayer;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
  
    public KindPlayer getKindPlayer() {
        return kindPlayer;
    }

}
