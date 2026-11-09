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
    public static final Color BG_STATUS  = Color.decode("#0d0d1a"); // latar bar status: lebih gelap
    public static final Color TEXT_MUTED = Color.decode("#9d9dbf"); // teks sekunder / metadata

    // ---------- Font ----------
    public static final Font FONT_TITLE     = new Font("SansSerif", Font.BOLD, 22);
    public static final Font FONT_BODY      = new Font("SansSerif", Font.PLAIN, 14);
    public static final Font FONT_BODY_BOLD = new Font("SansSerif", Font.BOLD, 14); // Font tebal level >= 5
    public static final Font FONT_MONO      = new Font("Monospaced", Font.PLAIN, 13);
    public static final Font FONT_LEGENDA   = new Font("SansSerif", Font.BOLD, 12);

    // ---------- Border ----------
    public static final Border CARD_BORDER = BorderFactory.createEmptyBorder(8, 12, 8, 12);

    private AppThema() { }

    public static Color colorFor(CharacterType type) {
        return switch (type) {
            case WARRIOR -> Color.decode("#d63031");
            case MAGE    -> Color.decode("#0984e3");
            case ARCHER  -> Color.decode("#00b894");
            case HEALER  -> Color.decode("#e84393");
            case MARLIN  -> Color.decode("#6c5ce7");
        };
    }

    public static String describe(CharacterType type) {
        return switch (type) {
            case WARRIOR -> "Warrior: jarak dekat, HP tinggi";
            case MAGE    -> "Mage: serangan sihir, HP rendah";
            case ARCHER  -> "Archer: jarak jauh, seimbang";
            case HEALER  -> "Healer: pemulih HP, pertahanan sedang";
            case MARLIN  -> "Marlin: role legendaris rahasia";
        };
    }
}
