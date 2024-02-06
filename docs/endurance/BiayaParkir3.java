import java.util.Scanner;

public class BiayaParkir3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] tarifBiaya = {
                {5000, 2000, 25000},  // Mobil
                {2000, 1000, 10000},  // Motor
                {10000, 5000, 50000}  // Box
        };

        int kategori = scanner.nextInt();

        int lamaParkir = scanner.nextInt();

        int totalBiaya = hitungBiayaParkir(tarifBiaya[kategori - 1], lamaParkir);

        System.out.println(totalBiaya);

        scanner.close();
    }

    private static int hitungBiayaParkir(int[] tarif, int lamaParkir) {
        int totalBiaya = tarif[0] + (lamaParkir - 1) * tarif[1];

        return Math.min(totalBiaya, tarif[2]);
    }
}
