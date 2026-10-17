package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private final ArrayList<Character> characterList;

    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.3");

        this.characterList = characterList;

        initComponents();

        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        mainPanel = new JPanel();

        // Menyusun komponen secara vertikal
        mainPanel.setLayout(
            new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
        );

        // Judul beserta jumlah karakter
        JLabel titleLabel = new JLabel(
            "=== Daftar Karakter (" + characterList.size() + ") ==="
        );
        mainPanel.add(titleLabel);

        // Menghitung total level dan menampilkan data karakter
        int totalLevel = 0;

        for (Character c : characterList) {
            String info = c.getName() + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

            JLabel characterLabel = new JLabel(info);
            mainPanel.add(characterLabel);

            totalLevel += c.getLevel();
        }

        // Menghitung rata-rata level
        double rataRataLevel = 0.0;

        if (!characterList.isEmpty()) {
            rataRataLevel =
                (double) totalLevel / characterList.size();
        }

        // Label statistik di bawah daftar karakter
        JLabel statistikLabel = new JLabel(
            String.format(
                java.util.Locale.US,
                "Rata-rata Level: %.2f",
                rataRataLevel
            )
        );

        mainPanel.add(statistikLabel);

        // Memasukkan panel ke jendela
        add(mainPanel);
    }
}