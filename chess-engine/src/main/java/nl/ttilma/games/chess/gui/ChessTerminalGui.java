package nl.ttilma.games.chess.gui;

public class ChessTerminalGui implements ChessGui {
    public ChessTerminalGui() {

    }

    public void askWhitePlayer() {
        System.out.println("White player (H for Human or AI for Computer)> ");
    }

    @Override
    public void askBlackPlayer() {
        System.out.println("Black player (H for Human or AI for Computer)> ");
    }

    @Override
    public void askWhiteTimer() {
        System.out.println("How much time for white player in seconds> ");
    }

    @Override
    public void askBlackTimer() {
        System.out.println("How much time for black player in seconds> ");
    }

    @Override
    public void start() {
        System.out.println("HERE WE GO!");
    }

    public void askMove() {
        System.out.println("You turn >");
    }

    public void thinkMove() {
        System.out.println("Thinking...");
    }

    @Override
    public void terminate() {
        System.out.println("Game ended result =");
    }

}
