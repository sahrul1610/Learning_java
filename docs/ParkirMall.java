import java.util.Scanner;;
public class ParkirMall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] biayaMobil = {5000, 2000, 25000}; // Mobil
        int[] biayaMotor = {2000, 1000, 10000}; // Motor
        int[] biayaBox = {10000, 5000, 50000};  // Box

        int kategoriKendaraan = scanner.nextInt();
        int lamaParkir = scanner.nextInt();

        int[] biaya = getBiayaByCategory(kategoriKendaraan, biayaMobil, biayaMotor, biayaBox);

        if (biaya != null && isValidParkirInput(lamaParkir)) {
            int biayaTotal = calculateBiayaTotal(biaya, lamaParkir);
            System.out.println(biayaTotal);
        } else {
            System.out.println("Input Error!!!");
        }

        scanner.close();
    }

    private static int[] getBiayaByCategory(int kategori, int[]... kendaraanBiaya) {
        if (kategori >= 1 && kategori <= kendaraanBiaya.length) {
            return kendaraanBiaya[kategori - 1];
        } else {
            return null;
        }
    }

    private static boolean isValidParkirInput(int lamaParkir) {
        return lamaParkir > 0;
    }

    private static int calculateBiayaTotal(int[] biaya, int lamaParkir) {
        int biayaPertama = biaya[0];
        int biayaBerikutnya = biaya[1];
        int biayaMaksimal = biaya[2];

        int biayaTotal = biayaPertama + biayaBerikutnya * (lamaParkir - 1);
        return Math.min(biayaTotal, biayaMaksimal);
    }
}
