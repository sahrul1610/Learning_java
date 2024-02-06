
import java.util.Scanner;
//soal no1 salah 1
public class TravelAgent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] kapasitasBus = {120, 60, 45, 32, 18, 12};
        int[] hargaBus = {4600000, 2300000, 2000000, 1800000, 1500000, 1300000};

        int jumlahPenumpang = scanner.nextInt();

        int hargaTermurah = cariHargaTermurah(jumlahPenumpang, kapasitasBus, hargaBus);

        System.out.println(hargaTermurah);

        scanner.close();
    }

    public static int cariHargaTermurah(int jumlahPenumpang, int[] kapasitasBus, int[] hargaBus) {
        int hargaTermurah = Integer.MAX_VALUE;

        for (int i = 0; i < kapasitasBus.length; i++) {
            if (kapasitasBus[i] >= jumlahPenumpang) {
                hargaTermurah = Math.min(hargaTermurah, hargaBus[i]);
            }
        }

        return hargaTermurah;
    }
}
