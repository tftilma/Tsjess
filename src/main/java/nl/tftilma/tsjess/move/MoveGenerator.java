package nl.tftilma.tsjess.move;

import nl.tftilma.tsjess.board.ChessBoard;
import nl.tftilma.tsjess.board.Color;

import java.util.List;

import static nl.tftilma.tsjess.piece.PieceIndex.*;

public class MoveGenerator {
    public List<Move> generate(final ChessBoard board) {
        return board.isWhiteToMove() ?
            generate(Color.WHITE, board) :
            generate(Color.BLACK, board);
    }

    public List<Move> generate(final Color color, final ChessBoard board) {
        List<Move> moveList = board.generate(color, QQ);
        moveList.addAll(board.generate(color, KN));
        moveList.addAll(board.generate(color, QN));
        moveList.addAll(board.generate(color, KB));
        moveList.addAll(board.generate(color, QB));
        moveList.addAll(board.generate(color, KR));
        moveList.addAll(board.generate(color, QR));
        moveList.addAll(board.generate(color, KK));

        moveList.addAll(board.generate(color, EP));
        moveList.addAll(board.generate(color, DP));
        moveList.addAll(board.generate(color, CP));
        moveList.addAll(board.generate(color, HP));
        moveList.addAll(board.generate(color, BP));
        moveList.addAll(board.generate(color, AP));
        moveList.addAll(board.generate(color, GP));
        moveList.addAll(board.generate(color, FP));
        return moveList;
    }
}
