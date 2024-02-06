import java.util.Scanner;

public class MesinATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jumlahUang = scanner.nextInt();
        double saldoRekening = scanner.nextDouble();

        double biayaTransaksi = 0.5;
        double totalBiaya = jumlahUang + biayaTransaksi;

        if (jumlahUang % 5 == 0 && totalBiaya <= saldoRekening) {
            saldoRekening -= totalBiaya;
        }
        System.out.printf("%.2f\n", saldoRekening);

        scanner.close();
    }
}
