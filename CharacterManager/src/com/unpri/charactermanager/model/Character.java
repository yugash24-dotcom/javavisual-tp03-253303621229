package com.unpri.charactermanager.model;

/**
 * Merepresentasikan satu karakter dalam aplikasi Character Manager.
 * Menerapkan prinsip Encapsulation: semua atribut private,
 * akses hanya melalui getter/setter.
 */
public class Character {

    // ===== ATRIBUT (private — tidak bisa diakses langsung dari luar class) =====
    private int id;
    private final String name;
    private final CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana; // TUGAS 1: Atribut private baru bertipe int

    // ===== CONSTRUCTOR 1: untuk membuat karakter BARU =====
    // Dipakai saat user membuat karakter dari form (belum punya id dari database)
    public Character(String name, CharacterType type, int level) {
        this.name = name;              // "this" merujuk ke atribut milik object ini
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();      // HP dihitung otomatis dari level
        this.attackPower = calculateBaseAttack(); // Attack dihitung otomatis dari level
        this.mana = 0;                           // Nilai awal default untuk mana
    }

    // ===== CONSTRUCTOR 2: untuk MEMUAT karakter dari database =====
    // Dipakai saat data sudah ada (id dan statistik sudah final dari DB)
    public Character(int id, String name, CharacterType type, int level, int hitPoints, int attackPower) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;                           // Nilai awal default untuk mana
    }

    // ===== HELPER PRIVATE: hanya dipakai internal class ini =====
    private int calculateBaseHP() {
        return 100 + (level * 10);   // contoh: level 5 → HP = 150
    }

    private int calculateBaseAttack() {
        return 10 + (level * 5);     // contoh: level 5 → Attack = 35
    }

    // ===== GETTER: cara AMAN membaca nilai atribut private dari luar =====
    public int getId() { return id; }
    public String getName() { return name; }
    public CharacterType getType() { return type; }
    public int getLevel() { return level; }
    public int getHitPoints() { return hitPoints; }
    public int getAttackPower() { return attackPower; }
    
    // TUGAS 2: Getter untuk mana
    public int getMana() { 
        return mana; 
    }

    // ===== SETTER: cara AMAN mengubah atribut, dengan VALIDASI =====
    public void setId(int id) {
        this.id = id;
    }

    // TUGAS 2: Setter untuk mana dengan validasi tidak boleh negatif
    public void setMana(int mana) {
        if (mana < 0) {
            System.out.println("Error: Mana tidak boleh negatif!");
        } else {
            this.mana = mana;
        }
    }

    public void setLevel(int level) {
        if (level < 1) {                       // validasi: level tidak boleh kurang dari 1
            throw new IllegalArgumentException("Level minimal adalah 1");
        }
        this.level = level;
        this.hitPoints = calculateBaseHP();      // statistik dihitung ULANG setiap level berubah
        this.attackPower = calculateBaseAttack();
    }

    // TUGAS 3: Method isAlive() mengembalikan true jika hitPoints > 0
    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    // ===== toString(): TUGAS 4: Ditambahkan atribut mana ke dalam teks =====
    @Override
    public String toString() {
        return "Character{id=" + id +
               ", name='" + name + '\'' +
               ", type=" + type +
               ", level=" + level +
               ", hp=" + hitPoints +
               ", atk=" + attackPower +
               ", mana=" + mana + '}'; // Ditambahkan di sini
    }

    // ===== equals(): membandingkan ISI DATA, bukan alamat memori =====
    // Dua Character dianggap "sama" jika NAMA-nya identik (case-sensitive)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                    // optimasi: jika memang object yang sama persis
        if (!(obj instanceof Character)) return false;    // jika bukan Character, pasti tidak sama
        Character other = (Character) obj;                // casting aman karena sudah dicek instanceof
        return this.name.equals(other.name);               // bandingkan isi atribut name (String punya equals sendiri)
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}   // kurung kurawal penutup CLASS Character