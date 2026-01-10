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

    public static Player human() {
        return new Player(KindPlayer.HUMAN, "player");
    }

    public static Player comp() {
        return new Player(KindPlayer.COMPUTER, "computer");
    }

    public String getName() {
        return name;
    }
  
    public KindPlayer getKindPlayer() {
        return kindPlayer;
    }

}
