package nl.home.ttilma.tsjess.board;

import nl.home.ttilma.game.board.AbstractBoard;
import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.piece.Piece;
import nl.home.ttilma.tsjess.board.ChessPieceIdx;
import nl.home.ttilma.tsjess.piece.Bishop;
import nl.home.ttilma.tsjess.piece.King;
import nl.home.ttilma.tsjess.piece.Knight;
import nl.home.ttilma.tsjess.piece.Pawn;
import nl.home.ttilma.tsjess.piece.Queen;
import nl.home.ttilma.tsjess.piece.Rook;

public class ChessBoard extends AbstractBoard {
    protected ChessPieceIdx[] pieceIdxs;
    
    public ChessBoard() {
        super(8, 8);
        pieceIdxs = new ChessPieceIdx[32];
    }

    public void initialChessBoard() {
        initPiece(Position.COL_A, Position.ROW_1, ChessPieceIdx.WQR, new Rook(Color.WHITE));
        initPiece(Position.COL_B, Position.ROW_1, ChessPieceIdx.WQN, new Knight(Color.WHITE));
        initPiece(Position.COL_C, Position.ROW_1, ChessPieceIdx.WQB, new Bishop(Color.WHITE));
        initPiece(Position.COL_D, Position.ROW_1, ChessPieceIdx.WQQ, new Queen(Color.WHITE));
        initPiece(Position.COL_E, Position.ROW_1, ChessPieceIdx.WKK, new King(Color.WHITE));
        initPiece(Position.COL_F, Position.ROW_1, ChessPieceIdx.WKB, new Bishop(Color.WHITE));
        initPiece(Position.COL_G, Position.ROW_1, ChessPieceIdx.WKN, new Knight(Color.WHITE));
        initPiece(Position.COL_H, Position.ROW_1, ChessPieceIdx.WKR, new Rook(Color.WHITE));

        initPiece(Position.COL_A, Position.ROW_2, ChessPieceIdx.WAX, new Pawn(Color.WHITE));
        initPiece(Position.COL_B, Position.ROW_2, ChessPieceIdx.WBX, new Pawn(Color.WHITE));
        initPiece(Position.COL_C, Position.ROW_2, ChessPieceIdx.WCX, new Pawn(Color.WHITE));
        initPiece(Position.COL_D, Position.ROW_2, ChessPieceIdx.WDX, new Pawn(Color.WHITE));
        initPiece(Position.COL_E, Position.ROW_2, ChessPieceIdx.WEX, new Pawn(Color.WHITE));
        initPiece(Position.COL_F, Position.ROW_2, ChessPieceIdx.WFX, new Pawn(Color.WHITE));
        initPiece(Position.COL_G, Position.ROW_2, ChessPieceIdx.WGX, new Pawn(Color.WHITE));
        initPiece(Position.COL_H, Position.ROW_2, ChessPieceIdx.WHX, new Pawn(Color.WHITE));

        initPiece(Position.COL_A, Position.ROW_7, ChessPieceIdx.BAX, new Pawn(Color.BLACK));
        initPiece(Position.COL_B, Position.ROW_7, ChessPieceIdx.BBX, new Pawn(Color.BLACK));
        initPiece(Position.COL_C, Position.ROW_7, ChessPieceIdx.BCX, new Pawn(Color.BLACK));
        initPiece(Position.COL_D, Position.ROW_7, ChessPieceIdx.BDX, new Pawn(Color.BLACK));
        initPiece(Position.COL_E, Position.ROW_7, ChessPieceIdx.BEX, new Pawn(Color.BLACK));
        initPiece(Position.COL_F, Position.ROW_7, ChessPieceIdx.BFX, new Pawn(Color.BLACK));
        initPiece(Position.COL_G, Position.ROW_7, ChessPieceIdx.BGX, new Pawn(Color.BLACK));
        initPiece(Position.COL_H, Position.ROW_7, ChessPieceIdx.BHX, new Pawn(Color.BLACK));

        initPiece(Position.COL_A, Position.ROW_8, ChessPieceIdx.BQR, new Rook(Color.BLACK));
        initPiece(Position.COL_B, Position.ROW_8, ChessPieceIdx.BQN, new Knight(Color.BLACK));
        initPiece(Position.COL_C, Position.ROW_8, ChessPieceIdx.BQB, new Bishop(Color.BLACK));
        initPiece(Position.COL_D, Position.ROW_8, ChessPieceIdx.BQQ, new Queen(Color.BLACK));
        initPiece(Position.COL_E, Position.ROW_8, ChessPieceIdx.BKK, new King(Color.BLACK));
        initPiece(Position.COL_F, Position.ROW_8, ChessPieceIdx.BKB, new Bishop(Color.BLACK));
        initPiece(Position.COL_G, Position.ROW_8, ChessPieceIdx.BKN, new Knight(Color.BLACK));
        initPiece(Position.COL_H, Position.ROW_8, ChessPieceIdx.BKR, new Rook(Color.BLACK));
    }

    public void initPiece(int col, int row, ChessPieceIdx idx, Piece<ChessBoard> piece) {
        Position position = new Position(col, row);
        piece.setPosition(position);
        piece.setAtInitialPosition(true); // only at initialization
        fields[col][row].setPiece((Piece<? extends AbstractBoard>) piece);
        idx.setPiece(piece);
        idx.setPosition(position);
        pieceIdxs[idx.getIdx()] = idx;
    }
    
    public ChessPieceIdx getPieceIdx(int idx) {
        return pieceIdxs[idx];
    }
    
    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int y=7; y>=0; y--) {
            for (int x=0; x<8; x++) {
                if (fields[x][y].getPiece() != null) {
                    sb.append(fields[x][y].getPiece().print());
                } else {
                    sb.append(".");
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
