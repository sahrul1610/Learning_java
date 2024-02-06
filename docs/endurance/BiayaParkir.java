import java.util.Scanner;

public class BiayaParkir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tarifAwal = {0, 2000, 1000}; // Indeks 0 tidak digunakan
        int[] tarifBerikutnya = {0, 1000, 500}; // Indeks 0 tidak digunakan

        int jenisKendaraan = scanner.nextInt();
        int lamaParkir = scanner.nextInt();

        int biayaParkir = hitungBiayaParkir(jenisKendaraan, lamaParkir, tarifAwal, tarifBerikutnya);

        System.out.println(biayaParkir);

        scanner.close();
    }

    public static int hitungBiayaParkir(int jenisKendaraan, int lamaParkir, int[] tarifAwal, int[] tarifBerikutnya) {
        if (jenisKendaraan < 1 || jenisKendaraan >= tarifAwal.length) {
            return 0; // Jenis kendaraan tidak valid
        }

        int totalBiayaParkir = tarifAwal[jenisKendaraan] + (lamaParkir - 1) * tarifBerikutnya[jenisKendaraan];

        return totalBiayaParkir;
    }
}
