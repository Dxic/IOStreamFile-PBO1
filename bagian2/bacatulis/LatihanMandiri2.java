package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiri2 {
    public static void main(String[] args) {
        // 1. Tulis 5 nama hari ke hari.txt
        String[] limaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};

        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            for (String hari : limaHari) {
                penulis.println(hari);
            }
            System.out.println("5 nama hari berhasil ditulis ke hari.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis hari.txt: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Isi hari.txt setelah ditulis:");

        // Baca kembali isi hari.txt
        bacaDanTampilkanHari();

        System.out.println();

        // 2. Append 2 nama hari lagi tanpa menghapus isi sebelumnya
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("2 nama hari berhasil ditambahkan.");
        } catch (IOException e) {
            System.out.println("Gagal menambah hari.txt: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Isi hari.txt setelah append:");
        bacaDanTampilkanHari();

        System.out.println();

        // 3. Hitung jumlah baris dalam hari.txt
        int jumlahBaris = hitungJumlahBaris();
        System.out.println("Jumlah baris dalam hari.txt: " + jumlahBaris);
    }

    private static void bacaDanTampilkanHari() {
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            int nomor = 1;

            while ((baris = pembaca.readLine()) != null) {
                System.out.println(nomor + ". " + baris);
                nomor++;
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca hari.txt: " + e.getMessage());
        }
    }

    private static int hitungJumlahBaris() {
        int jumlah = 0;

        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            while (pembaca.readLine() != null) {
                jumlah++;
            }
        } catch (IOException e) {
            System.out.println("Gagal menghitung baris: " + e.getMessage());
        }

        return jumlah;
    }
}
