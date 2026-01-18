package nl.tftilma.tsjess.board;

import nl.tftilma.game.board.AbstractBoard;
import nl.tftilma.game.board.Field;
import nl.tftilma.game.board.Piece;
import nl.tftilma.tsjess.move.Move;
import nl.tftilma.tsjess.piece.*;

import java.util.Deque;
import java.util.LinkedList;

import static nl.tftilma.game.board.Field.*;
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

    public ChessBoard() {
        super(CHESS_NUM_COLS, CHESS_NUM_ROWS);
    }

    public void init() {
        emptyBoard();
        placePiecesStandard();
    }

    private void placePiecesStandard() {
        this.setPiece(A1, whitePieces[QR.ordinal()]); // set WQR on A1
        this.setPiece(B1, whitePieces[QN.ordinal()]); // set WQN on B1
        this.setPiece(C1, whitePieces[QB.ordinal()]); // set WQB on C1
        this.setPiece(COL_D, ROW_1, whitePieces[QQ.ordinal()]); // set WQQ on D1
        this.setPiece(COL_E, ROW_1, whitePieces[KK.ordinal()]); // set WKK on E1
        this.setPiece(COL_F, ROW_1, whitePieces[KB.ordinal()]); // set WKB on F1
        this.setPiece(COL_G, ROW_1, whitePieces[KN.ordinal()]); // set WKN on G1
        this.setPiece(COL_H, ROW_1, whitePieces[KR.ordinal()]); // set WKR on H1

        this.setPiece(COL_A, ROW_2, whitePieces[AP.ordinal()]); // set WQR on A1
        this.setPiece(COL_B, ROW_2, whitePieces[BP.ordinal()]); // set WQN on B1
        this.setPiece(COL_C, ROW_2, whitePieces[CP.ordinal()]); // set WQB on C1
        this.setPiece(COL_D, ROW_2, whitePieces[DP.ordinal()]); // set WQQ on D1
        this.setPiece(COL_E, ROW_2, whitePieces[EP.ordinal()]); // set WKK on E1
        this.setPiece(COL_F, ROW_2, whitePieces[FP.ordinal()]); // set WKB on F1
        this.setPiece(COL_G, ROW_2, whitePieces[GP.ordinal()]); // set WKN on G1
        this.setPiece(COL_H, ROW_2, whitePieces[HP.ordinal()]); // set WKR on H1

        this.setPiece(COL_A, ROW_8, blackPieces[QR.ordinal()]); // set BQR on A8
        this.setPiece(COL_B, ROW_8, blackPieces[QN.ordinal()]); // set BQN on B8
        this.setPiece(COL_C, ROW_8, blackPieces[QB.ordinal()]); // set BQB on C8
        this.setPiece(COL_D, ROW_8, blackPieces[QQ.ordinal()]); // set BQQ on D8
        this.setPiece(COL_E, ROW_8, blackPieces[KK.ordinal()]); // set BKK on E8
        this.setPiece(COL_F, ROW_8, blackPieces[KB.ordinal()]); // set BKB on F8
        this.setPiece(COL_G, ROW_8, blackPieces[KN.ordinal()]); // set BKN on G8
        this.setPiece(COL_H, ROW_8, blackPieces[KR.ordinal()]); // set BKR on H8

        this.setPiece(COL_A, ROW_7, blackPieces[AP.ordinal()]); // set BQR on A7
        this.setPiece(COL_B, ROW_7, blackPieces[BP.ordinal()]); // set BQN on B7
        this.setPiece(COL_C, ROW_7, blackPieces[CP.ordinal()]); // set BQB on C7
        this.setPiece(COL_D, ROW_7, blackPieces[DP.ordinal()]); // set BQQ on D7
        this.setPiece(COL_E, ROW_7, blackPieces[EP.ordinal()]); // set BKK on E7
        this.setPiece(COL_F, ROW_7, blackPieces[FP.ordinal()]); // set BKB on F7
        this.setPiece(COL_G, ROW_7, blackPieces[GP.ordinal()]); // set BKN on G7
        this.setPiece(COL_H, ROW_7, blackPieces[HP.ordinal()]); // set BKR on H7
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

    public void setPiece(final Field field, final Piece piece) {
        setPiece(field.getCol(), field.getRow(), piece, false);
    }

    public void setPiece(final int col, final int row, final Piece piece) {
        setPiece(col, row, piece, false);
    }

    public void initPiece(final int col, final int row, final Piece piece) {
        setPiece(col, row, piece, true);
    }

    public void setPiece(final int col, final int row, final Piece piece, boolean init) {
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

    public Piece findPiece(final Color color, final int idx) {
        if (color == Color.WHITE) {
            return whitePieces[idx];
        } else if (color == Color.BLACK){
            return blackPieces[idx];
        } else {
            return null;
        }
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
        return piece.isCaptured();
    }

    @Override
    public void setShortcuts(Field[][] fields) {
        A1 = fields[COL_A][ROW_1];
        Field.A2 = fields[COL_A][ROW_2];
        Field.A3 = fields[COL_A][ROW_3];
        Field.A4 = fields[COL_A][ROW_4];
        Field.A5 = fields[COL_A][ROW_5];
        Field.A6 = fields[COL_A][ROW_6];
        Field.A7 = fields[COL_A][ROW_7];
        Field.A8 = fields[COL_A][ROW_8];

        Field.B1 = fields[COL_B][ROW_1];
        Field.B2 = fields[COL_B][ROW_2];
        Field.B3 = fields[COL_B][ROW_3];
        Field.B4 = fields[COL_B][ROW_4];
        Field.B5 = fields[COL_B][ROW_5];
        Field.B6 = fields[COL_B][ROW_6];
        Field.B7 = fields[COL_B][ROW_7];
        Field.B8 = fields[COL_B][ROW_8];

        Field.C1 = fields[COL_C][ROW_1];
        Field.C2 = fields[COL_C][ROW_2];
        Field.C3 = fields[COL_C][ROW_3];
        Field.C4 = fields[COL_C][ROW_4];
        Field.C5 = fields[COL_C][ROW_5];
        Field.C6 = fields[COL_C][ROW_6];
        Field.C7 = fields[COL_C][ROW_7];
        Field.C8 = fields[COL_C][ROW_8];

        Field.D1 = fields[COL_D][ROW_1];
        Field.D2 = fields[COL_D][ROW_2];
        Field.D3 = fields[COL_D][ROW_3];
        Field.D4 = fields[COL_D][ROW_4];
        Field.D5 = fields[COL_D][ROW_5];
        Field.D6 = fields[COL_D][ROW_6];
        Field.D7 = fields[COL_D][ROW_7];
        Field.D8 = fields[COL_D][ROW_8];

        Field.E1 = fields[COL_E][ROW_1];
        Field.E2 = fields[COL_E][ROW_2];
        Field.E3 = fields[COL_E][ROW_3];
        Field.E4 = fields[COL_E][ROW_4];
        Field.E5 = fields[COL_E][ROW_5];
        Field.E6 = fields[COL_E][ROW_6];
        Field.E7 = fields[COL_E][ROW_7];
        Field.E8 = fields[COL_E][ROW_8];

        Field.F1 = fields[COL_F][ROW_1];
        Field.F2 = fields[COL_F][ROW_2];
        Field.F3 = fields[COL_F][ROW_3];
        Field.F4 = fields[COL_F][ROW_4];
        Field.F5 = fields[COL_F][ROW_5];
        Field.F6 = fields[COL_F][ROW_6];
        Field.F7 = fields[COL_F][ROW_7];
        Field.F8 = fields[COL_F][ROW_8];

        Field.G1 = fields[COL_G][ROW_1];
        Field.G2 = fields[COL_G][ROW_2];
        Field.G3 = fields[COL_G][ROW_3];
        Field.G4 = fields[COL_G][ROW_4];
        Field.G5 = fields[COL_G][ROW_5];
        Field.G6 = fields[COL_G][ROW_6];
        Field.G7 = fields[COL_G][ROW_7];
        Field.G8 = fields[COL_G][ROW_8];

        Field.H1 = fields[COL_H][ROW_1];
        Field.H2 = fields[COL_H][ROW_2];
        Field.H3 = fields[COL_H][ROW_3];
        Field.H4 = fields[COL_H][ROW_4];
        Field.H5 = fields[COL_H][ROW_5];
        Field.H6 = fields[COL_H][ROW_6];
        Field.H7 = fields[COL_H][ROW_7];
        Field.H8 = fields[COL_H][ROW_8];
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

    public boolean isWhiteToMove() {
        return whiteToMove;
    }
}
