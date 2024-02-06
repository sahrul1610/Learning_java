import java.util.Scanner;

public class MendapatDiscount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hargaBarang = scanner.nextDouble();
        int jumlahBarang = scanner.nextInt();

        double totalHarga = hitungTotalHarga(hargaBarang, jumlahBarang);

        System.out.printf("%.2f%n", totalHarga);

        scanner.close();
    }

    private static double hitungTotalHarga(double harga, int jumlah) {
        double totalHarga = harga * jumlah;

        if (jumlah % 3 == 0 && jumlah % 4 == 0) {
            totalHarga -= 0.15 * totalHarga;
        }

        return totalHarga;
    }
}
