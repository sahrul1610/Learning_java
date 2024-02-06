import java.util.Scanner;

public class SistemKeamananPTNurCahaya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputKalimat = scanner.nextLine();
        String kalimatTanpaSpasi = hapusSpasi(inputKalimat);
        boolean isPalindrom = isPalindrom(kalimatTanpaSpasi);
        int jumlahHuruf = hitungJumlahHuruf(kalimatTanpaSpasi);

        System.out.println(kalimatTanpaSpasi);
        System.out.println(isPalindrom);
        System.out.println(jumlahHuruf);
        System.out.println(isPalindrom ? "Silahkan Masuk" : "Akses Ditolak");

        scanner.close();
    }

    public static String hapusSpasi(String kalimat) {
        return kalimat.replaceAll(" ", "");
    }

    public static boolean isPalindrom(String kalimat) {
        int panjang = kalimat.length();
        for (int i = 0; i < panjang / 2; i++) {
            if (kalimat.charAt(i) != kalimat.charAt(panjang - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int hitungJumlahHuruf(String kalimat) {
        return kalimat.length();
    }
}
