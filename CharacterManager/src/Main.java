import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Variasi role minimal 8 karakter dengan tambahan HEALER & MARLIN sudah terpenuhi
        manager.addCharacter(new Character("Arjuna",    CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin",    CharacterType.MAGE,    3));
        manager.addCharacter(new Character("Athena",    CharacterType.ARCHER,  4));
        manager.addCharacter(new Character("Gatotkaca", CharacterType.WARRIOR, 7));
        manager.addCharacter(new Character("Morgana",   CharacterType.MAGE,    1));
        manager.addCharacter(new Character("Artemis",   CharacterType.ARCHER,  6));
        manager.addCharacter(new Character("Bima",      CharacterType.HEALER,  8)); // Role Healer
        manager.addCharacter(new Character("Circe",     CharacterType.MARLIN,  2)); // Role Marlin

        SwingUtilities.invokeLater(() -> {
    // Ubah baris ini agar melempar objek manager, bukan manager.getAllCharacters()
    MainWindow window = new MainWindow(manager); 
    window.setVisible(true);
        });

    }
}