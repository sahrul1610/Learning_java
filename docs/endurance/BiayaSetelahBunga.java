import java.util.Scanner;

public class BiayaSetelahBunga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double biayaAwal = scanner.nextDouble();
        double persenBunga = scanner.nextDouble();
        double totalBiaya = biayaAwal + (biayaAwal * (persenBunga / 100));
        System.out.printf("%.2f%n", totalBiaya);

        scanner.close();
    }
}
