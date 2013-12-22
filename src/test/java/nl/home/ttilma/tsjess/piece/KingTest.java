package nl.home.ttilma.tsjess.piece;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import org.junit.Test;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.tsjess.board.ChessBoard;
import nl.home.ttilma.tsjess.board.ChessPieceIdx;
import nl.home.ttilma.tsjess.piece.King;


public class KingTest {
    @Test
    public void testPrintWhite() {
        Assert.assertEquals(true, new King(Color.WHITE).isWhite());
        
    }
    @Test
    public void testPrintBlack() {
        Assert.assertEquals(true, new King(Color.BLACK).isBlack());
    }
    
    @Test
    public void testMoveGen() {
        ChessBoard board = new ChessBoard();
        Position pos = new Position(Position.COL_C, Position.ROW_1);
        King king = new King(pos, Color.WHITE);
        board.initPiece(pos.getCol(), pos.getRow(), ChessPieceIdx.WKK, king);
        king.setAtInitialPosition(false);
        List<Move> moveList = new ArrayList<Move>(); 
        king.moveGen(board, moveList);
        Assert.assertEquals("found some moves for king", false, moveList.isEmpty());
        Assert.assertEquals("number of move", 5, moveList.size());
        
        Assert.assertEquals(Position.COL_C, moveList.get(0).getFrom().getCol());
        Assert.assertEquals(Position.ROW_1, moveList.get(0).getFrom().getRow());
        Assert.assertEquals(Position.COL_C, moveList.get(0).getTo().getCol());
        Assert.assertEquals(Position.ROW_2, moveList.get(0).getTo().getRow());
        
        Assert.assertEquals(Position.COL_C, moveList.get(1).getFrom().getCol());
        Assert.assertEquals(Position.ROW_1, moveList.get(1).getFrom().getRow());
        Assert.assertEquals(Position.COL_B, moveList.get(1).getTo().getCol());
        Assert.assertEquals(Position.ROW_1, moveList.get(1).getTo().getRow());
        
        Assert.assertEquals(Position.COL_D, moveList.get(2).getTo().getCol());
        Assert.assertEquals(Position.ROW_1, moveList.get(2).getTo().getRow());
        
        Assert.assertEquals(Position.COL_B, moveList.get(3).getTo().getCol());
        Assert.assertEquals(Position.ROW_2, moveList.get(3).getTo().getRow());

        Assert.assertEquals(Position.COL_D, moveList.get(4).getTo().getCol());
        Assert.assertEquals(Position.ROW_2, moveList.get(4).getTo().getRow());
    }
}
