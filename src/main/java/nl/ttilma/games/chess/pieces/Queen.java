package nl.ttilma.games.chess.pieces;

import nl.ttilma.games.chess.behavior.QueenBehavior;
import nl.ttilma.games.chess.board.ChessBoard;

public class Queen extends ChessPiece {
    public Queen(final ChessBoard chessBoard, final ChessPieceId id) {
        super(chessBoard, id, new QueenBehavior(chessBoard, id));
    }

    public static void main(String[] args) {
        System.out.println("the Queen");
    }
}
