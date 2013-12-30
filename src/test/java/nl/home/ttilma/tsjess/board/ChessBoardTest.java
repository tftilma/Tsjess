package nl.home.ttilma.tsjess.board;

import java.util.List;

import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.tsjess.board.ChessBoard;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
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
    public void testInitialBoard() {
        ChessBoard cb = new ChessBoard();
        cb.initialBoard();
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
    
    @Test
    public void testInitialBoardMoveGen() {
        ChessBoard cb = new ChessBoard();
        cb.initialBoard();
        List<Move> moveList = cb.moveGen();
        Assert.assertNotNull("Initial board MoveList should not be empty", moveList.isEmpty());
        Assert.assertEquals("Initial board should have 20 moves", 20, moveList.size());
    }
        
    @Test
    public void testShortGameMoveLists() {
        ChessBoard cb = new ChessBoard();
        cb.initialBoard();
        List<Move> moveList = cb.moveGen();
        
        // 1.Nb1-c3
        Assert.assertEquals("1.Nb1-c3 from B", Position.COL_B, moveList.get(0).getFrom().getCol());
        Assert.assertEquals("1.Nb1-c3 from 1", Position.ROW_1, moveList.get(0).getFrom().getRow());
        Assert.assertEquals("1.Nb1-c3 to C", Position.COL_C, moveList.get(0).getTo().getCol());
        Assert.assertEquals("1.Nb1-c3 to 3", Position.ROW_3, moveList.get(0).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(0).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(0).isCapturing());

        // 1.Nb1-a3
        Assert.assertEquals("1.Nb1-a3 from B", Position.COL_B, moveList.get(1).getFrom().getCol());
        Assert.assertEquals("1.Nb1-a3 from 1", Position.ROW_1, moveList.get(1).getFrom().getRow());
        Assert.assertEquals("1.Nb1-a3 to A", Position.COL_A, moveList.get(1).getTo().getCol());
        Assert.assertEquals("1.Nb1-a3 to 3", Position.ROW_3, moveList.get(1).getTo().getRow());
        Assert.assertNull("1.Nb1-a3 no promotions", moveList.get(1).getPromotedPiece());
        Assert.assertFalse("1.Nb1-a3 no capturing", moveList.get(1).isCapturing());
        
        // 1.Ng1-h3
        Assert.assertEquals("1.Ng1-h3 from G", Position.COL_G, moveList.get(2).getFrom().getCol());
        Assert.assertEquals("1.Ng1-h3 from 1", Position.ROW_1, moveList.get(2).getFrom().getRow());
        Assert.assertEquals("1.Ng1-h3 to H", Position.COL_H, moveList.get(2).getTo().getCol());
        Assert.assertEquals("1.Ng1-h3 to 3", Position.ROW_3, moveList.get(2).getTo().getRow());
        Assert.assertNull("1.Ng1-h3 no promotions", moveList.get(2).getPromotedPiece());
        Assert.assertFalse("1.Ng1-h3 no capturing", moveList.get(2).isCapturing());
         
        // 1.Ng1-f3
        Assert.assertEquals("1.Ng1-f3 from G", Position.COL_G, moveList.get(3).getFrom().getCol());
        Assert.assertEquals("1.Ng1-f3 from 1", Position.ROW_1, moveList.get(3).getFrom().getRow());
        Assert.assertEquals("1.Ng1-f3 to F", Position.COL_F, moveList.get(3).getTo().getCol());
        Assert.assertEquals("1.Ng1-f3 to 3", Position.ROW_3, moveList.get(3).getTo().getRow());
        Assert.assertNull("1.Ng1-f3 no promotions", moveList.get(3).getPromotedPiece());
        Assert.assertFalse("1.Ng1-f3 no capturing", moveList.get(3).isCapturing());
        
        // 1.a2-a3
        Assert.assertEquals("1.a2-a3 from A", Position.COL_A, moveList.get(4).getFrom().getCol());
        Assert.assertEquals("1.a2-a3 from 2", Position.ROW_2, moveList.get(4).getFrom().getRow());
        Assert.assertEquals("1.a2-a3 to A", Position.COL_A, moveList.get(4).getTo().getCol());
        Assert.assertEquals("1.a2-a3 to 3", Position.ROW_3, moveList.get(4).getTo().getRow());
        Assert.assertNull("1.a2-a3 no promotions", moveList.get(4).getPromotedPiece());
        Assert.assertFalse("1.a2-a3 no capturing", moveList.get(4).isCapturing());
        
        // 1.a2-a4
        Assert.assertEquals("1.a2-a4 from A", Position.COL_A, moveList.get(5).getFrom().getCol());
        Assert.assertEquals("1.a2-a4 from 4", Position.ROW_2, moveList.get(5).getFrom().getRow());
        Assert.assertEquals("1.a2-a4 to A", Position.COL_A, moveList.get(5).getTo().getCol());
        Assert.assertEquals("1.a2-a4 to 4", Position.ROW_4, moveList.get(5).getTo().getRow());
        Assert.assertNull("1.a2-a4 no promotions", moveList.get(5).getPromotedPiece());
        Assert.assertFalse("1.a2-a4 no capturing", moveList.get(5).isCapturing());

        // 1.b2-b3
        Assert.assertEquals("1.b2-b3 from B", Position.COL_B, moveList.get(6).getFrom().getCol());
        Assert.assertEquals("1.b2-b3 from 2", Position.ROW_2, moveList.get(6).getFrom().getRow());
        Assert.assertEquals("1.b2-b3 to B", Position.COL_B, moveList.get(6).getTo().getCol());
        Assert.assertEquals("1.b2-b3 to 3", Position.ROW_3, moveList.get(6).getTo().getRow());
        Assert.assertNull("1.b2-b3 no promotions", moveList.get(6).getPromotedPiece());
        Assert.assertFalse("1.b2-b3 no capturing", moveList.get(6).isCapturing());
        
        // 1.b2-b4
        Assert.assertEquals("1.b2-b4 from B", Position.COL_B, moveList.get(7).getFrom().getCol());
        Assert.assertEquals("1.b2-b4 from 2", Position.ROW_2, moveList.get(7).getFrom().getRow());
        Assert.assertEquals("1.b2-b4 to B", Position.COL_B, moveList.get(7).getTo().getCol());
        Assert.assertEquals("1.b2-b4 to 4", Position.ROW_4, moveList.get(7).getTo().getRow());
        Assert.assertNull("1.b2-b4 no promotions", moveList.get(7).getPromotedPiece());
        Assert.assertFalse("1.b2-b4 no capturing", moveList.get(7).isCapturing());
        
        // 1.c2-c3
        Assert.assertEquals("1.c2-c3 from C", Position.COL_C, moveList.get(8).getFrom().getCol());
        Assert.assertEquals("1.c2-c3 from 2", Position.ROW_2, moveList.get(8).getFrom().getRow());
        Assert.assertEquals("1.c2-c3 to C", Position.COL_C, moveList.get(8).getTo().getCol());
        Assert.assertEquals("1.c2-c3 to 3", Position.ROW_3, moveList.get(8).getTo().getRow());
        Assert.assertNull("1.c2-c3 no promotions", moveList.get(8).getPromotedPiece());
        Assert.assertFalse("1.c2-c3 no capturing", moveList.get(8).isCapturing());
        
        // 1.c2-c4
        Assert.assertEquals("1.c2-c4 from C", Position.COL_C, moveList.get(9).getFrom().getCol());
        Assert.assertEquals("1.c2-c4 from 2", Position.ROW_2, moveList.get(9).getFrom().getRow());
        Assert.assertEquals("1.c2-c4 to C", Position.COL_C, moveList.get(9).getTo().getCol());
        Assert.assertEquals("1.c2-c4 to 4", Position.ROW_4, moveList.get(9).getTo().getRow());
        Assert.assertNull("1.c2-c4 no promotions", moveList.get(9).getPromotedPiece());
        Assert.assertFalse("1.c2-c4 no capturing", moveList.get(9).isCapturing());

        // 1.d2-d3
        Assert.assertEquals("1.d2-d3 from D", Position.COL_D, moveList.get(10).getFrom().getCol());
        Assert.assertEquals("1.d2-d3 from 2", Position.ROW_2, moveList.get(10).getFrom().getRow());
        Assert.assertEquals("1.d2-d3 to D", Position.COL_D, moveList.get(10).getTo().getCol());
        Assert.assertEquals("1.d2-d3 to 3", Position.ROW_3, moveList.get(10).getTo().getRow());
        Assert.assertNull("1.d2-d3 no promotions", moveList.get(10).getPromotedPiece());
        Assert.assertFalse("1.d2-d3 no capturing", moveList.get(10).isCapturing());
        
        // 1.d2-d4
        Assert.assertEquals("1.d2-d4 from D", Position.COL_D, moveList.get(11).getFrom().getCol());
        Assert.assertEquals("1.d2-d4 from 2", Position.ROW_2, moveList.get(11).getFrom().getRow());
        Assert.assertEquals("1.d2-d4 to D", Position.COL_D, moveList.get(11).getTo().getCol());
        Assert.assertEquals("1.d2-d4 to 4", Position.ROW_4, moveList.get(11).getTo().getRow());
        Assert.assertNull("1.d2-d4 no promotions", moveList.get(11).getPromotedPiece());
        Assert.assertFalse("1.d2-d4 no capturing", moveList.get(11).isCapturing());
        
        // 1.e2-e3
        Assert.assertEquals("1.e2-e3", Position.COL_E, moveList.get(12).getFrom().getCol());
        Assert.assertEquals("1.e2-e3", Position.ROW_2, moveList.get(12).getFrom().getRow());
        Assert.assertEquals("1.e2-e3", Position.COL_E, moveList.get(12).getTo().getCol());
        Assert.assertEquals("1.e2-e3", Position.ROW_3, moveList.get(12).getTo().getRow());
        Assert.assertNull("1.e2-e3 no promotions", moveList.get(12).getPromotedPiece());
        Assert.assertFalse("1.e2-e3 no capturing", moveList.get(12).isCapturing());
        
        // 1.e2-e4
        Assert.assertEquals("1.e2-e4 from E", Position.COL_E, moveList.get(13).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 from 2", Position.ROW_2, moveList.get(13).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 to E", Position.COL_E, moveList.get(13).getTo().getCol());
        Assert.assertEquals("1.e2-e4 to 4", Position.ROW_4, moveList.get(13).getTo().getRow());
        Assert.assertNull("1.e2-e4 no promotions", moveList.get(13).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 no capturing", moveList.get(13).isCapturing());

        // 1.f2-f3
        Assert.assertEquals("1.f2-f3", Position.COL_F, moveList.get(14).getFrom().getCol());
        Assert.assertEquals("1.f2-f3", Position.ROW_2, moveList.get(14).getFrom().getRow());
        Assert.assertEquals("1.f2-f3", Position.COL_F, moveList.get(14).getTo().getCol());
        Assert.assertEquals("1.f2-f3", Position.ROW_3, moveList.get(14).getTo().getRow());
        Assert.assertNull("1.f2-f3 no promotions", moveList.get(14).getPromotedPiece());
        Assert.assertFalse("1.f2-f3 no capturing", moveList.get(14).isCapturing());
        
        // 1.f2-f4
        Assert.assertEquals("1.f2-f4", Position.COL_F, moveList.get(15).getFrom().getCol());
        Assert.assertEquals("1.f2-f4", Position.ROW_2, moveList.get(15).getFrom().getRow());
        Assert.assertEquals("1.f2-f4", Position.COL_F, moveList.get(15).getTo().getCol());
        Assert.assertEquals("1.f2-f4", Position.ROW_4, moveList.get(15).getTo().getRow());
        Assert.assertNull("1.f2-f4 no promotions", moveList.get(15).getPromotedPiece());
        Assert.assertFalse("1.f2-f4 no capturing", moveList.get(15).isCapturing());
        
        // 1.g2-g3
        Assert.assertEquals("1.g2-g3", Position.COL_G, moveList.get(16).getFrom().getCol());
        Assert.assertEquals("1.g2-g3", Position.ROW_2, moveList.get(16).getFrom().getRow());
        Assert.assertEquals("1.g2-g3", Position.COL_G, moveList.get(16).getTo().getCol());
        Assert.assertEquals("1.g2-g3", Position.ROW_3, moveList.get(16).getTo().getRow());
        Assert.assertNull("1.g2-g3 no promotions", moveList.get(16).getPromotedPiece());
        Assert.assertFalse("1.g2-g3 no capturing", moveList.get(16).isCapturing());
        
        // 1.g2-g4
        Assert.assertEquals("1.g2-g4", Position.COL_G, moveList.get(17).getFrom().getCol());
        Assert.assertEquals("1.g2-g4", Position.ROW_2, moveList.get(17).getFrom().getRow());
        Assert.assertEquals("1.g2-g4", Position.COL_G, moveList.get(17).getTo().getCol());
        Assert.assertEquals("1.g2-g4", Position.ROW_4, moveList.get(17).getTo().getRow());
        Assert.assertNull("1.g2-g4 no promotions", moveList.get(17).getPromotedPiece());
        Assert.assertFalse("1.g2-g4 no capturing", moveList.get(17).isCapturing());

        // 1.h2-h3
        Assert.assertEquals("1.h2-h3", Position.COL_H, moveList.get(18).getFrom().getCol());
        Assert.assertEquals("1.h2-h3", Position.ROW_2, moveList.get(18).getFrom().getRow());
        Assert.assertEquals("1.h2-h3", Position.COL_H, moveList.get(18).getTo().getCol());
        Assert.assertEquals("1.h2-h3", Position.ROW_3, moveList.get(18).getTo().getRow());
        Assert.assertNull("1.h2-h3 no promotions", moveList.get(18).getPromotedPiece());
        Assert.assertFalse("1.h2-h3 no capturing", moveList.get(18).isCapturing());
        
        // 1.h2-h4
        Assert.assertEquals("1.h2-h4", Position.COL_H, moveList.get(19).getFrom().getCol());
        Assert.assertEquals("1.h2-h4", Position.ROW_2, moveList.get(19).getFrom().getRow());
        Assert.assertEquals("1.h2-h4", Position.COL_H, moveList.get(19).getTo().getCol());
        Assert.assertEquals("1.h2-h4", Position.ROW_4, moveList.get(19).getTo().getRow());
        Assert.assertNull("1.h2-h4 no promotions", moveList.get(19).getPromotedPiece());
        Assert.assertFalse("1.h2-h4 no capturing", moveList.get(19).isCapturing());
        
        Move moveE2E4 = new Move(new Position(Position.COL_E, Position.ROW_2),
                                 new Position(Position.COL_E, Position.ROW_4));
        cb.play(moveE2E4);
        moveList = cb.moveGen();
        Assert.assertNotNull("Board after e2-e4: MoveList should not be empty", moveList.isEmpty());
        Assert.assertEquals("Board after e2-e4: should have 20 moves", 20, moveList.size());
        
        // 1.e2-e4 Nb8-c6
        Assert.assertEquals("1.e2-e4 Nb8-c6", Position.COL_B, moveList.get(0).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 Nb8-c6", Position.ROW_8, moveList.get(0).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 Nb8-c6", Position.COL_C, moveList.get(0).getTo().getCol());
        Assert.assertEquals("1.e2-e4 Nb8-c6", Position.ROW_6, moveList.get(0).getTo().getRow());
        Assert.assertNull("1.e2-e4 Nb8-c6 no promotions", moveList.get(0).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 Nb8-c6 no capturing", moveList.get(0).isCapturing());
         
        // 1.e2-e4 Nb8-a6
        Assert.assertEquals("1.e2-e4 Nb8-a6", Position.COL_B, moveList.get(1).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 Nb8-a6", Position.ROW_8, moveList.get(1).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 Nb8-a6", Position.COL_A, moveList.get(1).getTo().getCol());
        Assert.assertEquals("1.e2-e4 Nb8-a6", Position.ROW_6, moveList.get(1).getTo().getRow());
        Assert.assertNull("1.e2-e4 Nb8-a6 no promotions", moveList.get(1).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 Nb8-a6 no capturing", moveList.get(1).isCapturing());
        
        // 1.e2-e4 Ng8-h6
        Assert.assertEquals("1.e2-e4 Ng8-h6", Position.COL_G, moveList.get(2).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 Ng8-h6", Position.ROW_8, moveList.get(2).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 Ng8-h6", Position.COL_H, moveList.get(2).getTo().getCol());
        Assert.assertEquals("1.e2-e4 Ng8-h6", Position.ROW_6, moveList.get(2).getTo().getRow());
        Assert.assertNull("1.e2-e4 Ng8-h6 no promotions", moveList.get(2).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 Ng8-h6 no capturing", moveList.get(2).isCapturing());
        
        // 1.e2-e4 Ng8-f6 
        Assert.assertEquals("1.e2-e4 Ng8-f6", Position.COL_G, moveList.get(3).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 Ng8-f6", Position.ROW_8, moveList.get(3).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 Ng8-f6", Position.COL_F, moveList.get(3).getTo().getCol());
        Assert.assertEquals("1.e2-e4 Ng8-f6", Position.ROW_6, moveList.get(3).getTo().getRow());
        Assert.assertNull("1.e2-e4 Ng8-f6 no promotions", moveList.get(3).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 Ng8-f6 no capturing", moveList.get(3).isCapturing());
        
        // 1.e2-e4 a7-a6
        Assert.assertEquals("1.e2-e4 a7-a6", Position.COL_A, moveList.get(4).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 a7-a6", Position.ROW_7, moveList.get(4).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 a7-a6", Position.COL_A, moveList.get(4).getTo().getCol());
        Assert.assertEquals("1.e2-e4 a7-a6", Position.ROW_6, moveList.get(4).getTo().getRow());
        Assert.assertNull("1.e2-e4 a7-a6 no promotions", moveList.get(4).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 a7-a6no capturing", moveList.get(4).isCapturing());
        
        // 1.e2-e4 a7-a5
        Assert.assertEquals("1.e2-e4 a7-a5", Position.COL_A, moveList.get(5).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 a7-a5", Position.ROW_7, moveList.get(5).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 a7-a5", Position.COL_A, moveList.get(5).getTo().getCol());
        Assert.assertEquals("I1.e2-e4 a7-a5", Position.ROW_5, moveList.get(5).getTo().getRow());
        Assert.assertNull("1.e2-e4 a7-a5 no promotions", moveList.get(5).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 a7-a5 no capturing", moveList.get(5).isCapturing());

        // 1.e2-e4 b7-b6
        Assert.assertEquals("1.e2-e4 b7-b6", Position.COL_B, moveList.get(6).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 b7-b6", Position.ROW_7, moveList.get(6).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 b7-b6", Position.COL_B, moveList.get(6).getTo().getCol());
        Assert.assertEquals("1.e2-e4 b7-b6", Position.ROW_6, moveList.get(6).getTo().getRow());
        Assert.assertNull("1.e2-e4 b7-b6 no promotions", moveList.get(6).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 b7-b6 no capturing", moveList.get(6).isCapturing());
        
        // 1.e2-e4 b7-b5
        Assert.assertEquals("1.e2-e4 b7-b5", Position.COL_B, moveList.get(7).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 b7-b5", Position.ROW_7, moveList.get(7).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 b7-b5", Position.COL_B, moveList.get(7).getTo().getCol());
        Assert.assertEquals("1.e2-e4 b7-b5", Position.ROW_5, moveList.get(7).getTo().getRow());
        Assert.assertNull("1.e2-e4 b7-b5 no promotions", moveList.get(7).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 b7-b5 no capturing", moveList.get(7).isCapturing());
        
        // 1.e2-e4 c7-c6
        Assert.assertEquals("1.e2-e4 c7-c6", Position.COL_C, moveList.get(8).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 c7-c6", Position.ROW_7, moveList.get(8).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 c7-c6", Position.COL_C, moveList.get(8).getTo().getCol());
        Assert.assertEquals("1.e2-e4 c7-c6", Position.ROW_6, moveList.get(8).getTo().getRow());
        Assert.assertNull("1.e2-e4 c7-c6 no promotions", moveList.get(8).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 c7-c6 no capturing", moveList.get(8).isCapturing());
        
        // 1.e2-e4 c7-c5
        Assert.assertEquals("1.e2-e4 c7-c5", Position.COL_C, moveList.get(9).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 c7-c5", Position.ROW_7, moveList.get(9).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 c7-c5", Position.COL_C, moveList.get(9).getTo().getCol());
        Assert.assertEquals("1.e2-e4 c7-c5", Position.ROW_5, moveList.get(9).getTo().getRow());
        Assert.assertNull("1.e2-e4 c7-c5 no promotions", moveList.get(9).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 c7-c5 no capturing", moveList.get(9).isCapturing());

        // 1.e2-e4 d7-d6
        Assert.assertEquals("1.e2-e4 d7-d6", Position.COL_D, moveList.get(10).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d6", Position.ROW_7, moveList.get(10).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d6", Position.COL_D, moveList.get(10).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d6", Position.ROW_6, moveList.get(10).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d6 no promotions", moveList.get(10).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d6 no capturing", moveList.get(10).isCapturing());
        
        // 1.e2-e4 d7-d5
        Assert.assertEquals("1.e2-e4 d7-d5", Position.COL_D, moveList.get(11).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5", Position.ROW_7, moveList.get(11).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5", Position.COL_D, moveList.get(11).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5", Position.ROW_5, moveList.get(11).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 no promotions", moveList.get(11).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5no capturing", moveList.get(11).isCapturing());
        
        // 1.e2-e4 e7-e6
        Assert.assertEquals("1.e2-e4 e7-e6", Position.COL_E, moveList.get(12).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 e7-e6", Position.ROW_7, moveList.get(12).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 e7-e6", Position.COL_E, moveList.get(12).getTo().getCol());
        Assert.assertEquals("1.e2-e4 e7-e6", Position.ROW_6, moveList.get(12).getTo().getRow());
        Assert.assertNull("1.e2-e4 e7-e6 no promotions", moveList.get(12).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 e7-e6 no capturing", moveList.get(12).isCapturing());
        
        // 1.e2-e4 e7-e5
        Assert.assertEquals("1.e2-e4 e7-e5", Position.COL_E, moveList.get(13).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 e7-e5", Position.ROW_7, moveList.get(13).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 e7-e5", Position.COL_E, moveList.get(13).getTo().getCol());
        Assert.assertEquals("1.e2-e4 e7-e5", Position.ROW_5, moveList.get(13).getTo().getRow());
        Assert.assertNull("1.e2-e4 e7-e5 no promotions", moveList.get(13).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 e7-e5 no capturing", moveList.get(13).isCapturing());

        // 1.e2-e4 f7-f6
        Assert.assertEquals("1.e2-e4 f7-f6", Position.COL_F, moveList.get(14).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 f7-f6", Position.ROW_7, moveList.get(14).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 f7-f6", Position.COL_F, moveList.get(14).getTo().getCol());
        Assert.assertEquals("1.e2-e4 f7-f6", Position.ROW_6, moveList.get(14).getTo().getRow());
        Assert.assertNull("1.e2-e4 f7-f6 no promotions", moveList.get(14).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 f7-f6 no capturing", moveList.get(14).isCapturing());
        
        // 1.e2-e4 f7-f5
        Assert.assertEquals("1.e2-e4 f7-f5", Position.COL_F, moveList.get(15).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 f7-f5", Position.ROW_7, moveList.get(15).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 f7-f5", Position.COL_F, moveList.get(15).getTo().getCol());
        Assert.assertEquals("1.e2-e4 f7-f5", Position.ROW_5, moveList.get(15).getTo().getRow());
        Assert.assertNull("1.e2-e4 f7-f5 no promotions", moveList.get(15).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 f7-f5 no capturing", moveList.get(15).isCapturing());
        
        // 1.e2-e4 g7-g6
        Assert.assertEquals("1.e2-e4 g7-g6", Position.COL_G, moveList.get(16).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 g7-g6", Position.ROW_7, moveList.get(16).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 g7-g6", Position.COL_G, moveList.get(16).getTo().getCol());
        Assert.assertEquals("1.e2-e4 g7-g6", Position.ROW_6, moveList.get(16).getTo().getRow());
        Assert.assertNull("1.e2-e4 g7-g6 no promotions", moveList.get(16).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 g7-g6 no capturing", moveList.get(16).isCapturing());
        
        // 1.e2-e4 g7-g5
        Assert.assertEquals("1.e2-e4 g7-g5", Position.COL_G, moveList.get(17).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 g7-g5", Position.ROW_7, moveList.get(17).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 g7-g5", Position.COL_G, moveList.get(17).getTo().getCol());
        Assert.assertEquals("1.e2-e4 g7-g5", Position.ROW_5, moveList.get(17).getTo().getRow());
        Assert.assertNull("1.e2-e4 g7-g5 no promotions", moveList.get(17).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 g7-g5 no capturing", moveList.get(17).isCapturing());

        // 1.e2-e4 h7-h6
        Assert.assertEquals("1.e2-e4 h7-h6", Position.COL_H, moveList.get(18).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 h7-h6", Position.ROW_7, moveList.get(18).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 h7-h6", Position.COL_H, moveList.get(18).getTo().getCol());
        Assert.assertEquals("1.e2-e4 h7-h6", Position.ROW_6, moveList.get(18).getTo().getRow());
        Assert.assertNull("1.e2-e4 h7-h6 no promotions", moveList.get(18).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 h7-h6 no capturing", moveList.get(18).isCapturing());
        
        // 1.e2-e4 h7-h5
        Assert.assertEquals("1.e2-e4 h7-h5", Position.COL_H, moveList.get(19).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 h7-h5", Position.ROW_7, moveList.get(19).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 h7-h5", Position.COL_H, moveList.get(19).getTo().getCol());
        Assert.assertEquals("1.e2-e4 h7-h5", Position.ROW_5, moveList.get(19).getTo().getRow());
        Assert.assertNull("1.e2-e4 h7-h5 no promotions", moveList.get(19).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 h7-h5 no capturing", moveList.get(19).isCapturing());
        
        ///////////////////////////////////////////////////////////////////////////////////////
        Move moveD7D5 = new Move(new Position(Position.COL_D, Position.ROW_7),
                new Position(Position.COL_D, Position.ROW_5));
        cb.play(moveD7D5);
        moveList = cb.moveGen();
        Assert.assertNotNull("Board after d7-d5: MoveList should not be empty", moveList.isEmpty());
        Assert.assertEquals("Board after d7-d5: should have 20 moves", 31, moveList.size());
       
        // 1.e2-e4 d7-d5 2.Nb1-c3
        Assert.assertEquals("1.e2-e4 d7-d5 2.Nb1-c3", Position.COL_B, moveList.get(0).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Nb1-c3", Position.ROW_1, moveList.get(0).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Nb1-c3", Position.COL_C, moveList.get(0).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Nb1-c3", Position.ROW_3, moveList.get(0).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Nb1-c3 no promotions", moveList.get(0).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Nb1-c3 no capturing", moveList.get(0).isCapturing());
         
        // 1.e2-e4 d7-d5 2.Nb1-a3
        Assert.assertEquals("1.e2-e4 d7-d5 2.Nb1-a3", Position.COL_B, moveList.get(1).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Nb1-a3", Position.ROW_1, moveList.get(1).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Nb1-a3", Position.COL_A, moveList.get(1).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Nb1-a3", Position.ROW_3, moveList.get(1).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Nb1-a3 no promotions", moveList.get(1).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Nb1-a3 no capturing", moveList.get(1).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Qd1-e2
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-e2", Position.COL_D, moveList.get(2).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-e2", Position.ROW_1, moveList.get(2).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-e2", Position.COL_E, moveList.get(2).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-e2", Position.ROW_2, moveList.get(2).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Qd1-e2 no promotions", moveList.get(2).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Qd1-e2 no capturing", moveList.get(2).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Qd1-f3
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-f3", Position.COL_D, moveList.get(3).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-f3", Position.ROW_1, moveList.get(3).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-f3", Position.COL_F, moveList.get(3).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-f3", Position.ROW_3, moveList.get(3).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Qd1-f3 no promotions", moveList.get(3).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Qd1-f3 no capturing", moveList.get(3).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Qd1-g4
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-g4", Position.COL_D, moveList.get(4).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-g4", Position.ROW_1, moveList.get(4).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-g4", Position.COL_G, moveList.get(4).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-g4", Position.ROW_4, moveList.get(4).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Qd1-g4 no promotions", moveList.get(4).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Qd1-g4 no capturing", moveList.get(4).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Qd1-h5
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-h5", Position.COL_D, moveList.get(5).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-h5", Position.ROW_1, moveList.get(5).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-h5", Position.COL_H, moveList.get(5).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Qd1-h5", Position.ROW_5, moveList.get(5).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Qd1-h5 no promotions", moveList.get(5).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Qd1-h5 no capturing", moveList.get(5).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Ke1-e2
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ke1-e2", Position.COL_E, moveList.get(6).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ke1-e2", Position.ROW_1, moveList.get(6).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ke1-e2", Position.COL_E, moveList.get(6).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ke1-e2", Position.ROW_2, moveList.get(6).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Ke1-e2 no promotions", moveList.get(6).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Ke1-e2 no capturing", moveList.get(6).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Bf1-e2
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-e2", Position.COL_F, moveList.get(7).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-e2", Position.ROW_1, moveList.get(7).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-e2", Position.COL_E, moveList.get(7).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-e2", Position.ROW_2, moveList.get(7).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Bf1-e2 no promotions", moveList.get(7).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Bf1-e2no capturing", moveList.get(7).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Bf1-d3
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-d3", Position.COL_F, moveList.get(8).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-d3", Position.ROW_1, moveList.get(8).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-d3", Position.COL_D, moveList.get(8).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-d3", Position.ROW_3, moveList.get(8).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Bf1-d3 no promotions", moveList.get(8).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Bf1-d3 no capturing", moveList.get(8).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Bf1-c4
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-c4", Position.COL_F, moveList.get(9).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-c4", Position.ROW_1, moveList.get(9).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-c4", Position.COL_C, moveList.get(9).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-c4", Position.ROW_4, moveList.get(9).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Bf1-c4 no promotions", moveList.get(9).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Bf1-c4 no capturing", moveList.get(9).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Bf1-b5
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-b5", Position.COL_F, moveList.get(10).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-b5", Position.ROW_1, moveList.get(10).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-b5", Position.COL_B, moveList.get(10).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-b5", Position.ROW_5, moveList.get(10).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Bf1-b5 no promotions", moveList.get(10).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Bf1-b5 no capturing", moveList.get(10).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Bf1-a6
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-a6", Position.COL_F, moveList.get(11).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-a6", Position.ROW_1, moveList.get(11).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-a6", Position.COL_A, moveList.get(11).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Bf1-a6", Position.ROW_6, moveList.get(11).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Bf1-a6 no promotions", moveList.get(11).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Bf1-a6 no capturing", moveList.get(11).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Ng1-h3
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-h3", Position.COL_G, moveList.get(12).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-h3", Position.ROW_1, moveList.get(12).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-h3", Position.COL_H, moveList.get(12).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-h3", Position.ROW_3, moveList.get(12).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Ng1-h3 no promotions", moveList.get(12).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Ng1-h3 no capturing", moveList.get(12).isCapturing());
        
        // 1.e2-e4 d7-d5 2.Ng1-f3
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-f3", Position.COL_G, moveList.get(13).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-f3", Position.ROW_1, moveList.get(13).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-f3", Position.COL_F, moveList.get(13).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-f3", Position.ROW_3, moveList.get(13).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Ng1-f3 no promotions", moveList.get(13).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Ng1-f3 no capturing", moveList.get(13).isCapturing());

        // 1.e2-e4 d7-d5 2.Ng1-e2
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-e2", Position.COL_G, moveList.get(14).getFrom().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-e2", Position.ROW_1, moveList.get(14).getFrom().getRow());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-e2", Position.COL_E, moveList.get(14).getTo().getCol());
        Assert.assertEquals("1.e2-e4 d7-d5 2.Ng1-e2", Position.ROW_2, moveList.get(14).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5 2.Ng1-e2 no promotions", moveList.get(14).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5 2.Ng1-e2 no capturing", moveList.get(14).isCapturing());
        
        Assert.assertEquals("Initial board 5", Position.COL_A, moveList.get(15).getFrom().getCol());
        Assert.assertEquals("Initial board 5", Position.ROW_2, moveList.get(15).getFrom().getRow());
        Assert.assertEquals("Initial board 5", Position.COL_A, moveList.get(15).getTo().getCol());
        Assert.assertEquals("Initial board 5", Position.ROW_3, moveList.get(15).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(15).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(15).isCapturing());
        
        Assert.assertEquals("Initial board 6", Position.COL_A, moveList.get(16).getFrom().getCol());
        Assert.assertEquals("Initial board 6", Position.ROW_2, moveList.get(16).getFrom().getRow());
        Assert.assertEquals("Initial board 6", Position.COL_A, moveList.get(16).getTo().getCol());
        Assert.assertEquals("Initial board 6", Position.ROW_4, moveList.get(16).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(16).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(16).isCapturing());

        Assert.assertEquals("Initial board 7", Position.COL_B, moveList.get(17).getFrom().getCol());
        Assert.assertEquals("Initial board 7", Position.ROW_2, moveList.get(17).getFrom().getRow());
        Assert.assertEquals("Initial board 7", Position.COL_B, moveList.get(17).getTo().getCol());
        Assert.assertEquals("Initial board 7", Position.ROW_3, moveList.get(17).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(17).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(17).isCapturing());
        
        Assert.assertEquals("Initial board 8", Position.COL_B, moveList.get(18).getFrom().getCol());
        Assert.assertEquals("Initial board 8", Position.ROW_2, moveList.get(18).getFrom().getRow());
        Assert.assertEquals("Initial board 8", Position.COL_B, moveList.get(18).getTo().getCol());
        Assert.assertEquals("Initial board 8", Position.ROW_4, moveList.get(18).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(18).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(18).isCapturing());
        
        Assert.assertEquals("Initial board 9", Position.COL_C, moveList.get(19).getFrom().getCol());
        Assert.assertEquals("Initial board 9", Position.ROW_2, moveList.get(19).getFrom().getRow());
        Assert.assertEquals("Initial board 9", Position.COL_C, moveList.get(19).getTo().getCol());
        Assert.assertEquals("Initial board 9", Position.ROW_3, moveList.get(19).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(19).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(19).isCapturing());
        
        Assert.assertEquals("Initial board 10", Position.COL_C, moveList.get(20).getFrom().getCol());
        Assert.assertEquals("Initial board 10", Position.ROW_2, moveList.get(20).getFrom().getRow());
        Assert.assertEquals("Initial board 10", Position.COL_C, moveList.get(20).getTo().getCol());
        Assert.assertEquals("Initial board 10", Position.ROW_4, moveList.get(20).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(20).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(20).isCapturing());

        Assert.assertEquals("Initial board 11", Position.COL_D, moveList.get(21).getFrom().getCol());
        Assert.assertEquals("Initial board 11", Position.ROW_2, moveList.get(21).getFrom().getRow());
        Assert.assertEquals("Initial board 11", Position.COL_D, moveList.get(21).getTo().getCol());
        Assert.assertEquals("Initial board 11", Position.ROW_3, moveList.get(21).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(21).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(21).isCapturing());
        
        Assert.assertEquals("Initial board 12", Position.COL_D, moveList.get(22).getFrom().getCol());
        Assert.assertEquals("Initial board 12", Position.ROW_2, moveList.get(22).getFrom().getRow());
        Assert.assertEquals("Initial board 12", Position.COL_D, moveList.get(22).getTo().getCol());
        Assert.assertEquals("Initial board 12", Position.ROW_4, moveList.get(22).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(22).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(22).isCapturing());
       
        // 1.e2-e4 d7-d7 2.e4-e5
        Assert.assertEquals("Initial board 13", Position.COL_E, moveList.get(23).getFrom().getCol());
        Assert.assertEquals("Initial board 13", Position.ROW_4, moveList.get(23).getFrom().getRow());
        Assert.assertEquals("Initial board 13", Position.COL_E, moveList.get(23).getTo().getCol());
        Assert.assertEquals("Initial board 13", Position.ROW_5, moveList.get(23).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(23).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(23).isCapturing());
        
        // 1.e2-e4 d7-d7 2.e4xd5
        Assert.assertEquals("Initial board 13", Position.COL_E, moveList.get(24).getFrom().getCol());
        Assert.assertEquals("Initial board 13", Position.ROW_4, moveList.get(24).getFrom().getRow());
        Assert.assertEquals("Initial board 13", Position.COL_D, moveList.get(24).getTo().getCol());
        Assert.assertEquals("Initial board 13", Position.ROW_5, moveList.get(24).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d7 2.e4xd5 no promotions", moveList.get(24).getPromotedPiece());
        Assert.assertTrue("1.e2-e4 d7-d7 2.e4xd5 HAS capturing", moveList.get(24).isCapturing());
        
        Assert.assertEquals("Initial board 15", Position.COL_F, moveList.get(25).getFrom().getCol());
        Assert.assertEquals("Initial board 15", Position.ROW_2, moveList.get(25).getFrom().getRow());
        Assert.assertEquals("Initial board 15", Position.COL_F, moveList.get(25).getTo().getCol());
        Assert.assertEquals("Initial board 15", Position.ROW_3, moveList.get(25).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(25).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(25).isCapturing());
        
        Assert.assertEquals("Initial board 16", Position.COL_F, moveList.get(26).getFrom().getCol());
        Assert.assertEquals("Initial board 16", Position.ROW_2, moveList.get(26).getFrom().getRow());
        Assert.assertEquals("Initial board 16", Position.COL_F, moveList.get(26).getTo().getCol());
        Assert.assertEquals("Initial board 16", Position.ROW_4, moveList.get(26).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(26).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(26).isCapturing());
        
        Assert.assertEquals("Initial board 17", Position.COL_G, moveList.get(27).getFrom().getCol());
        Assert.assertEquals("Initial board 17", Position.ROW_2, moveList.get(27).getFrom().getRow());
        Assert.assertEquals("Initial board 17", Position.COL_G, moveList.get(27).getTo().getCol());
        Assert.assertEquals("Initial board 17", Position.ROW_3, moveList.get(27).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(27).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(27).isCapturing());
        
        Assert.assertEquals("Initial board 18", Position.COL_G, moveList.get(28).getFrom().getCol());
        Assert.assertEquals("Initial board 18", Position.ROW_2, moveList.get(28).getFrom().getRow());
        Assert.assertEquals("Initial board 18", Position.COL_G, moveList.get(28).getTo().getCol());
        Assert.assertEquals("Initial board 18", Position.ROW_4, moveList.get(28).getTo().getRow());
        Assert.assertNull("1.Nb1-c3 no promotions", moveList.get(28).getPromotedPiece());
        Assert.assertFalse("1.Nb1-c3 no capturing", moveList.get(28).isCapturing());

        Assert.assertEquals("Initial board 19", Position.COL_H, moveList.get(29).getFrom().getCol());
        Assert.assertEquals("Initial board 19", Position.ROW_2, moveList.get(29).getFrom().getRow());
        Assert.assertEquals("Initial board 19", Position.COL_H, moveList.get(29).getTo().getCol());
        Assert.assertEquals("Initial board 19", Position.ROW_3, moveList.get(29).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5; 2.h2-h3 no promotions", moveList.get(29).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5; 2.h2-h3 no capturing", moveList.get(29).isCapturing());
        
        Assert.assertEquals("Initial board 20", Position.COL_H, moveList.get(30).getFrom().getCol());
        Assert.assertEquals("Initial board 20", Position.ROW_2, moveList.get(30).getFrom().getRow());
        Assert.assertEquals("Initial board 20", Position.COL_H, moveList.get(30).getTo().getCol());
        Assert.assertEquals("Initial board 20", Position.ROW_4, moveList.get(30).getTo().getRow());
        Assert.assertNull("1.e2-e4 d7-d5; 2.h2-h4 no promotions", moveList.get(30).getPromotedPiece());
        Assert.assertFalse("1.e2-e4 d7-d5; 2.h2-h4 no capturing", moveList.get(30).isCapturing());
    }
}
