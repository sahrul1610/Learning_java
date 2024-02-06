import java.util.Scanner;

public class CekTangkiBensin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int uang = scanner.nextInt();
        double kapasitasTangki = scanner.nextDouble();

        double jumlahBensin = hitungJumlahBensin(uang);
        System.out.printf("%.2f%n", jumlahBensin);

        if (jumlahBensin > kapasitasTangki) {
            System.out.println("Bensin Berlebih");
        }

        scanner.close();
    }

    public static double hitungJumlahBensin(int uang) {
        final double HARGA_BENSIN = 7600;
        return uang / HARGA_BENSIN;
    }
}
