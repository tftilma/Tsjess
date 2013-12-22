package nl.home.ttilma.tsjess.board;

import nl.home.ttilma.tsjess.board.ChessBoard;

import org.junit.Assert;
import org.junit.Test;

public class ChessBoardTest {
    @Test
    public void testEmptyBoard() {
        ChessBoard cb = new ChessBoard();
        Assert.assertEquals("Empty board", 
                ". . . . . . . . \n" + 
                ". . . . . . . . \n" +
                ". . . . . . . . \n" + 
                ". . . . . . . . \n" +
                ". . . . . . . . \n" + 
                ". . . . . . . . \n" +
                ". . . . . . . . \n" + 
                ". . . . . . . . \n" 
                , cb.print());
    }
    
    @Test
    public void testStartBoard() {
        ChessBoard cb = new ChessBoard();
        cb.initialChessBoard();
        Assert.assertEquals("Start board", 
                "r n b q k b n r \n" +
                "x x x x x x x x \n" + 
                ". . . . . . . . \n" + 
                ". . . . . . . . \n" +
                ". . . . . . . . \n" + 
                ". . . . . . . . \n" +
                "X X X X X X X X \n" +
                "R N B Q K B N R \n"
                , cb.print());
    }
}
