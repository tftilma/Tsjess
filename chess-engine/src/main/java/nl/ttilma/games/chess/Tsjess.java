package nl.ttilma.games.chess;

import nl.ttilma.games.chess.engine.TsjessEngine;
import nl.ttilma.games.chess.engine.TsjessGame;
import nl.ttilma.games.chess.gui.ChessTerminalGui;

public class Tsjess {
    private final TsjessGame game = new TsjessGame(new ChessTerminalGui(), new TsjessEngine());

    public static void main(String[] args) {
        System.out.println("WELCOME TO TSJESS");
        Tsjess tsjess = new Tsjess();
        tsjess.start();
        System.out.println("THANK YOU FOR PLAYING TSJESS");
    }

    private void start() {
        game.run();
    }
}
