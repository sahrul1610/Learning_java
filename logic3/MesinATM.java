import java.util.Scanner;

public class MesinATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jumlahUang = scanner.nextInt();
        double saldoRekening = scanner.nextDouble();

        // Menghitung saldo setelah transaksi
        double biayaTransaksi = 0.5;
        double totalBiaya = jumlahUang + biayaTransaksi;

        // Mengecek apakah saldo mencukupi dan jumlah uang adalah kelipatan 5
        if (jumlahUang % 5 == 0 && totalBiaya <= saldoRekening) {
            saldoRekening -= totalBiaya;
        }

        // Menampilkan saldo rekening setelah transaksi
        System.out.printf("%.2f\n", saldoRekening);

        scanner.close();
    }
}
