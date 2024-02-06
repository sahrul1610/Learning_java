import java.util.Scanner;

public class AgentTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jumlahPenumpang = scanner.nextInt();

        int hargaTermurah = rekomendasiBusTermurah(jumlahPenumpang);

        System.out.println(hargaTermurah);

        scanner.close();
    }

    public static int rekomendasiBusTermurah(int jumlahPenumpang) {
        int[] kapasitasBus = {120, 60, 45, 32, 18, 12};
        int[] hargaBus = {4600000,2300000, 2000000, 1800000, 1500000, 1300000};

        int hargaTermurah = Integer.MAX_VALUE;

        for (int i = 0; i < kapasitasBus.length; i++) {
            if (jumlahPenumpang <= kapasitasBus[i] && hargaBus[i] < hargaTermurah) {
                hargaTermurah = hargaBus[i];
            }
        }

        return hargaTermurah;
    }
}
