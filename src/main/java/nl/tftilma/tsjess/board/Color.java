package nl.tftilma.tsjess.board;

public enum Color {
    WHITE(0), BLACK(1);
    final int color;

    Color(final int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
