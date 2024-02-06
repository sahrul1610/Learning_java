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

        double luasSatuLingkaran = 3.14 * Math.pow(jariJari, 2);
        double totalLuas = luasSatuLingkaran * jumlahLingkaran;

        return totalLuas;
    }
}
