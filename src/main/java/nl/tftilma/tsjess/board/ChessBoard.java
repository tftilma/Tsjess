package nl.tftilma.tsjess.board;

import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.piece.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static nl.tftilma.tsjess.board.Position.*;
import static nl.tftilma.tsjess.piece.PieceIndex.*;


public class ChessBoard extends AbstractBoard {
    private static final int CHESS_NUM_COLS = 8;
    private static final int CHESS_NUM_ROWS = 8;

    private final Piece[] whitePieces = new Piece[16];
    private final Piece[] blackPieces = new Piece[16];
    private boolean whiteToMove;
    private Deque<Move> playedMoves;
    private Deque<Piece> capturedPieces = new LinkedList<>();
    private Move prevMove = null;

    public ChessBoard() {
        super(CHESS_NUM_COLS, CHESS_NUM_ROWS);
        emptyBoard();
    }

    public boolean isWhiteToMove() {
        return whiteToMove;
    }

    public boolean isMate() {
        return false;
    }

    public boolean isStaleMate() {
        return false;
    }

    public Move getPrevMove() {
        return prevMove;
    }

    private void emptyBoard() {
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

    public void init() {
        placePiecesStandard();
    }

    private void placePiecesStandard() {
        placePiecesStandard(0, 1, whitePieces);
        placePiecesStandard(7, 6, blackPieces);
    }

    private void placePiecesStandard(final int rowBack, final int rowPawn, final Piece[] pieces) {
        setPiece(COL_A, rowBack, pieces[QR.ordinal()]); // set WQR (or BQR) on A1 or A8
        setPiece(COL_B, rowBack, pieces[QN.ordinal()]); // set WQN on B1
        setPiece(COL_C, rowBack, pieces[QB.ordinal()]); // set WQB on C1
        setPiece(COL_D, rowBack, pieces[QQ.ordinal()]); // set WQQ on D1
        setPiece(COL_E, rowBack, pieces[KK.ordinal()]); // set WKK on E1
        setPiece(COL_F, rowBack, pieces[KB.ordinal()]); // set WKB on F1
        setPiece(COL_G, rowBack, pieces[KN.ordinal()]); // set WKN on G1
        setPiece(COL_H, rowBack, pieces[KR.ordinal()]); // set WKR on H1

        setPiece(COL_A, rowPawn, pieces[AP.ordinal()]); // set WQR on A1
        setPiece(COL_B, rowPawn, pieces[BP.ordinal()]); // set WQN on B1
        setPiece(COL_C, rowPawn, pieces[CP.ordinal()]); // set WQB on C1
        setPiece(COL_D, rowPawn, pieces[DP.ordinal()]); // set WQQ on D1
        setPiece(COL_E, rowPawn, pieces[EP.ordinal()]); // set WKK on E1
        setPiece(COL_F, rowPawn, pieces[FP.ordinal()]); // set WKB on F1
        setPiece(COL_G, rowPawn, pieces[GP.ordinal()]); // set WKN on G1
        setPiece(COL_H, rowPawn, pieces[HP.ordinal()]); // set WKR on H1
    }

    public void setPiece(final Field field, final Piece piece) {
        setPiece(field.getCol(), field.getRow(), piece, false);
    }

    public void initPiece(final int col, final int row, final Piece piece) {
        setPiece(col, row, piece, true);
    }

    public void setPiece(final int col, final int row, final Piece piece) {
        setPiece(col, row, piece, false);
    }

    private void setPiece(final int col, final int row, final Piece piece, boolean init) {
        Field field = this.getField(col, row);
        field.setPiece(piece);
        if (piece != null) {
            if (init) {
                piece.init(field);
            } else {
                piece.place(field);
            }
        }
    }

    public Piece getPiece(final Color color, final PieceIndex idx) {
        return color == Color.WHITE ?
                whitePieces[idx.ordinal()] :
                blackPieces[idx.ordinal()];
    }

    public Piece findPiece(final Color color, final int idx) {
        if (color == Color.WHITE) {
            return whitePieces[idx];
        } else if (color == Color.BLACK){
            return blackPieces[idx];
        } else {
            throw new IllegalStateException();
        }
    }

    public List<Move> generate(final Color color, final PieceIndex idx) {
        return getPiece(color, idx).generate(prevMove);
    }

    public boolean exists(final PieceIndex idx) {
        return exists(idx.ordinal());
    }

    public boolean exists(final int idx) {
        Piece piece;
        if (isWhiteToMove()) {
            piece = findPiece(Color.WHITE, idx);
        } else {
            piece = findPiece(Color.BLACK, idx);
        }
        if (piece == null) {
            return false;
        }
        return piece.isCaptured();
    }

    @Override
    public void setShortcuts(Field[][] fields) {
        FieldsFactory.create(fields);
    }

    public void play(final Move move) {
        Field fromPos = move.getFrom();
        Field toPos = move.getTo();
        Piece piece = fromPos.getPiece();
        Piece capturedPiece = move.getCaptured();
        setPiece(toPos.getCol(), toPos.getRow(), piece);
        setPiece(fromPos.getCol(), fromPos.getRow(), null);
        if (move.getPromotionBehaviour() != null) {
            Pawn pawn = (Pawn) piece;
            pawn.setBehaviour(move.getPromotionBehaviour());
        }
        if (capturedPiece != null) {
            capturedPieces.push(capturedPiece);
            if (toPos != capturedPiece.getField()) {
                // only for weird en-passent
                capturedPiece.getField().removePiece();
            }
            capturedPiece.capture();
        }
        // castling 0-0 and 0-0-0
        playCastling(piece, fromPos, toPos);

        this.playedMoves.push(move);
        whiteToMove = !whiteToMove; // WHITE -> BLACK -> WHITE
        prevMove = move;
    }

    private void playCastling(Piece piece, Field fromPos, Field toPos) {
        if (piece instanceof King) {
            //  we assume if the King made 2 col diffs it must be a castling
            if (fromPos.getCol() - toPos.getCol() == 2) {
                // 0-0-0
                // set queen rook manually
                ChessBoard board = piece.getBoard();
                Piece rook = board.findPiece(piece.getColor(), QR.ordinal());
                rook.place(board.getField(toPos.getCol()+1, toPos.getRow()));
                setPiece(toPos.getCol()+1, toPos.getRow(), rook); // set new place for rook
                setPiece(toPos.getCol()-2, toPos.getRow(), null); // old place is empty
            } else if (fromPos.getCol() - toPos.getCol() == -2 ) {
                // 0-0
                // set king rook manually
                Piece rook = piece.getBoard().findPiece(piece.getColor(), KR.ordinal());
                setPiece(toPos.getCol()-1, toPos.getRow(), rook); // set new place for rook
                setPiece(toPos.getCol()+1, toPos.getRow(), null); // old place is empty
            }
        }
    }

    public void undo() {
        Move move = playedMoves.pop();

        Field fromPos = move.getFrom();
        Field toPos = move.getTo();
        Piece piece = fromPos.getPiece();
        Piece capturedPiece = move.getCaptured();

        if (piece instanceof King) {
            if (toPos.getCol() - fromPos.getCol()  == 2) {
                // 0-0
                initPiece(COL_H, fromPos.getRow(),
                        piece.isWhite() ? whitePieces[KR.ordinal()] : blackPieces[KR.ordinal()]);
                initPiece(fromPos.getCol(), fromPos.getRow(), piece); // king must be reset to init
            } else if (toPos.getCol() - fromPos.getCol()  == -2) {
                // 0-0-0
                initPiece(COL_A, fromPos.getRow(),
                        piece.isWhite() ? whitePieces[QR.ordinal()] : blackPieces[QR.ordinal()]);
                initPiece(fromPos.getCol(), fromPos.getRow(), piece); // king must be reset to init
            } else {
                setPiece(fromPos.getCol(), fromPos.getRow(), piece);
                setPiece(toPos.getCol(), toPos.getRow(), move.getCaptured());
            }
        } else {
            setPiece(fromPos.getCol(), fromPos.getRow(), piece);
            setPiece(toPos.getCol(), toPos.getRow(), move.getCaptured());
        }

        if (move.getPromotionBehaviour() != null) {
            assert piece instanceof Pawn;
            Pawn pawn = (Pawn) piece;
            pawn.setBehaviour(new PawnBehaviour(pawn));
        }
        if (capturedPiece != null) {
            Piece foundCapturedPiece = capturedPieces.pop();
            assert foundCapturedPiece == capturedPiece;
            capturedPiece.place(fromPos);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CHESSBOARD\n");
        //sb.append("numCols="); sb.append(getNumCols()); sb.append("\n");
        //sb.append("numRows="); sb.append(getNumRows()); sb.append("\n");
        for (int r=getNumRows()-1; r>=0; r--) {
            for (int c = 0; c < getNumCols(); c++) {
                sb.append(this.getField(c, r));
                if (c < 7) {
                    sb.append("-");
                } else {
                    sb.append("\n");
                }
            }
        }
        sb.append("Captured: ");
        capturedPieces.forEach(p -> sb.append(p).append("[").append(p.getIdx()).append("] "));
        sb.append("\n");

        return  sb.toString();
    }
}
