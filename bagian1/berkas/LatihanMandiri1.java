package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri1 {
    public static void main(String[] args) {
        // 1. Cek laporan.txt dan tampilkan ukurannya jika ada
        File laporan = new File("laporan.txt");
        if (laporan.exists()) {
            System.out.println("laporan.txt ada.");
            System.out.println("Ukuran laporan.txt: " + laporan.length() + " byte");
        } else {
            System.out.println("laporan.txt belum ada.");
        }

        System.out.println();

        // 2. Buat folder arsip menggunakan mkdir()
        File folderArsip = new File("arsip");
        if (folderArsip.mkdir()) {
            System.out.println("Folder arsip berhasil dibuat.");
        } else {
            System.out.println("Folder arsip gagal dibuat atau sudah ada.");
        }

        System.out.println();

        // 3. Buat sementara.txt, cek, hapus, lalu cek lagi
        File sementara = new File("sementara.txt");
        try {
            sementara.createNewFile();
            System.out.println("Sebelum dihapus, sementara.txt ada? " + sementara.exists());

            if (sementara.delete()) {
                System.out.println("sementara.txt berhasil dihapus.");
            } else {
                System.out.println("sementara.txt gagal dihapus.");
            }

            System.out.println("Sesudah dihapus, sementara.txt ada? " + sementara.exists());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
