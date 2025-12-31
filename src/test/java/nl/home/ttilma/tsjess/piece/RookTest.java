package nl.home.ttilma.tsjess.piece;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.tsjess.board.ChessBoard;
import nl.home.ttilma.tsjess.board.ChessPieceIdx;
import nl.home.ttilma.tsjess.piece.Rook;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class RookTest {
    @Test
    public void testPrintWhite() {
        assertTrue(new Rook(Color.WHITE).isWhite());
        
    }
    @Test
    public void testPrintBlack() {
        assertTrue(new Rook(Color.BLACK).isBlack());
    }
    
    @Test
    public void testMoveGen() {
        ChessBoard board = new ChessBoard();
        Position pos = new Position(Position.COL_C, Position.ROW_1);
        Rook rook = new Rook(pos, Color.WHITE);
        board.initPiece(pos.getCol(), pos.getRow(), ChessPieceIdx.WQB, rook);
        List<Move> moveList = new ArrayList<Move>(); 
        rook.moveGen(board, moveList);
        assertFalse(moveList.isEmpty());
        assertEquals(14, moveList.size());
        
        assertEquals(Position.COL_C, moveList.get(0).getFrom().getCol());
        assertEquals(Position.ROW_1, moveList.get(0).getFrom().getRow());
        assertEquals(Position.COL_C, moveList.get(0).getTo().getCol());
        assertEquals(Position.ROW_2, moveList.get(0).getTo().getRow());
        
        assertEquals(Position.COL_C, moveList.get(1).getFrom().getCol());
        assertEquals(Position.ROW_1, moveList.get(1).getFrom().getRow());
        assertEquals(Position.COL_C, moveList.get(1).getTo().getCol());
        assertEquals(Position.ROW_3, moveList.get(1).getTo().getRow());
        
        assertEquals(Position.COL_C, moveList.get(2).getTo().getCol());
        assertEquals(Position.ROW_4, moveList.get(2).getTo().getRow());
        
        assertEquals(Position.COL_C, moveList.get(3).getTo().getCol());
        assertEquals(Position.ROW_5, moveList.get(3).getTo().getRow());

        assertEquals(Position.COL_C, moveList.get(4).getTo().getCol());
        assertEquals(Position.ROW_6, moveList.get(4).getTo().getRow());
        
        assertEquals(Position.COL_C, moveList.get(5).getTo().getCol());
        assertEquals(Position.ROW_7, moveList.get(5).getTo().getRow());

        assertEquals(Position.COL_C, moveList.get(6).getTo().getCol());
        assertEquals(Position.ROW_8, moveList.get(6).getTo().getRow());
        
        assertEquals(Position.COL_B, moveList.get(7).getTo().getCol());
        assertEquals(Position.ROW_1, moveList.get(7).getTo().getRow());
        
        assertEquals(Position.COL_A, moveList.get(8).getTo().getCol());
        assertEquals(Position.ROW_1, moveList.get(8).getTo().getRow());
        
        assertEquals(Position.COL_D, moveList.get(9).getTo().getCol());
        assertEquals(Position.ROW_1, moveList.get(9).getTo().getRow());

        assertEquals(Position.COL_E, moveList.get(10).getTo().getCol());
        assertEquals(Position.ROW_1, moveList.get(10).getTo().getRow());
        
        assertEquals(Position.COL_F, moveList.get(11).getTo().getCol());
        assertEquals(Position.ROW_1, moveList.get(11).getTo().getRow());

        assertEquals(Position.COL_G, moveList.get(12).getTo().getCol());
        assertEquals(Position.ROW_1, moveList.get(12).getTo().getRow());
        
        assertEquals(Position.COL_H, moveList.get(13).getTo().getCol());
        assertEquals(Position.ROW_1, moveList.get(13).getTo().getRow());
    }
}
