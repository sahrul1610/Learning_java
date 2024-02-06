import java.util.Scanner;

public class BiayaParkir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jenisKendaraan = scanner.nextInt();

        int lamaParkir = scanner.nextInt();

        int biayaParkir = hitungBiayaParkir(jenisKendaraan, lamaParkir);

        System.out.println(biayaParkir);

        scanner.close();
    }

    public static int hitungBiayaParkir(int jenisKendaraan, int lamaParkir) {
        int biayaPertama, biayaBerikutnya, biayaTotal;

        if (jenisKendaraan == 1) {
            // Mobil
            biayaPertama = 2000;
            biayaBerikutnya = 1000;
        } else if (jenisKendaraan == 2) {
            // Motor
            biayaPertama = 1000;
            biayaBerikutnya = 500;
        } else {
            return 0;
        }

        if (lamaParkir > 1) {
            biayaTotal = biayaPertama + biayaBerikutnya * (lamaParkir - 1);
        } else {
            biayaTotal = biayaPertama;
        }

        return biayaTotal;
    }
}
