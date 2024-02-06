import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        int jumlahKarakter = hitungKarakter(kalimat);

        System.out.println("Jumlah karakter dalam kalimat: " + jumlahKarakter);
    }

    private static int hitungKarakter(String kalimat) {
        return kalimat.length();
    }
}
