package nl.tftilma.tsjess.piece;

import nl.tftilma.tsjess.Move;

import java.util.ArrayList;
import java.util.List;


class KingBehaviour extends Behaviour {
    KingBehaviour(final King king) {
        super(king);
    }

    List<Move> generate(Move prevMove) {
        List<Move> list = new ArrayList<>();
        return list;
    }
}
