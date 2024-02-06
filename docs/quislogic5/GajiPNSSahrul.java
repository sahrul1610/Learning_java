
/**
 * GajiPNSSahrul
 * Created rabu 1 10.30
 */
// import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GajiPNSSahrul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Nama Pegawai: ");
        String nama = validateNama(scanner);

        System.out.print("Golongan Pangkat (1-4): ");
        // int golonganPangkat = scanner.nextInt();
        int golonganPangkat = validateGolonganPangkat(scanner);

        System.out.print("Golongan Ruang Kerja (A, B, C, D, E): ");
        // String tipeGolongan = scanner.next();
        String tipeGolongan = validateTipeGolongan(scanner);

        System.out.print("Masa Kerja: ");
        int masaKerja = validateMasaKerja(scanner);

        System.out.print("Status Pernikahan (Kawin, Belum Kawin, Cerai): ");
        String statusPernikahan = validateStatusPernikahan(scanner);
        // scanner.nextLine();

        System.out.print("Jumlah Anak: ");
        int jumlahAnak = validateJumlahAnak(scanner);

        // Proses perhitungan gaji
        int gajiPokok = kalkulasiGajiPokok(masaKerja, tipeGolongan, golonganPangkat);
        int tunjanganKeluarga = kalkulasiTunjanganKeluarga(statusPernikahan, gajiPokok);
        int tunjanganAnak = kalkulasiTunjanganAnak(jumlahAnak, gajiPokok);
        int tunjanganBeras = kalkulasiTunjanganBeras(statusPernikahan, jumlahAnak);
        int tunjanganUmumJabatan = kalkulasiTunjanganUmumJabatan(golonganPangkat);
        int gajiKotor = kalkulasiGajiKotor(gajiPokok, tunjanganAnak, tunjanganKeluarga, tunjanganUmumJabatan,
                tunjanganBeras);
        int potonganPPH = kalkulasiPotonganPPH(gajiPokok, statusPernikahan, gajiKotor, jumlahAnak, tunjanganKeluarga,
                tunjanganAnak);
        int potonganIWP = kalkulasiPotonganIWP(gajiPokok, tunjanganAnak, tunjanganKeluarga);
        int potonganTaperum = kalkulasiPotonganTaperum(golonganPangkat);
        int gajiBersih = kalkulasiGajiBersih(gajiKotor, potonganPPH, potonganIWP, potonganTaperum);

        // Output
        displayOutput(nama, gajiPokok, tunjanganKeluarga, tunjanganAnak, tunjanganBeras, tunjanganUmumJabatan,
                gajiKotor, potonganPPH, potonganIWP, potonganTaperum, gajiBersih);
    }

    static String validateNama(Scanner scanner) {
        String nama;
        do {
            nama = scanner.nextLine();
            if (nama.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Input tidak valid. Harap masukkan nama dengan karakter huruf dan spasi.");
                System.out.print("Nama Pegawai: ");
            }
        } while (true);
        return nama;
    }
    static int validateGolonganPangkat(Scanner scanner) {
        int golonganPangkat;
        do {
            try {
                golonganPangkat = Integer.parseInt(scanner.nextLine());
                if (golonganPangkat >= 1 && golonganPangkat <= 4) {
                    break;
                } else {
                    System.out.println("Input tidak valid. Harap masukkan angka antara 1 dan 4.");
                    System.out.print("Golongan Pangkat (1-4): ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                System.out.print("Golongan Pangkat (1-4): ");
            }
        } while (true);
        return golonganPangkat;
    }

    static String validateTipeGolongan(Scanner scanner) {
        String tipeGolongan;
        do {
            tipeGolongan = scanner.nextLine().toUpperCase();
            if (tipeGolongan.matches("[A-E]")) {
                break;
            } else {
                System.out.println("Input tidak valid. Harap masukkan antara A dan E.");
                System.out.print("Golongan Ruang Kerja (A, B, C, D, E): ");
            }
        } while (true);
        return tipeGolongan;
    }

    static int validateMasaKerja(Scanner scanner) {
        int masaKerja;
        String regexMasaKerja = "^[1-9]\\d?$|50";  // Angka dari 1-50

        do {
            try {
                masaKerja = Integer.parseInt(scanner.nextLine());
                if (masaKerja >= 0 && masaKerja <= 50 && String.valueOf(masaKerja).matches(regexMasaKerja)) {
                    break;
                } else {
                    System.out.println("Masukkan angka antara 0 dan 50. Coba input ulang.");
                    System.out.print("Masa Kerja: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka. Coba input ulang.");
                System.out.print("Masa Kerja: ");
            }
        } while (true);

        return masaKerja;
    }

    static String validateStatusPernikahan(Scanner scanner) {
        String statusPernikahan;
        String regexPernikahan = "^(Kawin|Belum Kawin|Cerai)$";
        do {
            statusPernikahan = scanner.nextLine();
            if (statusPernikahan.matches(regexPernikahan)) {
                break;
            } else {
                System.out.println("Masukkan status pernikahan yang valid (Kawin, Belum Kawin, Cerai). Coba input ulang.");
                System.out.print("Status Pernikahan (Kawin, Belum Kawin, Cerai): ");
            }
        } while (true);
        return statusPernikahan;
    }

    static int validateJumlahAnak(Scanner scanner) {
        int jumlahAnak;
        do {
            try {
                jumlahAnak = Integer.parseInt(scanner.nextLine());
                if (jumlahAnak >= 0) {
                    break;
                } else {
                    System.out.println("Masukkan angka non-negatif. Coba input ulang.");
                    System.out.print("Jumlah Anak: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka. Coba input ulang.");
                System.out.print("Jumlah Anak: ");
            }
        } while (true);
        return jumlahAnak;
    }

    // Fungsi-fungsi perhitungan gaji
    static int kalkulasiGajiPokok(int masaKerja, String tipeGolongan, int golonganPangkat) {
        // Implementasi data gaji pokok menggunakan array multidimensi
        int[][][] gajiPokokArray = {
                // Data gaji pokok untuk Golongan I
                {
                        { 1560800, 1560800, 1560800, 1560800 },
                        { 1560800, 1560800, 1560800, 1560800 },
                        { 1610000, 1610000, 1610000, 1610000 },
                        { 1610000, 1704500, 1776600, 1851800 },
                        { 1660700, 1704500, 1776600, 1851800 },
                        { 1660700, 1758200, 1832600, 1910100 },
                        { 1713000, 1758200, 1832600, 1910100 },
                        { 1713000, 1813600, 1890300, 1970200 },
                        { 1766900, 1813600, 1890300, 1970200 },
                        { 1766900, 1870700, 1949800, 2032300 },
                        { 1822600, 1870700, 1949800, 2032300 },
                        { 1822600, 1929600, 2011200, 2096300 },
                        { 1880000, 1929600, 2011200, 2096300 },
                        { 1880000, 1990400, 2074600, 2162300 },
                        { 1939200, 1990400, 2074600, 2162300 },
                        { 1939200, 2053100, 2139900, 2230400 },
                        { 2000300, 2053100, 2139900, 2230400 },
                        { 2000300, 2117700, 2207300, 2300700 },
                        { 2063300, 2117700, 2207300, 2300700 },
                        { 2063300, 2184400, 2276800, 2373100 },
                        { 2128300, 2184400, 2276800, 2373100 },
                        { 2128300, 2253200, 2348500, 2447900 },
                        { 2195300, 2253200, 2348500, 2447900 },
                        { 2195300, 2324200, 2422500, 2525000 },
                        { 2264400, 2324200, 2422500, 2525000 },
                        { 2264400, 2397400, 2498800, 2604500 },
                        { 2335800, 2397400, 2498800, 2604500 },
                        { 2335800, 2472900, 2557500, 2686500 }
                },
                // Data gaji pokok untuk Golongan II
                {
                        { 2022200, 2022200, 2022200, 2022200 },
                        { 2054100, 2054100, 2054100, 2054100 },
                        { 2054100, 2054100, 2054100, 2054100 },
                        { 2118800, 2208400, 2301800, 2399200 },
                        { 2118800, 2208400, 2301800, 2399200 },
                        { 2185500, 2277900, 2374300, 2474700 },
                        { 2185500, 2277900, 2374300, 2474700 },
                        { 2254300, 2349700, 2449100, 2552700 },
                        { 2254300, 2349700, 2449100, 2552700 },
                        { 2325300, 2423700, 2526200, 2633100 },
                        { 2325300, 2423700, 2526200, 2633100 },
                        { 2398600, 2500000, 2605800, 2716000 },
                        { 2398600, 2500000, 2605800, 2716000 },
                        { 2474100, 2578800, 2687800, 2801500 },
                        { 2474100, 2578800, 2687800, 2801500 },
                        { 2552000, 2660000, 2772500, 2889800 },
                        { 2552000, 2660000, 2772500, 2889800 },
                        { 2632400, 2743800, 2859800, 2980800 },
                        { 2632400, 2743800, 2859800, 2980800 },
                        { 2715300, 2830200, 2949900, 3074700 },
                        { 2715300, 2830200, 2949900, 3074700 },
                        { 2800800, 2919300, 3042800, 3171500 },
                        { 2800800, 2919300, 3042800, 3171500 },
                        { 2889100, 3011200, 3138600, 3271400 },
                        { 2889100, 3011200, 3138600, 3271400 },
                        { 2980000, 3106100, 3237500, 3374400 },
                        { 2980000, 3106100, 3237500, 3374400 },
                        { 3073900, 3203900, 3339400, 3480700 },
                        { 3073900, 3203900, 3339400, 3480700 },
                        { 3170700, 3304800, 3444600, 3590300 },
                        { 3170700, 3304800, 3444600, 3590300 },
                        { 3270600, 3408900, 3553100, 3703400 },
                        { 3270600, 3408900, 3553100, 3703400 },
                        { 3373600, 3516300, 3665000, 3820000 }
                },
                // Data untuk Golongan III
                {
                        { 2579400, 2688500, 2802300, 2920800 },
                        { 2579400, 2688500, 2802300, 2920800 },
                        { 2660700, 2773200, 2890500, 3012800 },
                        { 2660700, 2773200, 2890500, 3012800 },
                        { 2744500, 2860500, 2981500, 3107700 },
                        { 2744500, 2860500, 2981500, 3107700 },
                        { 2830900, 2950600, 3075500, 3205500 },
                        { 2830900, 2950600, 3075500, 3205500 },
                        { 2920100, 3043600, 3172300, 3306500 },
                        { 2920100, 3043600, 3172300, 3306500 },
                        { 3012000, 3139400, 3272200, 3410600 },
                        { 3012000, 3139400, 3272200, 3410600 },
                        { 3106900, 3238300, 3375300, 3518100 },
                        { 3106900, 3238300, 3375300, 3518100 },
                        { 3204700, 3340300, 3481600, 3628900 },
                        { 3204700, 3340300, 3481600, 3628900 },
                        { 3305700, 3445500, 3591200, 3743100 },
                        { 3305700, 3445500, 3591200, 3743100 },
                        { 3409800, 3554000, 3704300, 3861000 },
                        { 3409800, 3554000, 3704300, 3861000 },
                        { 3517200, 3665900, 3821000, 3982600 },
                        { 3517200, 3665900, 3821000, 3982600 },
                        { 3627900, 3781400, 3941400, 4108100 },
                        { 3627900, 3781400, 3941400, 4108100 },
                        { 3742200, 3900500, 4065500, 4237500 },
                        { 3742200, 3900500, 4065500, 4237500 },
                        { 3860100, 4023300, 4193500, 4370900 },
                        { 3860100, 4023300, 4193500, 4370900 },
                        { 3981600, 4150100, 4325600, 4508600 },
                        { 3981600, 4150100, 4325600, 4508600 },
                        { 4107000, 4280800, 4461800, 4650600 },
                        { 4107000, 4280800, 4461800, 4650600 },
                        { 4236400, 4415600, 4602400, 4797000 }
                },
                // Data untuk Golongan IV
                {
                        { 3044300, 3173100, 3307300, 3447200, 3593100 },
                        { 3044300, 3173100, 3307300, 3447200, 3593100 },
                        { 3140200, 3272100, 3411500, 3555800, 3706200 },
                        { 3140200, 3272100, 3411500, 3555800, 3706200 },
                        { 3239100, 3376100, 3518900, 3667800, 3822900 },
                        { 3239100, 3376100, 3518900, 3667800, 3822900 },
                        { 3341100, 3482500, 3629800, 3783300, 3943300 },
                        { 3341100, 3482500, 3629800, 3783300, 3943300 },
                        { 3446400, 3592100, 3744100, 3902500, 4067500 },
                        { 3446400, 3592100, 3744100, 3902500, 4067500 },
                        { 3554900, 3705300, 3862000, 4025400, 4195700 },
                        { 3554900, 3705300, 3862000, 4025400, 4195700 },
                        { 3666900, 3822000, 3983600, 4152200, 4327800 },
                        { 3666900, 3822000, 3983600, 4152200, 4327800 },
                        { 3782400, 3942400, 4109100, 4282900, 4462100 },
                        { 3782400, 3942400, 4109100, 4282900, 4462100 },
                        { 3901500, 4066500, 4238500, 4417800, 4604700 },
                        { 3901500, 4066500, 4238500, 4417800, 4604700 },
                        { 4024400, 4194600, 4372000, 4557000, 4749700 },
                        { 4024400, 4194600, 4372000, 4557000, 4749700 },
                        { 4151100, 4326700, 4509700, 4700500, 4899300 },
                        { 4151100, 4326700, 4509700, 4700500, 4899300 },
                        { 4281800, 4463000, 4651800, 4848500, 5053600 },
                        { 4281800, 4463000, 4651800, 4848500, 5053600 },
                        { 4416700, 4603500, 4798300, 5001200, 5212800 },
                        { 4416700, 4603500, 4798300, 5001200, 5212800 },
                        { 4555800, 4748500, 4949400, 5158700, 5377000 },
                        { 4555800, 4748500, 4949400, 5158700, 5377000 },
                        { 4699300, 4898100, 5105300, 5321200, 5546300 },
                        { 4699300, 4898100, 5105300, 5321200, 5546300 },
                        { 4847300, 5052300, 5266100, 5488800, 5721000 },
                        { 4847300, 5052300, 5266100, 5488800, 5721000 },
                        { 5000000, 5211500, 5431900, 5661700, 5901200 }
                },
        };

        // Mengambil data gaji pokok berdasarkan input
        int indexGolongan = golonganPangkat - 1; // Golongan dimulai dari 1, array dimulai dari 0
        int indexTipeGolongan = tipeGolongan.charAt(0) - 'A'; // Menggunakan huruf pertama dari tipe golongan
        System.out.println(indexTipeGolongan);
        int indexMasaKerja = Math.min(masaKerja, gajiPokokArray[indexGolongan].length - 1); // Masa kerja maksimal
        System.out.println(indexMasaKerja);                                                   // diambil dari data
        System.out.println(gajiPokokArray[indexGolongan][indexMasaKerja][indexTipeGolongan]);                                                                                  // diambil dari data

        return gajiPokokArray[indexGolongan][indexMasaKerja][indexTipeGolongan];
    }

    static int kalkulasiTunjanganKeluarga(String statusPernikahan, int gajiPokok) {
        if (statusPernikahan.equalsIgnoreCase("Kawin")) {
            return (int) (0.1 * gajiPokok);
        } else {
            return 0;
        }
    }

    static int kalkulasiTunjanganAnak(int jumlahAnak, int gajiPokok) {
        int maxJumlahAnak = 2;
        int tunjanganAnak = (int) (0.02 * gajiPokok) * Math.min(jumlahAnak, maxJumlahAnak);
        return tunjanganAnak;
    }

    static int kalkulasiTunjanganBeras(String statusPernikahan, int jumlahAnak) {
        int maxJumlahAnak = 2;
        int hargaBeras = 15000;
        int additionalMultiplier = (statusPernikahan.equals("Kawin")) ? 1 : 0;
        int tunjanganBeras = 10 * hargaBeras * (1 + Math.min(jumlahAnak, maxJumlahAnak) + additionalMultiplier);

        return tunjanganBeras;
    }

    static int kalkulasiTunjanganUmumJabatan(int golonganPangkat) {
        int[] tunjanganUmumJabatanArray = { 175000, 180000, 185000, 190000 };
        return tunjanganUmumJabatanArray[golonganPangkat - 1];
    }

    static int kalkulasiGajiKotor(int gajiPokok, int tunjanganAnak, int tunjanganKeluarga, int tunjanganUmumJabatan,
            int tunjanganBeras) {
        return gajiPokok + tunjanganAnak + tunjanganKeluarga + tunjanganUmumJabatan + tunjanganBeras;
    }

    static int kalkulasiPotonganPPH(int gajiPokok, String statusPernikahan, int gajiKotor, int jumlahAnak,
            int tunjanganKeluarga, int tunjanganAnak) {
        double persenBiayaJabatan = 0.05;
        double persenIuranPensiun = 0.0475;

        // Biaya Jabatan
        int biayaJabatan = (int) (persenBiayaJabatan * gajiKotor);
        // Iuran Pensiun
        int iuranPensiun = (int) (persenIuranPensiun * (gajiPokok + tunjanganKeluarga + tunjanganAnak));
        // Penghasilan Netto
        int penghasilanNetto = gajiKotor - biayaJabatan - iuranPensiun;
        int penghasilanNettoSetahun = penghasilanNetto * 12;
        
        if (gajiKotor < 4500000) {
            return 0;
        }
        // PTKP
        int ptkpDiriSendiri = 36000000;
        int ptkpPasangan = 3000000;
        int ptkpPerAnak = 3000000;
        int maxJumlahAnak = 3;

        int jumlahPtkp = ptkpDiriSendiri + ptkpPasangan + (ptkpPerAnak * Math.min(jumlahAnak, maxJumlahAnak));
        int PenghasilanKenaPajak = penghasilanNettoSetahun - jumlahPtkp;
        int PPhSetahun = (int)(0.05 * PenghasilanKenaPajak);
        int PPhSebulan = (int)(PPhSetahun / 12);
        return PPhSebulan;
    }

    static int kalkulasiPotonganIWP(int gajiPokok, int tunjanganAnak, int tunjanganKeluarga) {
        double persenIWP = 0.1;

        int iwp = (int) (persenIWP * (gajiPokok + tunjanganAnak + tunjanganKeluarga));

        return iwp;
    }

    static int kalkulasiPotonganTaperum(int golonganPangkat) {
        int[] taperumArray = { 3000, 5000, 7000, 10000 };
        return taperumArray[golonganPangkat - 1];
    }

    static int kalkulasiGajiBersih(int gajiKotor, int potonganPPH, int potonganIWP, int potonganTaperum) {
        return gajiKotor - potonganPPH - potonganIWP - potonganTaperum;
    }

    // Fungsi untuk menampilkan output
    // static void displayOutput(String nama, int gajiPokok, int tunjanganKeluarga, int tunjanganAnak, int tunjanganBeras,
    //         int tunjanganUmumJabatan, int gajiKotor, int potonganPPH, int potonganIWP, int potonganTaperum,
    //         int gajiBersih) {
    //     System.out.println("\n======= RINCIAN GAJI PEGAWAI =======");
    //     System.out.println("Nama Pegawai: " + nama);
    //     System.out.println("Gaji Pokok: " + gajiPokok);
    //     System.out.println("Tunjangan Keluarga: " + tunjanganKeluarga);
    //     System.out.println("Tunjangan Anak: " + tunjanganAnak);
    //     System.out.println("Tunjangan Beras: " + tunjanganBeras);
    //     System.out.println("Tunjangan Umum Jabatan: " + tunjanganUmumJabatan);
    //     System.out.println("Gaji Bruto: " + gajiKotor);
    //     System.out.println("PPh: " + potonganPPH);
    //     System.out.println("Potongan IWP: " + potonganIWP);
    //     System.out.println("Potongan Taperum: " + potonganTaperum);
    //     System.out.println("Gaji Take Home Pay: " + gajiBersih);
    // }

    static void displayOutput(String nama, int gajiPokok, int tunjanganKeluarga, int tunjanganAnak, int tunjanganBeras,
        int tunjanganUmumJabatan, int gajiKotor, int potonganPPH, int potonganIWP, int potonganTaperum,
        int gajiBersih) {
    DecimalFormat currencyFormat = new DecimalFormat("###,###,##0.00");

    System.out.println("\n======= RINCIAN GAJI PEGAWAI =======");
    System.out.println("Nama Pegawai: " + nama);
    System.out.println("Gaji Pokok: " + currencyFormat.format(gajiPokok));
    System.out.println("Tunjangan Keluarga: " + currencyFormat.format(tunjanganKeluarga));
    System.out.println("Tunjangan Anak: " + currencyFormat.format(tunjanganAnak));
    System.out.println("Tunjangan Beras: " + currencyFormat.format(tunjanganBeras));
    System.out.println("Tunjangan Umum Jabatan: " + currencyFormat.format(tunjanganUmumJabatan));
    System.out.println("Gaji Bruto: " + currencyFormat.format(gajiKotor));
    System.out.println("PPh: " + currencyFormat.format(potonganPPH));
    System.out.println("Potongan IWP: " + currencyFormat.format(potonganIWP));
    System.out.println("Potongan Taperum: " + currencyFormat.format(potonganTaperum));
    System.out.println("Gaji Take Home Pay: " + currencyFormat.format(gajiBersih));
}
}
