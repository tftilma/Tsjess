package nl.ttilma.games.chess.dom.board;

import nl.ttilma.games.chess.dom.game.Move;
import nl.ttilma.games.chess.engine.piece.*;

import java.util.ArrayList;
import java.util.List;

import static nl.ttilma.games.chess.engine.piece.ChessPieceId.*;


public class ChessBoard {
    private final ChessPiece pieces[];
    private Color toMove;
    private Field fields[][];

    public ChessBoard() {
        this.fields = new Field[8][8];
        for (int col=0; col<8; col++) {
            for (int row=0; row<8; row++) {
                fields[col][row] = new Field();
            }
        }
        pieces = new ChessPiece[32];
    }

    public void startPosition() {
        toMove = Color.WHITE;

        setToPos(new Pawn(this, WAX), Position.A2);
        setToPos(new Pawn(this, WBX), Position.B2);
        setToPos(new Pawn(this, WCX), Position.C2);
        setToPos(new Pawn(this, WDX), Position.D2);
        setToPos(new Pawn(this, WEX), Position.E2);
        setToPos(new Pawn(this, WFX), Position.F2);
        setToPos(new Pawn(this, WGX), Position.G2);
        setToPos(new Pawn(this, WHX), Position.H2);

        setToPos(new Pawn(this, BAX), Position.A7);
        setToPos(new Pawn(this, BBX), Position.B7);
        setToPos(new Pawn(this, BCX), Position.C7);
        setToPos(new Pawn(this, BDX), Position.D7);
        setToPos(new Pawn(this, BEX), Position.E7);
        setToPos(new Pawn(this, BFX), Position.F7);
        setToPos(new Pawn(this, BGX), Position.G7);
        setToPos(new Pawn(this, BHX), Position.H7);

        setToPos(new Rook(this, WQR), Position.A1);
        setToPos(new Knight(this, WQN), Position.B1);
        setToPos(new Bishop(this, WQB), Position.C1);
        setToPos(new Queen(this, WQQ), Position.D1);
        setToPos(new King(this, WKK), Position.E1);
        setToPos(new Bishop(this, WKB), Position.F1);
        setToPos(new Knight(this, WKN),Position.G1);
        setToPos(new Rook(this, WKR), Position.H1);

        setToPos(new Rook(this, BQR), Position.A8);
        setToPos(new Knight(this, BQN), Position.B8);
        setToPos(new Bishop(this, BQB), Position.C8);
        setToPos(new Queen(this, BQQ), Position.D8);
        setToPos(new King(this, BKK), Position.E8);
        setToPos(new Bishop(this, BKB), Position.F8);
        setToPos(new Knight(this, BKN), Position.G8);
        setToPos(new Rook(this, BKR), Position.H8);
    }

    public void setToPos(ChessPiece piece, Position position) {
        ChessPieceId pieceId = piece.getId();
        Color pieceColor = pieceId.getColor();
        pieces[pieceId.ordinal()] = piece;

        piece.setPos(position);

        fields[position.getCol()][position.getRow()].setPiece(piece);
    }

    public List<Move> generateMoves() {
        if (toMove == Color.WHITE) {
            return generateMoves(0, 15);
        } else {
            return generateMoves(16, 31);
        }

    }

    private  List<Move> generateMoves(final int startPieceIdx, final int endPieceIdx) {
        List<Move> moveList = new ArrayList<>();
        for (int pieceIdxdx=startPieceIdx; pieceIdxdx <= endPieceIdx; pieceIdxdx++) {
            ChessPiece chessPiece = pieces[pieceIdxdx];
            moveList.addAll(chessPiece.generateMoves());
        }
        return moveList;
    }

    @SafeVarargs
    public static void myVars(int... x) {

    }

    public Position getPosByPieceId( final ChessPieceId id) {
        return getPieceById(id).getPos();
    }

    public ChessPiece getPieceById(final ChessPieceId id) {
        return pieces[id.ordinal()];
    }

    public ChessPiece getPieceByPos(final Position pos) {
        return fields[pos.getCol()][pos.getRow()].getPiece();
    }

    public String printBoard() {
        return "";
    }
}
