package nl.home.ttilma.tsjess.piece;

import nl.home.ttilma.game.board.Color;
import nl.home.ttilma.game.board.Position;
import nl.home.ttilma.game.piece.AbstractPiece;
import nl.home.ttilma.game.piece.Piece;
import nl.home.ttilma.tsjess.board.ChessBoard;
import nl.home.ttilma.tsjess.board.ChessPieceIdx;

public abstract class AbstractChessPiece extends AbstractPiece<ChessBoard> implements Piece<ChessBoard> {
    private ChessPieceIdx idx;
    
    public AbstractChessPiece(Color color) {
        super(color);
    }

    public AbstractChessPiece(Position pos, Color color) {
        super(pos, color);
    }

    public void setIdx(ChessPieceIdx idx) {
        this.idx = idx;
    }

    public ChessPieceIdx getIdx() {
        return idx;
    }
}
