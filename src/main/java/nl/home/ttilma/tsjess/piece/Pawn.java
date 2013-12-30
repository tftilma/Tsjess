package nl.home.ttilma.tsjess.piece;

import java.util.List;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.MoveResult;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.piece.Piece;
import nl.home.ttilma.tsjess.board.ChessBoard;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class Pawn extends AbstractChessPiece {
    public Pawn(Color color) {
        super(color);
    }
    
    public Pawn(Position pos, Color color) {
        super(pos, color);
    }

    @Override
    public void moveGen(ChessBoard board, List<Move> moveList) {
        if (tryForward(board, moveList)) {
            tryDoubleForward(board, moveList);
        }
        if (getPosition().getCol() > Position.COL_A) {
            tryCapture(board, moveList, -1);
        }
        if (getPosition().getCol() < Position.COL_H) {
            tryCapture(board, moveList, +1);
        }
        // TODO En-passent
    }

    private boolean tryForward(ChessBoard board, List<Move> moveList) {
        if (isWhite()) {
            // WHITE
            if (getPosition().getRow() == Position.ROW_7){
                Position toPos = new Position(getPosition().getCol(), Position.ROW_8);
                if (board.getField(toPos).getPiece() == null) { 
                    createPromotion(board, moveList, toPos, new Queen(Color.WHITE), false);
                    createPromotion(board, moveList, toPos, new Rook(Color.WHITE), false);
                    createPromotion(board, moveList, toPos, new Knight(Color.WHITE), false);
                    createPromotion(board, moveList, toPos, new Bishop(Color.WHITE), false);
                }
                return false;
            } else {
                // normal 
                if (tryMove(board, 0, 1, false, true) == MoveResult.VALID_CONT) {
                    // field was empty, so normal forward
                    moveList.add(createMove(board, 0, 1));
                    if (isAtInitPosition()) {
                        // try double forward
                        return true;
                    }
                } 
                return false;
            }
        } else {
            if (getPosition().getRow() == Position.ROW_2) {
                Position toPos = new Position(getPosition().getCol(), Position.ROW_1);
                if (board.getField(toPos).getPiece() == null) { 
                    createPromotion(board, moveList, toPos, new Queen(Color.BLACK), false);
                    createPromotion(board, moveList, toPos, new Rook(Color.BLACK), false);
                    createPromotion(board, moveList, toPos, new Knight(Color.BLACK), false);
                    createPromotion(board, moveList, toPos, new Bishop(Color.BLACK), false);
                }
                return false;
            } else {
                // normal 
                if (tryMove(board, 0, -1, false, true) == MoveResult.VALID_CONT) {
                    // field was empty, so normal forward
                    moveList.add(createMove(board, 0, -1));
                    if (isAtInitPosition()) {
                        return true;
                    }
                } 
                return false;
            }
        }
    }

    private void createPromotion(ChessBoard board, List<Move> moveList, Position toPos, Piece<?> promotionPiece, boolean capturing) {
        Move m = new Move(getPosition(), toPos);
        m.setPromotedPiece(promotionPiece);
        m.setCapturing(capturing);
        moveList.add(m);
    }

    private void tryDoubleForward(ChessBoard board, List<Move> moveList) {
        if (isWhite()) {
            if (tryMove(board, 0, 2, false, true) == MoveResult.VALID_CONT) {
                moveList.add(createMove(board, 0, 2));
            }
        } else {
            if (tryMove(board, 0, -2, false, true) == MoveResult.VALID_CONT) {
                moveList.add(createMove(board, 0, -2));
            }
        }
    }

    private void tryCapture(ChessBoard board, List<Move> moveList, int deltaX) {
        if (isWhite()) {
            if (tryMove(board, deltaX, +1, true, false) == MoveResult.VALID_STOP) {
                if (getPosition().getRow() == Position.ROW_8) {
                    Position toPos = new Position(getPosition().getCol() + deltaX, Position.ROW_8);
                    createPromotion(board, moveList, toPos, new Queen(Color.WHITE), true);
                    createPromotion(board, moveList, toPos, new Rook(Color.WHITE), true);
                    createPromotion(board, moveList, toPos, new Knight(Color.WHITE), true);
                    createPromotion(board, moveList, toPos, new Bishop(Color.WHITE), true);
                } else {
                    Move m = createMove(board, deltaX, +1);
                    m.setCapturing(true);
                    moveList.add(m);
                }
            }
        } else {
            if (tryMove(board, deltaX, -1, true, false) == MoveResult.VALID_STOP) {
                if (getPosition().getRow() == Position.ROW_2) {
                    Position toPos = new Position(getPosition().getCol() + deltaX, Position.ROW_1);
                    createPromotion(board, moveList, toPos, new Queen(Color.BLACK), true);
                    createPromotion(board, moveList, toPos, new Rook(Color.BLACK), true);
                    createPromotion(board, moveList, toPos, new Knight(Color.BLACK), true);
                    createPromotion(board, moveList, toPos, new Bishop(Color.BLACK), true);
                } else {
                    Move m = createMove(board, deltaX, -1);
                    m.setCapturing(true); 
                    moveList.add(m);
                }
            }
        }
    }
    
    public String print() {
        return isWhite() ? "X" : "x";
    }
}
