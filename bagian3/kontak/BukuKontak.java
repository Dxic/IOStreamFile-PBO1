package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    // ArrayList yang menampung objek Kontak
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambah kontak
    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    // Menampilkan semua kontak
    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");

        if (daftar.isEmpty()) {
            System.out.println("Belum ada kontak.");
            return;
        }

        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    // Menyimpan kontak ke berkas
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // Memuat kontak dari berkas
    public void muatDariBerkas() {
        daftar.clear();

        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;

            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");

                // Setelah ditambah email, format data menjadi 3 bagian
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }

            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }

    // Latihan mandiri no. 1: mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        for (Kontak k : daftar) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan: " + k.info());
                return;
            }
        }

        System.out.println("Kontak " + nama + " tidak ditemukan.");
    }

    // Latihan mandiri no. 3: menghapus kontak berdasarkan nama
    public void hapusKontak(String nama) {
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);

            if (k.getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                System.out.println("Kontak " + nama + " berhasil dihapus.");

                // Setelah dihapus, simpan lagi agar perubahan masuk ke file
                simpanKeBerkas();
                return;
            }
        }

        System.out.println("Kontak " + nama + " tidak ditemukan, jadi tidak ada yang dihapus.");
    }
}
