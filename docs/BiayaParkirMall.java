import java.util.Scanner;

public class BiayaParkirMall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kategoriKendaraan = scanner.nextInt();
        int lamaParkir = scanner.nextInt();

        int biayaPertama, biayaBerikutnya, biayaMaksimal;
        int biayaTotal = 0;

        switch (kategoriKendaraan) {
            case 1:
                // Mobil
                biayaPertama = 5000;
                biayaBerikutnya = 2000;
                biayaMaksimal = 25000;
                break;
            case 2:
                // Motor
                biayaPertama = 2000;
                biayaBerikutnya = 1000;
                biayaMaksimal = 10000;
                break;
            case 3:
                // Box
                biayaPertama = 10000;
                biayaBerikutnya = 5000;
                biayaMaksimal = 50000;
                break;
            default:
                System.out.println("Input Error!!!");
                return;
        }

        if (lamaParkir > 0) {
            biayaTotal = biayaPertama + biayaBerikutnya * (lamaParkir - 1);
            biayaTotal = Math.min(biayaTotal, biayaMaksimal);
        } else {
            System.out.println("Input Error!!!");
            return;
        }
        System.out.println(biayaTotal);

        scanner.close();
    }
}
