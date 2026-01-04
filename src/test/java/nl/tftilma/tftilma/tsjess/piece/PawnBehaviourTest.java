package nl.tftilma.tftilma.tsjess.piece;

import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.Move;
import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;
import nl.tftilma.tsjess.piece.ChessPiece;
import nl.tftilma.tsjess.piece.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nl.tftilma.tsjess.piece.PieceIndex.*;
import static org.junit.jupiter.api.Assertions.*;

public class PawnBehaviourTest {
    private ChessBoard board;

    @BeforeEach
    void setup() {
        board = new ChessBoard();
        board.emptyBoard();
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
        ChessPiece aPawn = (ChessPiece) board.findPiece(color, AP.ordinal());
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
        ChessPiece aPawn = (ChessPiece) board.findPiece(Color.WHITE, AP.ordinal());
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
    void testMovePromoteQueen() {

    }

    @Test
    void testCapturePomoteRook() {

    }

    @Test
    void testMovePromoteKnight() {

    }

    @Test
    void testCapturePomoteBishop() {

    }

    @Test
    void testEnPassent() {

    }
}
