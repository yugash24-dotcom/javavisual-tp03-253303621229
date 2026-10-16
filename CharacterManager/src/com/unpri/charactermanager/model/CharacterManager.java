package com.unpri.charactermanager.model;

import java.util.ArrayList;

/**
 * Mengelola koleksi Character: tambah, cari, hapus, dan statistik dasar.
 * Menerapkan Composition: CharacterManager "has-a" ArrayList<Character>.
 */
public class CharacterManager {

    private final ArrayList<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();   // list kosong saat manager pertama dibuat
    }

    /**
     * Menambahkan karakter baru ke dalam list.
     * Menolak jika sudah ada karakter dengan nama yang sama (cek via equals()).
     * @return true jika berhasil ditambahkan, false jika ditolak karena duplikat
     */
    public boolean addCharacter(Character character) {
        if (findByName(character.getName()) != null) {   // cek dulu apakah nama sudah ada
            System.out.println("❌ Gagal: karakter dengan nama '" + character.getName() + "' sudah ada!");
            return false;
        }
        characterList.add(character);
        System.out.println("✅ Karakter '" + character.getName() + "' berhasil ditambahkan.");
        return true;
    }

    /**
     * Mencari karakter berdasarkan nama.
     * @return object Character jika ditemukan, null jika tidak ada
     */
    public Character findByName(String name) {
        for (Character c : characterList) {         // iterasi setiap elemen di list
            if (c.getName().equals(name)) {          // bandingkan ISI nama, bukan ==
                return c;                             // langsung kembalikan referensi yang ditemukan
            }
        }
        return null;                                  // tidak ditemukan setelah seluruh list diperiksa
    }

    /**
     * Menghapus karakter dari list berdasarkan nama.
     * @return true jika berhasil dihapus, false jika tidak ditemukan
     */
    public boolean removeCharacter(String name) {
        Character target = findByName(name);
        if (target == null) {
            System.out.println("❌ Gagal hapus: karakter '" + name + "' tidak ditemukan.");
            return false;
        }
        characterList.remove(target);                 // ArrayList.remove(Object) memakai equals() di balik layar
        System.out.println("🗑️ Karakter '" + name + "' berhasil dihapus.");
        return true;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    /**
     * Mengembalikan SALINAN list, bukan referensi asli —
     * agar pemanggil tidak bisa mengubah data internal manager secara langsung.
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);        // defensive copy — lihat Halaman 7 untuk eksperimen
    }

    // ===== TUGAS 1: Menghitung rata-rata level =====
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0; // Menghindari ArithmeticException (pembagian dengan nol)
        }
        
        double totalLevel = 0;
        for (Character c : characterList) {
            totalLevel += c.getLevel();
        }
        
        return totalLevel / characterList.size();
    }

    // ===== TUGAS 2: Mencari karakter berdasarkan tipe =====
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> hasilFilter = new ArrayList<>();
        for (Character c : characterList) {
            if (c.getType() == type) { // Menggunakan == karena CharacterType adalah Enum
                hasilFilter.add(c);
            }
        }
        return hasilFilter;
    }
    
    /**
     * Mencari dan mengembalikan karakter dengan daya serang (attack power) tertinggi.
     * Jika terdapat lebih dari satu karakter dengan nilai attack power tertinggi yang sama,
     * method akan mengembalikan karakter yang pertama kali ditemukan di dalam list.
     *
     * @return object Character dengan attackPower terbesar, atau null jika tidak ada karakter di dalam list.
     */
    public Character findStrongest() {
        if (characterList.isEmpty()) {
            return null; // Mengantisipasi list kosong agar tidak error
        }

        Character strongest = characterList.get(0);
        for (Character c : characterList) {
            if (c.getAttackPower() > strongest.getAttackPower()) {
                strongest = c; // Update jika ditemukan karakter yang lebih kuat
            }
        }
        return strongest;
    }
}   // kurung kurawal penutup class CharacterManager