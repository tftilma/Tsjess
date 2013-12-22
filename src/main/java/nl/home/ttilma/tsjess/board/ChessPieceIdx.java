package nl.home.ttilma.tsjess.board;

import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.piece.Piece;

public enum ChessPieceIdx {
    WQR(0), WQN(1), WQB(2), WQQ(3), WKK(4), WKB(5), WKN(6), WKR(7), 
    WAX(8), WBX(9), WCX(10), WDX(11), WEX(12), WFX(13), WGX(14), WHX(15), 
    BQR(16), BQN(17), BQB(18), BQQ(19), BKK(20), BKB(21), BKN(22), BKR(23), 
    BAX(24), BBX(25), BCX(26), BDX(27), BEX(28), BFX(29), BGX(30), BHX(31);

    private int idx;
    private Position pos;
    private Piece<ChessBoard> piece; // so a pawn could be promoted to a Queen... captured=null

    private ChessPieceIdx(int idx) {
        this.idx = idx;
    }

    private ChessPieceIdx(int idx, Position initialPos, Piece<ChessBoard> initialPiece) {
        this.idx = idx;
        this.pos = initialPos;
        this.piece = initialPiece;
        initialPiece.setPosition(initialPos);
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }

    public Position getPosition() {
        return pos;
    }

    public void setPiece(Piece<ChessBoard> piece) {
        this.piece = piece;
    }

    public Piece<ChessBoard> getPiece() {
        return piece;
    }
    
    public boolean isCaptured() {
        return piece == null;
    }

    public int getIdx() {
        return idx;
    }
}
