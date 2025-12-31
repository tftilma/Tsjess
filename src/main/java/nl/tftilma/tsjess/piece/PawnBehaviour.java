package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.Move;

import java.util.ArrayList;
import java.util.List;


public class PawnBehaviour extends Behaviour {

    public PawnBehaviour(final Pawn pawn) {
        super(pawn);
    }

    public List<Move> generate(final Move prevMove) {
        List<Move> list = new ArrayList<>();
        if (tryOneForward(list)) {
            if (initialPosition()) {
                tryDoubleForward(list);
            }
        }
        tryCaptureLeft(list);
        tryCaptureRight(list);
        tryEnPassent(list, prevMove);
        return list;
    }

    private void tryEnPassent(List<Move> list, Move prevMove) {
    }

    private void tryCaptureRight(List<Move> list) {
    }

    private void tryCaptureLeft(List<Move> list) {
    }

    private void tryDoubleForward(List<Move> list) {

    }

    private boolean initialPosition() {
        return true;
    }

    private boolean tryOneForward(List<Move> list) {
        boolean atLastRank = true;
        if (atLastRank) {
            promote(list);
        }
        return true;
    }

    private void promote(List<Move> list) {
        promoteQueen(list);
        promoteRook(list);
        promoteKnight(list);
        promoteBishop(list);
    }

    private void promoteBishop(List<Move> list) {
    }

    private void promoteKnight(List<Move> list) {
    }

    private void promoteRook(List<Move> list) {
    }

    private void promoteQueen(List<Move> list) {
    }

}
