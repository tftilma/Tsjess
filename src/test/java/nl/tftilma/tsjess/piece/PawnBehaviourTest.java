package nl.tftilma.tsjess.piece;

import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.tftilma.tsjess.board.Position.*;
import static nl.tftilma.tsjess.piece.PieceIndex.*;
import static org.junit.jupiter.api.Assertions.*;

class PawnBehaviourTest {
    private ChessBoard board;

    @BeforeEach
    void setup() {
        board = new ChessBoard();
    }

    @Test
    void testMoveOneForwardWhiteWhite() {
        testMoveOneForward(board, Color.WHITE, Color.WHITE);
    }

    @Test
    void testMoveOneForwardWhiteBlack() {
        testMoveOneForward(board, Color.WHITE, Color.BLACK);
    }

    @Test
    void testMoveOneForwardBlackWhite() {
        testMoveOneForward(board, Color.BLACK, Color.WHITE);
    }

    @Test
    void testMoveOneForwardBlackBlack() {
        testMoveOneForward(board, Color.BLACK, Color.BLACK);
    }

    void testMoveOneForward(ChessBoard board, Color color, Color otherColor) {
        AbstractChessPiece aPawn = (AbstractChessPiece) board.findPiece(color, AP.ordinal());
        assertNotNull(aPawn);
        assertInstanceOf(Pawn.class, aPawn);
        board.setPiece(0, 5, aPawn);

        if (otherColor != null) {
            Piece otherPawn = board.findPiece(otherColor, BP.ordinal());
            board.setPiece(0, 6, otherPawn);
        }

        List<Move> moveList = aPawn.generate(null);
        assertNotNull(moveList);
        if (aPawn.isBlack()) {
            assertEquals(1, moveList.size());
            Move move = moveList.getFirst();
            assertEquals(0, move.getFrom().getCol());
            assertEquals(5, move.getFrom().getRow());
            assertEquals(0, move.getTo().getCol());
            if (aPawn.isWhite()) {
                assertEquals(6, move.getTo().getRow());
            } else {
                assertEquals(4, move.getTo().getRow());
            }

            assertNull(move.getCaptured());
            assertNull(move.getPromotionBehaviour());
        } else {
            assertTrue(moveList.isEmpty());
        }

    }

    @Test
    void testMoveTwoForward() {
        AbstractChessPiece aPawn = (AbstractChessPiece) board.findPiece(Color.WHITE, AP.ordinal());
        assertNotNull(aPawn);
        assertInstanceOf(Pawn.class, aPawn);
        board.setPiece(0, 1, aPawn);
        List<Move> moveList = aPawn.generate(null);
        assertNotNull(moveList);
        assertFalse(moveList.isEmpty());
        assertEquals(2, moveList.size());

        Move move0 = moveList.getFirst(); // a2-a3
        assertEquals(Color.WHITE, move0.getFrom().getPiece().getColor());
        assertInstanceOf(Pawn.class, move0.getFrom().getPiece());
        assertEquals(0, move0.getFrom().getCol());
        assertEquals(1, move0.getFrom().getRow());
        assertEquals(0, move0.getTo().getCol());
        assertEquals(2, move0.getTo().getRow());

        Move move1 = moveList.get(1); // a2-a4
        assertEquals(Color.WHITE, move1.getFrom().getPiece().getColor());
        assertInstanceOf(Pawn.class, move1.getFrom().getPiece());
        assertEquals(0, move1.getFrom().getCol());
        assertEquals(1, move1.getFrom().getRow());
        assertEquals(0, move1.getTo().getCol());
        assertEquals(3, move1.getTo().getRow());
    }

    @Test
    void testMovePromote() {
        AbstractChessPiece pawn = (AbstractChessPiece) board.findPiece(Color.WHITE, DP.ordinal());
        assertNotNull(pawn);
        assertInstanceOf(Pawn.class, pawn);
        board.setPiece(3, 6, pawn); // pawn on d7

        Piece rook = board.findPiece(Color.BLACK, QR.ordinal());
        assertNotNull(rook);
        assertInstanceOf(Rook.class, rook);
        board.setPiece(2, 7, rook); // Black Queen Rook on c8

        List<Move> moveList = pawn.generate(null);
        assertNotNull(moveList);
        assertFalse(moveList.isEmpty());
        assertEquals(8, moveList.size());

        Move move0 = moveList.getFirst(); // D7xc8=Q
        assertInstanceOf(Pawn.class, move0.getFrom().getPiece());
        assertEquals(3, move0.getFrom().getCol());
        assertEquals(6, move0.getFrom().getRow());
        assertEquals(2, move0.getTo().getCol());
        assertEquals(7, move0.getTo().getRow());
        assertInstanceOf(Rook.class, move0.getCaptured());
        assertInstanceOf(QueenBehaviour.class, move0.getPromotionBehaviour());

        Move move1 = moveList.get(1); // D7xc8=R
        assertInstanceOf(Pawn.class, move1.getFrom().getPiece());
        assertEquals(3, move1.getFrom().getCol());
        assertEquals(6, move1.getFrom().getRow());
        assertEquals(2, move1.getTo().getCol());
        assertEquals(7, move1.getTo().getRow());
        assertInstanceOf(Rook.class, move1.getCaptured());
        assertInstanceOf(RookBehaviour.class, move1.getPromotionBehaviour());

        Move move2 = moveList.get(2); // D7xc8=N
        assertInstanceOf(Pawn.class, move2.getFrom().getPiece());
        assertEquals(3, move2.getFrom().getCol());
        assertEquals(6, move2.getFrom().getRow());
        assertEquals(2, move2.getTo().getCol());
        assertEquals(7, move2.getTo().getRow());
        assertInstanceOf(Rook.class, move2.getCaptured());
        assertInstanceOf(KnightBehaviour.class, move2.getPromotionBehaviour());

        // d7xc8 (capture black rook)
        Move move3 = moveList.get(3); // D7xc8=B
        assertInstanceOf(Pawn.class, move3.getFrom().getPiece());
        assertEquals(3, move3.getFrom().getCol());
        assertEquals(6, move3.getFrom().getRow());
        assertEquals(2, move3.getTo().getCol());
        assertEquals(7, move3.getTo().getRow());
        assertInstanceOf(Rook.class, move3.getCaptured());
        assertInstanceOf(BishopBehaviour.class, move3.getPromotionBehaviour());

        // d7-d8
        Move move4 = moveList.get(4); // D7-d8=Q
        assertInstanceOf(Pawn.class, move4.getFrom().getPiece());
        assertEquals(3, move4.getFrom().getCol());
        assertEquals(6, move4.getFrom().getRow());
        assertEquals(3, move4.getTo().getCol());
        assertEquals(7, move4.getTo().getRow());
        assertNull(move4.getCaptured());
        assertInstanceOf(QueenBehaviour.class, move4.getPromotionBehaviour());

        Move move5 = moveList.get(5); // D7-d8=R
        assertInstanceOf(Pawn.class, move5.getFrom().getPiece());
        assertEquals(3, move5.getFrom().getCol());
        assertEquals(6, move5.getFrom().getRow());
        assertEquals(3, move5.getTo().getCol());
        assertEquals(7, move5.getTo().getRow());
        assertNull(move5.getCaptured());
        assertInstanceOf(RookBehaviour.class, move5.getPromotionBehaviour());

        Move move6 = moveList.get(6); // D7-d8=N
        assertInstanceOf(Pawn.class, move6.getFrom().getPiece());
        assertEquals(3, move6.getFrom().getCol());
        assertEquals(6, move6.getFrom().getRow());
        assertEquals(3, move6.getTo().getCol());
        assertEquals(7, move6.getTo().getRow());
        assertNull(move6.getCaptured());
        assertInstanceOf(KnightBehaviour.class, move6.getPromotionBehaviour());

        Move move7 = moveList.get(7); // D7-d8=B
        assertInstanceOf(Pawn.class, move7.getFrom().getPiece());
        assertEquals(3, move7.getFrom().getCol());
        assertEquals(6, move7.getFrom().getRow());
        assertEquals(3, move7.getTo().getCol());
        assertEquals(7, move7.getTo().getRow());
        assertNull(move7.getCaptured());
        assertInstanceOf(BishopBehaviour.class, move7.getPromotionBehaviour());
    }

    @Test
    void testEnPassent() {
        AbstractChessPiece whitePawn = (AbstractChessPiece) board.findPiece(Color.WHITE, GP.ordinal());
        assertNotNull(whitePawn);
        assertInstanceOf(Pawn.class, whitePawn);
        board.setPiece(COL_G, ROW_5, whitePawn); // pawn on g5

        AbstractChessPiece blackPawn = (AbstractChessPiece) board.findPiece(Color.BLACK, HP.ordinal());
        assertNotNull(blackPawn);
        assertInstanceOf(Pawn.class, blackPawn);
        board.setPiece(COL_H, ROW_5, blackPawn); // pawn on h5

        Field fromField = board.getField(COL_H, ROW_7);
        fromField.setPiece(blackPawn);
        Field toField = board.getField(COL_H, ROW_5);
        Move prevMove = new Move(fromField, toField);

        List<Move> moveList = whitePawn.generate(prevMove);
        assertNotNull(moveList);
        assertEquals(2, moveList.size());

        Move move0 = moveList.getFirst();
        assertEquals(whitePawn, move0.getFrom().getPiece());
        assertEquals(COL_G, move0.getFrom().getCol());
        assertEquals(ROW_5, move0.getFrom().getRow());
        assertEquals(COL_G, move0.getTo().getCol());
        assertEquals(ROW_6, move0.getTo().getRow());
        assertNull(move0.getPromotionBehaviour());
        assertNull(move0.getCaptured());

        Move move1 = moveList.get(1);
        assertEquals(whitePawn, move1.getFrom().getPiece());
        assertEquals(COL_G, move1.getFrom().getCol());
        assertEquals(ROW_5, move1.getFrom().getRow());
        assertEquals(COL_H, move1.getTo().getCol());
        assertEquals(ROW_6, move1.getTo().getRow());
        assertNull(move1.getPromotionBehaviour());
        assertEquals(blackPawn, move1.getCaptured());
    }
}
