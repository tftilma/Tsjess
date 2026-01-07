package nl.tftilma.tsjess.board;

import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.piece.*;

import java.util.Deque;
import java.util.LinkedList;

import static nl.tftilma.tsjess.piece.PieceIndex.*;

public class ChessBoard extends AbstractBoard {
    private static final int CHESS_NUM_COLS = 8;
    private static final int CHESS_NUM_ROWS = 8;

    private final Piece[] whitePieces = new Piece[16];
    private final Piece[] blackPieces = new Piece[16];
    private boolean whiteToMove;
    private Deque<Move> playedMoves;
    private Deque<Piece> capturedPieces;

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
        whiteToMove = true;
        capturedPieces = new LinkedList<>();
        playedMoves = new LinkedList<>();
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

    public void play(final Move move) {
        Field fromPos = move.getFrom();
        Field toPos = move.getTo();
        Piece piece = move.getFrom().getPiece();
        Piece capturedPiece = move.getCaptured();
        setPiece(toPos.getCol(), toPos.getRow(), piece);
        setPiece(fromPos.getCol(), fromPos.getRow(), null);
        if (move.getPromotionBehaviour() != null) {
            Pawn pawn = (Pawn) piece;
            pawn.setBehaviour(move.getPromotionBehaviour());
        }
        if (capturedPiece != null) {
            capturedPieces.push(capturedPiece);
            capturedPiece.capture();
        }

        this.playedMoves.push(move);
        whiteToMove = !whiteToMove; // WHITE -> BLACK -> WHITE
    }

    public void undo() {
        Move move = playedMoves.pop();

        Field fromPos = move.getFrom();
        Field toPos = move.getTo();
        Piece piece = move.getFrom().getPiece();
        Piece capturedPiece = move.getCaptured();
        setPiece(fromPos.getCol(), fromPos.getRow(), piece);
        setPiece(toPos.getCol(), toPos.getRow(), move.getCaptured());

        if (move.getPromotionBehaviour() != null) {
            Pawn pawn = (Pawn) piece;
            pawn.setBehaviour(new PawnBehaviour(pawn));
        }
        if (capturedPiece != null) {
            Piece foundCapturedPiece = capturedPieces.pop();
            capturedPiece.place(fromPos);
        }
    }


    public String print() {
        StringBuilder sb = new StringBuilder();
        return  sb.toString();
    }
}
