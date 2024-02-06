import java.util.Scanner;

public class VolumeTabung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double jariJari = scanner.nextDouble();
        double tinggi = scanner.nextDouble();

        // Menghitung volume tabung
        double volume = 3.14 * jariJari * jariJari * tinggi;

        // Menampilkan volume tabung dengan dua angka di belakang koma
        System.out.printf("%.2f\n", volume);

        scanner.close();
    }
}
