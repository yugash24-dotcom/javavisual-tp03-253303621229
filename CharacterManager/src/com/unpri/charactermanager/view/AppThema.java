package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * Pusat gaya tampilan Character Manager.
 */
public final class AppThema {

    // ---------- Konstanta Mini-Challenge ----------
    public static final int HIGH_LEVEL_THRESHOLD = 5; // Batas level tinggi

    // ---------- Palet warna ----------
    public static final Color BG_MAIN    = Color.decode("#13131f");
    public static final Color TEXT_MAIN  = Color.decode("#dfe6e9");
    public static final Color TEXT_LIGHT = Color.WHITE;
    public static final Color GOLD       = Color.decode("#fdcb6e"); // Warna emas teks level >= 5

    // ---------- Font ----------
    public static final Font FONT_TITLE     = new Font("SansSerif", Font.BOLD, 22);
    public static final Font FONT_BODY      = new Font("SansSerif", Font.PLAIN, 14);
    public static final Font FONT_BODY_BOLD = new Font("SansSerif", Font.BOLD, 14); // Font tebal level >= 5
    public static final Font FONT_MONO      = new Font("Monospaced", Font.PLAIN, 13);

    // ---------- Border ----------
    public static final Border CARD_BORDER = BorderFactory.createEmptyBorder(8, 12, 8, 12);

    private AppThema() { }

    public static Color colorFor(CharacterType type) {
        return switch (type) {
            case WARRIOR -> Color.decode("#d63031");
            case MAGE    -> Color.decode("#0984e3");
            case ARCHER  -> Color.decode("#00b894");
            default      -> Color.GRAY;
        };
    }

    public static String describe(CharacterType type) {
        return switch (type) {
            case WARRIOR -> "Warrior: jarak dekat, HP tinggi";
            case MAGE    -> "Mage: serangan sihir, HP rendah";
            case ARCHER  -> "Archer: jarak jauh, seimbang";
            default      -> "Role belum terdaftar";
        };
    }
}