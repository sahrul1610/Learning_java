import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        System.out.print("Masukkan huruf yang ingin dihitung: ");
        char hurufDicari = scanner.next().charAt(0);


        int jumlahHuruf = hitungHuruf(kalimat, hurufDicari);

        System.out.println("Jumlah kemunculan huruf '" + hurufDicari + "' dalam kalimat: " + jumlahHuruf);
    }

    private static int hitungHuruf(String kalimat, char huruf) {
        int count = 0;
        for (int i = 0; i < kalimat.length(); i++) {
            if (kalimat.charAt(i) == huruf) {
                count++;
            }
        }
        return count;
    }
}
