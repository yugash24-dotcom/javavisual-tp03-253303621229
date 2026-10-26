package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private final ArrayList<Character> characterList;

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.4");
        this.characterList = characterList;

        initComponents();

        pack();
        setMinimumSize(new Dimension(420, 320));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        mainPanel.setBackground(AppThema.BG_MAIN);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        mainPanel.add(createTitleLabel());

        for (Character c : characterList) {
            mainPanel.add(createCharacterLabel(c));
        }

        add(mainPanel);
    }

    private JLabel createTitleLabel() {
        JLabel lbl = new JLabel("Daftar Karakter (" + characterList.size() + ")", SwingConstants.CENTER);
        lbl.setFont(AppThema.FONT_TITLE);
        lbl.setForeground(AppThema.TEXT_MAIN);
        return lbl;
    }

    private JLabel createCharacterLabel(Character c) {
        String info = c.getName() + " | " + c.getType() + " | Level " + c.getLevel();

        JLabel lbl = new JLabel(info);
        lbl.setBackground(AppThema.colorFor(c.getType()));
        lbl.setOpaque(true);
        lbl.setBorder(AppThema.CARD_BORDER);

        // --- IMPLEMENTASI MINI-CHALLENGE ---
        if (c.getLevel() >= AppThema.HIGH_LEVEL_THRESHOLD) {
            lbl.setForeground(AppThema.GOLD);           // Teks emas
            lbl.setFont(AppThema.FONT_BODY_BOLD);       // Teks tebal
        } else {
            lbl.setForeground(AppThema.TEXT_LIGHT);      // Teks putih biasa
            lbl.setFont(AppThema.FONT_BODY);            // Teks biasa
        }

        // --- FITUR TAMBAHAN 1: DISABLE LEVEL 1 ---
        if (c.getLevel() <= 1) {
            lbl.setEnabled(false); 
        } else {
            lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

        // --- FITUR TAMBAHAN 2: TOOLTIP DETAIL STATS ---
        String tooltipText = String.format("<html><b>%s</b> (%s)<br/>%s<br/>[ HP: %d | ATK: %d ]</html>",
                c.getName(), c.getType(), AppThema.describe(c.getType()), c.getHitPoints(), c.getAttackPower());
        lbl.setToolTipText(tooltipText);

        return lbl;
    }
}