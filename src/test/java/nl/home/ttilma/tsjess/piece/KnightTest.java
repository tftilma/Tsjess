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
import nl.home.ttilma.tsjess.piece.Knight;


public class KnightTest {
    @Test
    public void testPrintWhite() {
        Assert.assertEquals(true, new Knight(Color.WHITE).isWhite());
    }
    
    @Test
    public void testPrintBlack() {
        Assert.assertEquals(true, new Knight(Color.BLACK).isBlack());
    }
    
    @Test
    public void testMoveGen() {
        ChessBoard board = new ChessBoard();
        Position pos = new Position(Position.COL_B, Position.ROW_1);
        Knight knight = new Knight(pos, Color.WHITE);
        board.initPiece(pos.getCol(), pos.getRow(), ChessPieceIdx.WQB, knight);
        List<Move> moveList = new ArrayList<Move>(); 
        knight.moveGen(board, moveList);
        Assert.assertEquals("found some moves for knight", false, moveList.isEmpty());
        Assert.assertEquals("number of move", 3, moveList.size());
        
        Assert.assertEquals(Position.COL_B, moveList.get(0).getFrom().getCol());
        Assert.assertEquals(Position.ROW_1, moveList.get(0).getFrom().getRow());
        Assert.assertEquals(Position.COL_C, moveList.get(0).getTo().getCol());
        Assert.assertEquals(Position.ROW_3, moveList.get(0).getTo().getRow());
        
        Assert.assertEquals(Position.COL_B, moveList.get(1).getFrom().getCol());
        Assert.assertEquals(Position.ROW_1, moveList.get(1).getFrom().getRow());
        Assert.assertEquals(Position.COL_D, moveList.get(1).getTo().getCol());
        Assert.assertEquals(Position.ROW_2, moveList.get(1).getTo().getRow());
        
        Assert.assertEquals(Position.COL_A, moveList.get(2).getTo().getCol());
        Assert.assertEquals(Position.ROW_3, moveList.get(2).getTo().getRow());
    }
}
