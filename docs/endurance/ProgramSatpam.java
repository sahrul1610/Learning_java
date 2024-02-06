import java.util.Scanner;

public class ProgramSatpam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nomorKasus = scanner.nextInt();
        int banyakKasus = scanner.nextInt();
        String tindakan = tentukanTindakan(nomorKasus, banyakKasus);
        System.out.println(tindakan);

        scanner.close();
    }

    public static String tentukanTindakan(int nomorKasus, int banyakKasus) {
        if (nomorKasus == 1) {
            if (banyakKasus < 4) {
                return "Serahkan KTP anda !!!";
            } else {
                return "Bayar Denda 10000 !!!";
            }
        } else if (nomorKasus == 2) {
            return "Ambil STNK dulu !!!";
        }

        return "Kasus tidak valid";
    }
}