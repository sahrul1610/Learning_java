import java.util.Scanner;

public class ParkirMallG47 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int jenisKendaraan, lamaParkir;
        int biayaJamPertama, biayaPerjamberikutnya, biayaMax, biayaTotal;
        String jenisKendaraanString;
        String result;

        // Mobil, Motor, Box, Bus, Sepeda
        int[] arrBiayaJamPertama = {5000, 2000, 10000, 15000, 1000};
        int[] arrBiayaPerJamBerikutnya = {2000, 1000, 5000, 10000, 500};
        int[] arrBiayaParkirMaksimal = {25000, 10000, 50000, 75000, 5000};
        String[] arrJenisKendaraan = {"Mobil", "Motor", "Box", "Bus", "Sepeda"};

        contohVoid();
        jenisKendaraanString = input.nextLine();
        lamaParkir = input.nextInt();

        if (lamaParkir <= 0 || lamaParkir > 24) {
            result = "Input Error!!!";
        }else{
            jenisKendaraan = getNomorKategoriKendaraan(jenisKendaraanString, arrJenisKendaraan);
            biayaJamPertama = getTarifJamPertama(jenisKendaraan, arrBiayaJamPertama);
            biayaPerjamberikutnya = getTarifJamBerikutnya(jenisKendaraan, arrBiayaPerJamBerikutnya);
            biayaMax = getTarifMaksimal(jenisKendaraan, arrBiayaParkirMaksimal);
            biayaTotal = calculateTotalTarif(biayaJamPertama, lamaParkir, biayaPerjamberikutnya, biayaMax);

            result = String.valueOf(biayaTotal);
        }

        System.out.println(result);

        input.close();
    }

    public static void contohVoid(){
        System.out.println("Masukkan jenis kendaraan");
    }

    public static int getNomorKategoriKendaraan(String jenisKendaraanString, String[] arrJenisKendaraan){
        //                         0        1       2      3        4
        // arrJenisKendaraan = {"Mobil", "Motor", "Box", "Bus", "Sepeda"};

        // Input = Box
        for (int i = 0; i < arrJenisKendaraan.length; i++) {
            // Perulangan ke 1 -> indeks 0 -> arrJenisKendaraan[i] = Mobil
            // Perulangan ke 2 -> indeks 1 -> arrJenisKendaraan[i] = Motor
            // Perulangan ke 3 -> indeks 2 -> arrJenisKendaraan[i] = Box
            if (arrJenisKendaraan[i].equalsIgnoreCase(jenisKendaraanString)) {
                return i + 1;
                // Return indeks 2 -> return 3
            }
        }

        return 0;
    }

    public static int getTarifJamPertama(int jenisKendaraan, int[] arrBiayaJamPertama){
        return arrBiayaJamPertama[jenisKendaraan - 1];
    }

    public static int getTarifJamBerikutnya(int jenisKendaraan, int[] arrBiayaPerJamBerikutnya){
        return arrBiayaPerJamBerikutnya[jenisKendaraan - 1];
    }

    public static int getTarifMaksimal(int jenisKendaraan, int[] arrBiayaParkirMaksimal){
        return arrBiayaParkirMaksimal[jenisKendaraan - 1];
    }
    
    public static int calculateTotalTarif(int biayaJamPertama, int lamaParkir, int biayaPerjamberikutnya, int biayaMax){
        int result;
        result = biayaJamPertama + ((lamaParkir - 1) * biayaPerjamberikutnya);

        if (result > biayaMax) {
                result = biayaMax;
        }
        return result;
    }
}
