import java.util.Scanner;
public class TravelRecommendation {
//quis no 3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input jumlah orang, lama hari menginap, dan budget
        int p = scanner.nextInt();
        int d = scanner.nextInt();
        int b = scanner.nextInt();

        // Mencari destinasi wisata dengan budget terdekat
        String destinasiWisata = cariDestinasiTerdekat(p, d, b);

        // Menampilkan hasil rekomendasi
        if (destinasiWisata.equals("Need more budget")) {
            System.out.println(destinasiWisata);
        } else {
            int totalBiayaRekomendasi = hitungTotalBiaya(p, d, destinasiWisata);
            System.out.println(destinasiWisata + " " + totalBiayaRekomendasi);
        }

        scanner.close();
    }

    // Fungsi untuk mencari destinasi wisata dengan budget terdekat
    public static String cariDestinasiTerdekat(int p, int d, int b) {
        String[] destinasi = {"Lombok", "Bangkok", "Singapura", "Tokyo"};
        int[] totalBiaya = new int[4];

        for (int i = 0; i < destinasi.length; i++) {
            totalBiaya[i] = hitungTotalBiaya(p, d, destinasi[i]);
        }

        int indeksTerdekat = -1;
        int selisihTerdekat = Integer.MAX_VALUE;

        for (int i = 0; i < destinasi.length; i++) {
            int selisih = Math.abs(totalBiaya[i] - b);
            if (selisih < selisihTerdekat) {
                selisihTerdekat = selisih;
                indeksTerdekat = i;
            }
        }

        return indeksTerdekat != -1 ? destinasi[indeksTerdekat] : "Need more budget";
    }

    // Fungsi untuk menghitung total biaya untuk destinasi tertentu
    public static int hitungTotalBiaya(int p, int d, String destinasi) {
        int totalBiayaTransportasi = 0;
        int totalBiayaAkomodasi = 0;
        int totalBiayaCulinary = 0;
        int totalBiayaAktivitas = 0;

        switch (destinasi) {
            case "Lombok":
                totalBiayaTransportasi = p * 2170000;
                totalBiayaAkomodasi = p * d * 125000;
                totalBiayaCulinary = p * d * 75000;
                totalBiayaAktivitas = p * 250000;
                break;
            case "Bangkok":
                totalBiayaTransportasi = p * 3780000;
                totalBiayaAkomodasi = p * d * 155000;
                totalBiayaCulinary = p * d * 55000;
                totalBiayaAktivitas = p * 300000;
                break;
            case "Singapura":
                totalBiayaTransportasi = p * 1200000;
                totalBiayaAkomodasi = p * d * 170000;
                totalBiayaCulinary = p * d * 85000;
                totalBiayaAktivitas = p * 360000;
                break;
            case "Tokyo":
                totalBiayaTransportasi = p * 4760000;
                totalBiayaAkomodasi = p * d * 170000;
                totalBiayaCulinary = p * d * 105000;
                totalBiayaAktivitas = p * 325000;
                break;
        }

        // Menghitung total biaya untuk destinasi tertentu
        return totalBiayaTransportasi + totalBiayaAkomodasi + totalBiayaCulinary + totalBiayaAktivitas;
    }
}
