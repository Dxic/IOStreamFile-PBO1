// Nama: Dicky Nugraha Febriano
// NPM : 2410010146
package tugas;

public class MainTugas {
    public static void main(String[] args) {
        String[] kategori = {"Makanan", "Minuman", "Peralatan"};

        System.out.println("== Kategori Barang ==");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }

        System.out.println();

        Gudang gudang = new Gudang("barang.txt");
        gudang.tambahBarang(new Barang("Beras 5 Kg", 75000, 10));
        gudang.tambahBarang(new Barang("Gula Pasir 1 Kg", 17000, 20));
        gudang.tambahBarang(new Barang("Minyak Goreng 1 Liter", 18500, 15));
        gudang.tambahBarang(new Barang("Kopi Sachet", 1500, 50));
        gudang.tambahBarang(new Barang("Sabun Mandi", 5000, 25));

        gudang.tampilkanSemua();
        gudang.simpanKeBerkas();

        System.out.println();
        System.out.println("== Data Setelah Dimuat dari Berkas ==");

        Gudang gudangBaru = new Gudang("barang.txt");
        gudangBaru.muatDariBerkas();
        gudangBaru.tampilkanSemua();

        System.out.println("Total nilai persediaan: Rp" + gudangBaru.totalNilai());
    }
}
