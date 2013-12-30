package nl.home.ttilma.tsjess.piece;

import java.util.List;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Move;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.piece.Piece;
import nl.home.ttilma.tsjess.board.ChessBoard;
import nl.home.ttilma.tsjess.board.ChessPieceIdx;

/**
 * 
 * @author Tsjisse Tilma
 *
 */
public class King extends AbstractChessPiece {
    public King(Color color) {
        super(color);
    }
    
    public King(Position pos, Color color) {
        super(pos, color);
    }

    @Override
    public void moveGen(ChessBoard board, List<Move> moveList) {
        tryAndCreateMoves(board, moveList,  0,  1, 1); // forward
        tryAndCreateMoves(board, moveList, -1,  0, 1); // left
        tryAndCreateMoves(board, moveList,  1,  0, 1); // right
        tryAndCreateMoves(board, moveList,  0, -1, 1); // back
        
        tryAndCreateMoves(board, moveList, -1,  1, 1);
        tryAndCreateMoves(board, moveList,  1,  1, 1);
        tryAndCreateMoves(board, moveList, -1, -1, 1);
        tryAndCreateMoves(board, moveList,  1, -1, 1);
        
        if (isAtInitPosition()) {
            // the king is at init-position, so kingsposition not relevant
            if (isWhite()) {
                tryWhiteShortCastle(moveList, board);
                tryWhiteLongCastle(moveList, board);
            } else {
                tryBlackShortCastle(moveList, board);
                tryBlackLongCastle(moveList, board);
            }
        }
    }
    
    private void tryBlackLongCastle(List<Move> moveList, ChessBoard board) {
        Piece<ChessBoard> bqr = board.getPieceIdx(ChessPieceIdx.BQR.getIdx()).getPiece();
        if (bqr == null) {
            return; // bqr was captured
        }
        if (!bqr.isAtInitPosition()) {
            return; // bqr no longer at init-position
        }
        if (board.getField(Position.COL_B, Position.ROW_8).getPiece() != null) {
            return; // there's a piece at B8, or say not empty
        }
        if (board.getField(Position.COL_C, Position.ROW_8).getPiece() != null) {
            return; // there's a piece at C8, or say not empty
        }
        if (board.getField(Position.COL_D, Position.ROW_8).getPiece() != null) {
            return; // there's a piece at D8, or say not empty
        }
        // TODO test for check on E8, D8 and C8
        Position toPos = new Position(Position.COL_C, Position.ROW_8);
        moveList.add(new Move(getPosition(), toPos));
    }

    private void tryBlackShortCastle(List<Move> moveList, ChessBoard board) {
        Piece<ChessBoard> bkr = board.getPieceIdx(ChessPieceIdx.BKR.getIdx()).getPiece();
        if (bkr == null) {
            return; // bkr was captured
        }
        if (!bkr.isAtInitPosition()) {
            return; // bkr no longer at init-position
        }
        if (board.getField(Position.COL_F, Position.ROW_8).getPiece() != null) {
            return; // there's a piece at B8, or say not empty
        }
        if (board.getField(Position.COL_G, Position.ROW_8).getPiece() != null) {
            return; // there's a piece at G8, or say not empty
        }
        // TODO test for check on E8, F8 and G8
        Position toPos = new Position(Position.COL_G, Position.ROW_8);
        moveList.add(new Move(getPosition(), toPos));
    }

    private void tryWhiteLongCastle(List<Move> moveList, ChessBoard board) {
        Piece<ChessBoard> wqr = board.getPieceIdx(ChessPieceIdx.WQR.getIdx()).getPiece();
        if (wqr == null) {
            return; // wqr was captured
        }
        if (!wqr.isAtInitPosition()) {
            return; // wqr no longer at init-position
        }
        if (board.getField(Position.COL_B, Position.ROW_1).getPiece() != null) {
            return; // there's a piece at B1, or say not empty
        }
        if (board.getField(Position.COL_C, Position.ROW_1).getPiece() != null) {
            return; // there's a piece at C1, or say not empty
        }
        if (board.getField(Position.COL_D, Position.ROW_1).getPiece() != null) {
            return; // there's a piece at D1, or say not empty
        }
        // TODO test for check on E1, D1 and C1
        Position toPos = new Position(Position.COL_C, Position.ROW_1);
        moveList.add(new Move(getPosition(), toPos));
   }

    private void tryWhiteShortCastle(List<Move> moveList, ChessBoard board) {
        Piece<ChessBoard> wkr = board.getPieceIdx(ChessPieceIdx.WKR.getIdx()).getPiece();
        if (wkr == null) {
            return; // wkr was captured
        }
        if (!wkr.isAtInitPosition()) {
            return; // wkr no longer at init-position
        }
        if (board.getField(Position.COL_F, Position.ROW_1).getPiece() != null) {
            return; // there's a piece at B1, or say not empty
        }
        if (board.getField(Position.COL_G, Position.ROW_1).getPiece() != null) {
            return; // there's a piece at G1, or say not empty
        }
        // TODO test for check on E1, F1 and G1
        Position toPos = new Position(Position.COL_G, Position.ROW_1);
        moveList.add(new Move(getPosition(), toPos));
    }

    public String print() {
        return isWhite() ? "K" : "k";
    }
}
