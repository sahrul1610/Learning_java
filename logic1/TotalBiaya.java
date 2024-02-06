package logic1;
import java.util.Scanner;

public class TotalBiaya {
    public static void main(String[] args) {
        // Membaca biaya awal dan persen bunga
        Scanner scanner = new Scanner(System.in);
        double biayaAwal = scanner.nextDouble();
        double persenBunga = scanner.nextDouble();

        // Menghitung total biaya setelah bunga
        double totalBiaya = biayaAwal + (biayaAwal * (persenBunga / 100));

        // Menampilkan total biaya dengan dua angka di belakang koma
        System.out.printf("%.2f\n", totalBiaya);
    }
}
