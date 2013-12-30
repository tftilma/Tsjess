package nl.home.ttilma.tsjess.gui;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class Player {
    private KindPlayer kindPlayer;
    private String name;
    
    public Player(KindPlayer kindPlayer, String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
  
    public KindPlayer getKindPlayer() {
        return kindPlayer;
    }

    public static enum KindPlayer {
        HUMAN, COMPUTER;
    }
}
