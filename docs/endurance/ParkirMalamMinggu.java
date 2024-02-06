import java.util.Scanner;

public class ParkirMalamMinggu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jenisKendaraan = scanner.nextInt();
        int lamaParkir = scanner.nextInt();

        int biayaParkir = hitungBiayaParkir(jenisKendaraan, lamaParkir);

        if (biayaParkir > 0) {
            System.out.println(biayaParkir);
        } else {
            System.out.println("disegel");
        }

        scanner.close();
    }

    public static int hitungBiayaParkir(int jenisKendaraan, int lamaParkir) {
        int biayaPerJam;

        if (jenisKendaraan == 1) {
            biayaPerJam = 1500;
        } else {
            biayaPerJam = 1000;
        }

        int biayaTotal = lamaParkir * biayaPerJam;

        if (lamaParkir > 5) {
            biayaTotal += (lamaParkir - 5) * 500;
        }

        if (lamaParkir > 8) {
            return -1; 
        }

        return biayaTotal;
    }
}
