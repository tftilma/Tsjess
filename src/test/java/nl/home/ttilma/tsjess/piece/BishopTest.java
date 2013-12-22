package nl.home.ttilma.tsjess.piece;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.tsjess.board.ChessBoard;
import nl.home.ttilma.tsjess.board.ChessPieceIdx;
import nl.home.ttilma.tsjess.piece.Bishop;

import org.junit.Test;

public class BishopTest {
    @Test
    public void testMoveGen() {
        ChessBoard board = new ChessBoard();
        Position pos = new Position(Position.COL_C, Position.ROW_1);
        Bishop bishop = new Bishop(pos, Color.WHITE);
        board.initPiece(pos.getCol(), pos.getRow(), ChessPieceIdx.WQB, bishop);
        List<Move> moveList = new ArrayList<Move>(); 
        bishop.moveGen(board, moveList);
        Assert.assertEquals("found some moves for bishop", false, moveList.isEmpty());
        Assert.assertEquals("number of move", 7, moveList.size());
        
        Assert.assertEquals(Position.COL_C, moveList.get(0).getFrom().getCol());
        Assert.assertEquals(Position.ROW_1, moveList.get(0).getFrom().getRow());
        Assert.assertEquals(Position.COL_B, moveList.get(0).getTo().getCol());
        Assert.assertEquals(Position.ROW_2, moveList.get(0).getTo().getRow());
        
        Assert.assertEquals(Position.COL_C, moveList.get(1).getFrom().getCol());
        Assert.assertEquals(Position.ROW_1, moveList.get(1).getFrom().getRow());
        Assert.assertEquals(Position.COL_A, moveList.get(1).getTo().getCol());
        Assert.assertEquals(Position.ROW_3, moveList.get(1).getTo().getRow());
        
        Assert.assertEquals(Position.COL_D, moveList.get(2).getTo().getCol());
        Assert.assertEquals(Position.ROW_2, moveList.get(2).getTo().getRow());
        
        Assert.assertEquals(Position.COL_E, moveList.get(3).getTo().getCol());
        Assert.assertEquals(Position.ROW_3, moveList.get(3).getTo().getRow());

        Assert.assertEquals(Position.COL_F, moveList.get(4).getTo().getCol());
        Assert.assertEquals(Position.ROW_4, moveList.get(4).getTo().getRow());
        
        Assert.assertEquals(Position.COL_G, moveList.get(5).getTo().getCol());
        Assert.assertEquals(Position.ROW_5, moveList.get(5).getTo().getRow());

        Assert.assertEquals(Position.COL_H, moveList.get(6).getTo().getCol());
        Assert.assertEquals(Position.ROW_6, moveList.get(6).getTo().getRow());
    }
}
