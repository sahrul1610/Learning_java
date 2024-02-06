import java.util.Scanner;

public class SistemKeamananPTNurCahaya {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String kalimat = scanner.nextLine();
        String kalimatTanpaSpasi = hapusSpasi(kalimat);
        boolean isPalindrom = isPalindrom(kalimatTanpaSpasi);
        int jumlahHuruf = hitungJumlahHuruf(kalimatTanpaSpasi);

        System.out.println(kalimatTanpaSpasi);
        System.out.println(isPalindrom);
        System.out.println(jumlahHuruf);

        if (isPalindrom) {
            System.out.println("Silahkan Masuk");
        } else {
            System.out.println("Akses Ditolak");
        }

        scanner.close();
    }

    private static String hapusSpasi(String kalimat) {
        return kalimat.replaceAll("\\s", "");
    }

    private static boolean isPalindrom(String kalimat) {
        int panjang = kalimat.length();
        for (int i = 0; i < panjang / 2; i++) {
            if (kalimat.charAt(i) != kalimat.charAt(panjang - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static int hitungJumlahHuruf(String kalimat) {
        return kalimat.length();
    }
}
