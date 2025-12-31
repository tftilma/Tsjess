package nl.tftilma.tsjess.piece;

public enum PieceIndex {
    QR(0), QN(1), QB(2), QQ(3), KK(4), KB(5), KN(6), KR(7),
    AP(8), BP(9), CP(10), DP(11), EP(12), FP(13), GP(14), HP(15);

    private int idx;
    PieceIndex(final int idx) {
        this.idx = idx;
    }
}
