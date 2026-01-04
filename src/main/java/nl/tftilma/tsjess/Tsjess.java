package nl.tftilma.tsjess;

import java.nio.charset.Charset;

public class Tsjess {
    public static void main() {
        System.out.println("Starting Tsjess");
        TsjessGame tsjessGame = new TsjessGame();
        tsjessGame.init();
        tsjessGame.run();
        System.out.println("Quiting Tsjess");
        System.out.println(Charset.defaultCharset());

    }
}
