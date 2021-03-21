package nl.ttilma.games.chess.engine.piece;

import static nl.ttilma.games.chess.engine.piece.Color.BLACK;
import static nl.ttilma.games.chess.engine.piece.Color.WHITE;

public enum ChessPieceId {
    WQR(WHITE), WQN(WHITE), WQB(WHITE), WQQ(WHITE), WKK(WHITE), WKB(WHITE), WKN(WHITE), WKR(WHITE),
    WAX(WHITE), WBX(WHITE), WCX(WHITE), WDX(WHITE), WEX(WHITE), WFX(WHITE), WGX(WHITE), WHX(WHITE),
    BAX(BLACK), BBX(BLACK), BCX(BLACK), BDX(BLACK), BEX(BLACK), BFX(BLACK), BGX(BLACK), BHX(BLACK),
    BQR(BLACK), BQN(BLACK), BQB(BLACK), BQQ(BLACK), BKK(BLACK), BKB(BLACK), BKN(BLACK), BKR(BLACK);

    /**
     * private cache of all values
     */
    private static final ChessPieceId[] CHESS_PIECE_IDS = ChessPieceId.values();

    private final Color color;

    private ChessPieceId(final Color color) {
        this.color = color;
    }

    public static ChessPieceId of(int pieceId) {
        return CHESS_PIECE_IDS[pieceId];
    }

    public Color getColor() {
        return color;
    }

    public int getPieceIdx() {
        return this.ordinal();
    }
}
