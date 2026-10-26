import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Total 6 karakter dengan variasi level dan role
        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));   // Emas & Tebal
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));      // Normal
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));    // Normal
        manager.addCharacter(new Character("Srikandi", CharacterType.ARCHER, 2));  // Normal
        manager.addCharacter(new Character("Bima", CharacterType.WARRIOR, 6));      // Emas & Tebal
        manager.addCharacter(new Character("Gatotkaca", CharacterType.WARRIOR, 1)); // Fitur Disabled (Lv. 1)

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager.getAllCharacters());
            window.setVisible(true);
        });
    }
}