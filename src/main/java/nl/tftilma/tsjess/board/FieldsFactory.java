package nl.tftilma.tsjess.board;

import nl.tftilma.game.board.Field;

import static nl.tftilma.game.board.Field.*;
import static nl.tftilma.tsjess.board.Position.*;

public class FieldsFactory {
    private FieldsFactory() {
        // singleton design pattern
    }
    
    public static void create(final Field[][] fields) {
        A1 = fields[COL_A][ROW_1];
        A2 = fields[COL_A][ROW_2];
        A3 = fields[COL_A][ROW_3];
        A4 = fields[COL_A][ROW_4];
        A5 = fields[COL_A][ROW_5];
        A6 = fields[COL_A][ROW_6];
        A7 = fields[COL_A][ROW_7];
        A8 = fields[COL_A][ROW_8];

        B1 = fields[COL_B][ROW_1];
        B2 = fields[COL_B][ROW_2];
        B3 = fields[COL_B][ROW_3];
        B4 = fields[COL_B][ROW_4];
        B5 = fields[COL_B][ROW_5];
        B6 = fields[COL_B][ROW_6];
        B7 = fields[COL_B][ROW_7];
        B8 = fields[COL_B][ROW_8];

        C1 = fields[COL_C][ROW_1];
        C2 = fields[COL_C][ROW_2];
        C3 = fields[COL_C][ROW_3];
        C4 = fields[COL_C][ROW_4];
        C5 = fields[COL_C][ROW_5];
        C6 = fields[COL_C][ROW_6];
        C7 = fields[COL_C][ROW_7];
        C8 = fields[COL_C][ROW_8];

        D1 = fields[COL_D][ROW_1];
        D2 = fields[COL_D][ROW_2];
        D3 = fields[COL_D][ROW_3];
        D4 = fields[COL_D][ROW_4];
        D5 = fields[COL_D][ROW_5];
        D6 = fields[COL_D][ROW_6];
        D7 = fields[COL_D][ROW_7];
        D8 = fields[COL_D][ROW_8];

        E1 = fields[COL_E][ROW_1];
        E2 = fields[COL_E][ROW_2];
        E3 = fields[COL_E][ROW_3];
        E4 = fields[COL_E][ROW_4];
        E5 = fields[COL_E][ROW_5];
        E6 = fields[COL_E][ROW_6];
        E7 = fields[COL_E][ROW_7];
        E8 = fields[COL_E][ROW_8];

        F1 = fields[COL_F][ROW_1];
        F2 = fields[COL_F][ROW_2];
        F3 = fields[COL_F][ROW_3];
        F4 = fields[COL_F][ROW_4];
        F5 = fields[COL_F][ROW_5];
        F6 = fields[COL_F][ROW_6];
        F7 = fields[COL_F][ROW_7];
        F8 = fields[COL_F][ROW_8];

        G1 = fields[COL_G][ROW_1];
        G2 = fields[COL_G][ROW_2];
        G3 = fields[COL_G][ROW_3];
        G4 = fields[COL_G][ROW_4];
        G5 = fields[COL_G][ROW_5];
        G6 = fields[COL_G][ROW_6];
        G7 = fields[COL_G][ROW_7];
        G8 = fields[COL_G][ROW_8];

        H1 = fields[COL_H][ROW_1];
        H2 = fields[COL_H][ROW_2];
        H3 = fields[COL_H][ROW_3];
        H4 = fields[COL_H][ROW_4];
        H5 = fields[COL_H][ROW_5];
        H6 = fields[COL_H][ROW_6];
        H7 = fields[COL_H][ROW_7];
        H8 = fields[COL_H][ROW_8];
   }
}
