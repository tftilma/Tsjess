package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.Move;

import java.util.ArrayList;
import java.util.List;


class KnightBehaviour extends Behaviour {
    KnightBehaviour(final ChessPiece knight) {
        super(knight);
    }

    List<Move> generate(final Move prevMove) {
        List<Move> list = new ArrayList<>();
        tryLeftForwardFoward(list);
        return list;
    }

    private void tryLeftForwardFoward(List<Move> list) {
    }
}
