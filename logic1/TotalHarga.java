package logic1;
import java.util.Scanner;

public class TotalHarga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double hargaBarang = scanner.nextDouble();
        int jumlahBarang = scanner.nextInt();

        double totalHarga = 0;

        if (jumlahBarang % 3 == 0 && jumlahBarang % 4 == 0) {
        
            double potongan = 0.15 * hargaBarang * jumlahBarang;
            totalHarga = (hargaBarang * jumlahBarang) - potongan;
        } else {
        
            totalHarga = hargaBarang * jumlahBarang;
        }

        
        System.out.printf("%.2f\n", totalHarga);
    }
}
