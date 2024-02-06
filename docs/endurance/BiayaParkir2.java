import java.util.Scanner;

public class BiayaParkir2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tarifMobil = {2000, 1000}; // [tarifSatuJamPertama, tarifSatuJamBerikutnya]
        int[] tarifMotor = {1000, 500};  // [tarifSatuJamPertama, tarifSatuJamBerikutnya]

        int jenisKendaraan = scanner.nextInt();
        int lamaParkir = scanner.nextInt();

        int totalBiaya = hitungBiayaParkir(jenisKendaraan, lamaParkir, tarifMobil, tarifMotor);

        System.out.println(totalBiaya);

        scanner.close();
    }

    public static int hitungBiayaParkir(int jenisKendaraan, int lamaParkir, int[] tarifMobil, int[] tarifMotor) {
        int[] tarifKendaraan = (jenisKendaraan == 1) ? tarifMobil : (jenisKendaraan == 2) ? tarifMotor : null;

        if (tarifKendaraan == null) {
            System.out.println("Jenis kendaraan tidak valid");
            return 0;
        }

        int tarifSatuJamPertama = tarifKendaraan[0];
        int tarifSatuJamBerikutnya = tarifKendaraan[1];

        // Hitung total biaya parkir
        int totalBiaya = tarifSatuJamPertama + (lamaParkir - 1) * tarifSatuJamBerikutnya;

        return totalBiaya;
    }
}
