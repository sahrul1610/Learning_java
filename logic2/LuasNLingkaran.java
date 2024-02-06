import java.util.Scanner;

public class LuasNLingkaran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double jariJari = scanner.nextDouble();
        int jumlahLingkaran = scanner.nextInt();

        double totalLuas = hitungLuasNLingkaran(jariJari, jumlahLingkaran);

        System.out.printf("%.2f%n", totalLuas);

        scanner.close();
    }

    public static double hitungLuasNLingkaran(double jariJari, int jumlahLingkaran) {
        double luasSatuan = 3.14 * jariJari * jariJari;
        return luasSatuan * jumlahLingkaran;
    }
}
