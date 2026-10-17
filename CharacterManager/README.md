# AP3 - Character Manager (Java Visual SIH-6406)
Aplikasi ini adalah sistem manajemen karakter sederhana berbasis teks (Console-based Game Character Manager) yang dibangun menggunakan bahasa pemrograman Java. Proyek ini menerapkan prinsip Pemrograman Berorientasi Objek (OOP), khususnya enkapsulasi (Encapsulation) dengan pembatasan hak akses atribut menggunakan setter, getter, serta fungsi validasi nilai logika. Sistem juga mendukung kalkulasi otomatis status karakter (HP dan Attack) berdasarkan level serta fitur pelacakan kondisi hidup/mati karakter.

## Screenshot Output Terminal ap3

<img width="1920" height="1080" alt="Screenshot (1)" src="https://github.com/user-attachments/assets/17348968-7858-40f5-a6f7-98fc9d8e6336" />
<img width="1920" height="1080" alt="Screenshot (7)" src="https://github.com/user-attachments/assets/7c0622a1-6f65-4573-ba5a-394f1eac9821" />

## Struktur Folder Project

```text
CharacterManager/
├── src/
│   ├── Main.java
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               ├── model/
│               │   ├── Character.java
│               │   └── CharacterType.java
│               │   └── CharacterManager.java
│               └── view/
│                   └── MainWindow.java
└── README.md
```

# AP6 - Fitur Baru: Pencarian Karakter Terkuat (`findStrongest`)

## 1. Rasional / Alasan Fitur
Dalam pengembangan sebuah game atau sistem RPG, mengetahui entitas atau karakter mana yang memiliki statistik tertinggi (terkuat) merupakan fitur analisis data yang sangat krusial. Fitur `findStrongest()` ditambahkan untuk mempermudah sistem dalam menyaring karakter dengan daya serang (`attackPower`) paling mendominasi tanpa mengharuskan layer aplikasi melakukan pengurutan (*sorting*) manual di sisi luar.

## 2. Menjaga Prinsip OOP & Enkapsulasi
* **Defensive Design:** Method mengembalikan satu objek `Character` tunggal atau nilai `null` apabila sistem belum memiliki data karakter sama sekali.
* **No Information Leakage:** Struktur data internal `ArrayList<Character> characterList` milik `CharacterManager` tetap terkunci rapat di dalam class (private). Akses luar murni hanya mendapatkan hasil kalkulasi/pencarian objek spesifik tanpa diberi celah untuk memodifikasi atau menambah isi list secara ilegal.

## Screenshot Output Terminal ap6

<img width="1920" height="1080" alt="Screenshot (21)" src="https://github.com/user-attachments/assets/03bb0004-9942-422a-82c9-0d9b48cf2a9d" />
<img width="1920" height="1080" alt="Screenshot (22)" src="https://github.com/user-attachments/assets/768bd7cc-9e78-4afe-8e3f-75dcae30c42a" />
<img width="1920" height="1080" alt="Screenshot (23)" src="https://github.com/user-attachments/assets/f8d8defa-482c-445e-805b-997ead1bb2c4" />
<img width="1920" height="1080" alt="Screenshot (24)" src="https://github.com/user-attachments/assets/7790e8a7-625f-4afe-8dfd-62552c826ee5" />

# AP10 — Character Manager GUI dan Statistik Karakter

## 1. Aliran Data dan Penerapan MVC
Aliran data aplikasi dimulai dari Main.java, yang membuat objek Character dan menambahkan data karakter ke CharacterManager. Selanjutnya, Main.java mengambil daftar karakter melalui method getAllCharacters() dan mengirimkannya ke MainWindow untuk ditampilkan dalam antarmuka Java Swing. Dalam konsep MVC, package model bertanggung jawab terhadap data dan logika karakter, sedangkan MainWindow berperan sebagai bagian View yang menampilkan data kepada pengguna. Main.java mengatur proses inisialisasi dan menghubungkan Model dengan View, sementara statistik rata-rata level dihitung berdasarkan daftar karakter yang diterima oleh View.

## 2. Karakter Baru dan Alasan Pemilihan Tipe/Level
Dua karakter baru ditambahkan untuk memenuhi kebutuhan minimal lima karakter sekaligus memberikan variasi tipe dan level pada aplikasi.
Srikandi — ARCHER, Level 2: Dipilih sebagai karakter pemanah dengan level awal yang relatif rendah untuk menunjukkan variasi statistik pada karakter yang masih berkembang.
Bima — WARRIOR, Level 6: Dipilih sebagai karakter petarung dengan level lebih tinggi untuk memberikan perbandingan statistik dengan karakter berlevel rendah serta membantu menguji perhitungan rata-rata level.
Penambahan karakter dengan tipe dan level yang berbeda memungkinkan aplikasi menampilkan data yang lebih bervariasi dan menguji apakah statistik rata-rata level dihitung berdasarkan seluruh karakter secara akurat.

## Screenshot Output Terminal ap10
<img width="1920" height="1080" alt="Screenshot (26)" src="https://github.com/user-attachments/assets/17fc7a36-78c5-48e1-9343-51b12cfc5588" />
<img width="1920" height="1080" alt="Screenshot (27)" src="https://github.com/user-attachments/assets/d4e1cf2b-2ccb-4387-b423-9f9d92102f84" />
<img width="1920" height="1080" alt="Screenshot (29)" src="https://github.com/user-attachments/assets/e40eb7bb-e1ec-4036-97d0-5d2381ca33ce" />

## Identitas Mahasiswa

* Nama Lengkap: Yugas Bintang Bimantara harefa
* NIM: 253303621229
* Link Google Docs ap3: https://docs.google.com/document/d/13VmEHhD6g9jfoNQVd79ebY7AujzoQrAAqYsLhu1JZDE/edit?usp=sharing
* Link Google Docs ap6: https://docs.google.com/document/d/1-aIZ3DACbzdOY9E0Q-ihezBbM8uxdzWK4TRoRQpNqqI/edit?usp=sharing
* Link Google Docs ap10: https://docs.google.com/document/d/1vV4PF-lDXRdZbCN6OllHVbcmdEmTuXkokU2j73zBoT0/edit?usp=sharing
