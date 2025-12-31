package nl.tftilma.tsjess.board;

import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.piece.*;

import static nl.tftilma.tsjess.piece.PieceIndex.*;

public class ChessBoard extends AbstractBoard {
    private static final int CHESS_NUM_COLS = 8;
    private static final int CHESS_NUM_ROWS = 8;

    private final Piece[] whitePieces = new Piece[16];
    private final Piece[] blackPieces = new Piece[16];

    public ChessBoard() {
        super(CHESS_NUM_COLS, CHESS_NUM_ROWS);
    }

    public void init() {
        emptyBoard();
        placePiecesStandard();
    }

    private void placePiecesStandard() {

    }

    public void emptyBoard() {
        initWhitePieces();
        initBlackPieces();
    }

    private void initWhitePieces() {
        initPieces(whitePieces, Color.WHITE);
    }

    private void initBlackPieces() {
        initPieces(blackPieces, Color.BLACK);
    }

    private void initPieces(final Piece[] pieces, final Color color) {
        pieces[QR.ordinal()] = new Rook(color, QR, this);
        pieces[QN.ordinal()] = new Knight(color, QN, this);
        pieces[QB.ordinal()] = new Bishop(color, QB, this);
        pieces[QQ.ordinal()] = new Queen(color, QQ, this);
        pieces[KK.ordinal()] = new King(color, KK, this);
        pieces[KB.ordinal()] = new Bishop(color, KB, this);
        pieces[KN.ordinal()] = new Knight(color, KN, this);
        pieces[KR.ordinal()] = new Rook(color, KR, this);

        for (int pawnIdx=8; pawnIdx<16; pawnIdx++) {
            pieces[pawnIdx] = new Pawn(color, pawnIdx, this);
        }
    }

    public void setPiece(final int col, final int row, final Piece piece) {
        Field field = this.getField(col, row);
        field.setPiece(piece);
        piece.place(field);
    }

    public Piece findPiece(final Color color, final int idx) {
        if (color == Color.WHITE) {
            return whitePieces[idx];
        } else if (color == Color.BLACK){
            return blackPieces[idx];
        } else {
            return null;
        }
    }
}
