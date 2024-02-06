import java.util.Scanner;

public class DetikConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input detik
        int detik = scanner.nextInt();

        // Konversi dan tampilkan hasil
        convertAndPrint(detik);

        scanner.close();
    }

    // Fungsi untuk mengkonversi detik dan menampilkan hasil
    private static void convertAndPrint(int seconds) {
        int hari = seconds / 86400;
        int sisaDetik1 = seconds % 86400;
        int jam = sisaDetik1 / 3600;
        int sisaDetik2 = sisaDetik1 % 3600;
        int menit = sisaDetik2 / 60;
        int detik = sisaDetik2 % 60;

        // Menampilkan hasil
        System.out.println(hari);
        System.out.println(jam);
        System.out.println(menit);
        System.out.println(detik);
    }
}
