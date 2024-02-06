import java.util.Scanner;
//soal no 4 betul
public class TotalTabungan {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input jumlah keluarga dan lama tabungan
        int jumlahKeluarga = scanner.nextInt();
        int lamaTabungan = scanner.nextInt();

        // Hitung total tabungan
        long totalTabungan = hitungTotalTabungan(jumlahKeluarga, lamaTabungan);

        // Menampilkan hasil
        System.out.println(totalTabungan);

        scanner.close();
    }

    // Fungsi untuk menghitung total tabungan
    public static long hitungTotalTabungan(int jumlahKeluarga, int lamaTabungan) {
        long totalTabungan = 0;

        for (int bulan = 1; bulan <= lamaTabungan; bulan++) {
            totalTabungan += hitungTabunganBulan(bulan, jumlahKeluarga);
        }

        return totalTabungan;
    }

    // Fungsi untuk menghitung tabungan pada suatu bulan
    public static long hitungTabunganBulan(int bulan, int jumlahKeluarga) {
        int hariDalamBulan = hitungHariDalamBulan(bulan);
        long totalTabunganBulan = 0;

        for (int tanggal = 1; tanggal <= hariDalamBulan; tanggal++) {
            totalTabunganBulan += tanggal;
        }

        return totalTabunganBulan * jumlahKeluarga * 1000;
    }

    // Fungsi untuk menghitung jumlah hari dalam suatu bulan
    public static int hitungHariDalamBulan(int bulan) {
        if (bulan == 2) {
            // Februari
            return 29; // Tahun kabisat
        } else if (bulan == 4 || bulan == 6 || bulan == 9 || bulan == 11) {
            // April, Juni, September, November
            return 30;
        } else {
            // Bulan lainnya
            return 31;
        }
    }
}
