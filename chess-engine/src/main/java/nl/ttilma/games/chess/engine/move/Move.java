package nl.ttilma.games.chess.engine.move;

import nl.ttilma.games.chess.engine.behavior.ChessBehavior;
import nl.ttilma.games.chess.engine.board.Position;
import nl.ttilma.games.chess.engine.piece.ChessPiece;

public class Move {
    private byte piece;
    private byte fromField;
    private byte toField;
    private byte takenPiece=0;


    public Move(byte piece, byte fromField, byte toField, byte takenPiece) {
        this.piece = piece;
        this.fromField = fromField;
        this.toField = toField;
        this.takenPiece = takenPiece;
    }

    public Move(Position e1, Position c1) {
    }

    public Move(Position fromPos, Position toPos, ChessPiece capturedPiece) {
    }

    public Move(Position fromPos, Position toPos, ChessPiece capturedPiece, ChessBehavior Behavior) {
    }

    public byte getPiece() {
        return piece;
    }

    public void setPiece(byte piece) {
        this.piece = piece;
    }

    public byte getFromField() {
        return fromField;
    }

    public void setFromField(byte fromField) {
        this.fromField = fromField;
    }

    public byte getToField() {
        return toField;
    }

    public void setToField(byte toField) {
        this.toField = toField;
    }

    public byte getTakenPiece() {
        return takenPiece;
    }

    public void setTakenPiece(byte takenPiece) {
        this.takenPiece = takenPiece;
    }}
