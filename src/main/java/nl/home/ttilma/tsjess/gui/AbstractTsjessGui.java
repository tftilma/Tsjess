package nl.home.ttilma.tsjess.gui;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public abstract class AbstractTsjessGui {
    private Player playerWhite;
    private Player playerBlack;
    
    public Player getPlayerWhite() {
        return playerWhite;
    }
    public void setPlayerWhite(Player playerWhite) {
        this.playerWhite = playerWhite;
    }
    public Player getPlayerBlack() {
        return playerBlack;
    }
    public void setPlayerBlack(Player playerBlack) {
        this.playerBlack = playerBlack;
    }
}
