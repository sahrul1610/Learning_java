import java.util.Scanner;

public class HitungTotalHarga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membaca harga barang dan jumlah barang
        double hargaBarang = scanner.nextDouble();
        int jumlahBarang = scanner.nextInt();

        // Menghitung total harga barang dengan potongan
        double totalHarga = hitungTotalHarga(hargaBarang, jumlahBarang);

        // Menampilkan hasil
        System.out.printf("%.2f\n", totalHarga);

        scanner.close();
    }

    public static double hitungTotalHarga(double hargaBarang, int jumlahBarang) {
        // Menghitung total harga sebelum potongan
        double totalHargaSebelumPotongan = hargaBarang * jumlahBarang;

        // Mengecek apakah jumlah barang adalah kelipatan 3 dan 4
        if (jumlahBarang % 3 == 0 && jumlahBarang % 4 == 0) {
            // Menghitung potongan sebesar 15%
            double potongan = 0.15 * totalHargaSebelumPotongan;

            // Menghitung total harga setelah potongan
            return totalHargaSebelumPotongan - potongan;
        } else {
            // Jika tidak ada potongan, mengembalikan total harga sebelum potongan
            return totalHargaSebelumPotongan;
        }
    }
}
