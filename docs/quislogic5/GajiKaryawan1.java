import java.util.Scanner;

public class GajiKaryawan1 {
    // Matriks GAJI_POKOK menyimpan gaji pokok berdasarkan posisi dan divisi
    private static final int[][] GAJI_POKOK = {
            {8000000, 9000000, 7500000, 7200000, 8500000},
            {7000000, 8000000, 6500000, 6200000, 7500000},
            {7500000, 8500000, 7000000, 6800000, 8000000},
            {10000000, 11000000, 9500000, 9200000, 10500000},
            {7500000, 8500000, 7000000, 6800000, 8000000}
    };

    // Array TUNJANGAN_TRANSPORT menyimpan tunjangan transport berdasarkan divisi
    private static final int[] TUNJANGAN_TRANSPORT = {1000000, 1500000, 1200000, 1100000, 1300000};

    // Persentase tunjangan kesehatan, potongan BPJS, dan potongan PPH
    private static final double PERSENTASE_TUNJANGAN_KESEHATAN = 0.02;
    private static final double PERSENTASE_POTONGAN_BPJS = 0.03;
    private static final double PERSENTASE_POTONGAN_PPH = 0.05;

    // Jumlah hari kerja dalam sebulan, tunjangan makan per hari, dan format uang
    private static final int JUMLAH_HARI_KERJA = 22;
    private static final int TUNJANGAN_MAKAN_PER_HARI = 50000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input posisi dan divisi karyawan
        String posisi = scanner.nextLine();
        String divisi = scanner.nextLine();

        // Hitung gaji bersih menggunakan method calculateGajiBersih
        double gajiBersih = calculateGajiBersih(posisi, divisi);

        // Tampilkan output sesuai format
        System.out.println(posisi);
        System.out.println(divisi);
        System.out.println(JUMLAH_HARI_KERJA + " hari");
        System.out.printf("%,.2f%n", gajiBersih);

        scanner.close();
    }

    // Method untuk menghitung gaji bersih berdasarkan posisi dan divisi
    private static double calculateGajiBersih(String posisi, String divisi) {
        int gajiPokok = getGajiPokok(posisi, divisi);
        int tunjanganTransport = getTunjanganTransport(divisi);
        double tunjanganMakan = calculateTunjanganMakan();
        double tunjanganKesehatan = calculateTunjanganKesehatan(gajiPokok);
        double potonganBPJS = calculatePotonganBPJS(gajiPokok);
        double potonganPPH = calculatePotonganPPH(gajiPokok);

        // Hitung gaji bersih
        return gajiPokok + tunjanganTransport + tunjanganMakan + tunjanganKesehatan - potonganBPJS - potonganPPH;
    }

    // Method untuk mendapatkan gaji pokok berdasarkan posisi dan divisi
    private static int getGajiPokok(String posisi, String divisi) {
        int posisiIndex = getPositionIndex(posisi);
        int divisiIndex = getDivisionIndex(divisi);
        if (posisiIndex != -1 && divisiIndex != -1) {
            return GAJI_POKOK[posisiIndex][divisiIndex];
        } else {
            throw new IllegalArgumentException("Posisi atau Divisi tidak valid");
        }
    }

    // Method untuk mendapatkan tunjangan transport berdasarkan divisi
    private static int getTunjanganTransport(String divisi) {
        int divisiIndex = getDivisionIndex(divisi);
        if (divisiIndex != -1) {
            return TUNJANGAN_TRANSPORT[divisiIndex];
        } else {
            throw new IllegalArgumentException("Divisi tidak valid");
        }
    }

    // Method untuk menghitung tunjangan makan
    private static double calculateTunjanganMakan() {
        return TUNJANGAN_MAKAN_PER_HARI * JUMLAH_HARI_KERJA;
    }

    // Method untuk menghitung tunjangan kesehatan
    private static double calculateTunjanganKesehatan(int gajiPokok) {
        return PERSENTASE_TUNJANGAN_KESEHATAN * gajiPokok;
    }

    // Method untuk menghitung potongan BPJS
    private static double calculatePotonganBPJS(int gajiPokok) {
        return PERSENTASE_POTONGAN_BPJS * gajiPokok;
    }

    // Method untuk menghitung potongan PPH
    private static double calculatePotonganPPH(int gajiPokok) {
        return PERSENTASE_POTONGAN_PPH * gajiPokok;
    }

    // Method untuk mendapatkan index posisi dalam array positions
    private static int getPositionIndex(String posisi) {
        String[] positions = {"Software Engineer", "Data Analyst", "UX Designer", "Project Manager", "QA Engineer"};
        for (int i = 0; i < positions.length; i++) {
            if (positions[i].equals(posisi)) {
                return i;
            }
        }
        return -1;
    }

    // Method untuk mendapatkan index divisi dalam array divisions
    private static int getDivisionIndex(String divisi) {
        String[] divisions = {"Surabaya", "Jakarta", "Bandung", "Medan", "Makassar"};
        for (int i = 0; i < divisions.length; i++) {
            if (divisions[i].equals(divisi)) {
                return i;
            }
        }
        return -1;
    }
}
