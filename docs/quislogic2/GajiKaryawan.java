import java.util.Scanner;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input kota cabang, posisi jabatan, lama bekerja, dan status pernikahan
        String kotaCabang = scanner.nextLine();
        String posisiJabatan = scanner.nextLine();
        int lamaBekerja = scanner.nextInt();
        boolean statusPernikahan = scanner.nextBoolean();

        // Hitung gaji karyawan
        hitungGajiKaryawan(kotaCabang, posisiJabatan, lamaBekerja, statusPernikahan);

        scanner.close();
    }

    public static void hitungGajiKaryawan(String kotaCabang, String posisiJabatan, int lamaBekerja, boolean statusPernikahan) {
        // Tentukan UMK berdasarkan kota cabang
        int umk = 0;
        switch (kotaCabang.toLowerCase()) {
            case "garut":
                umk = 1961085;
                break;
            case "bandung":
                umk = 3742276;
                break;
            case "jakarta":
                umk = 4453935;
                break;
            case "bekasi":
                umk = 4782935;
                break;
            case "bogor":
                umk = 4330249;
                break;
            case "palembang":
                umk = 3289409;
                break;
            default:
                System.out.println("Kota cabang tidak valid.");
                return;
        }

        // Hitung gaji pokok
        int gajiPokok = hitungGajiPokok(posisiJabatan, lamaBekerja, umk);

        // Hitung tunjangan keluarga
        int tunjanganKeluarga = (statusPernikahan) ? (int) (0.1 * gajiPokok) : 0;

        // Hitung tunjangan jabatan
        int tunjanganJabatan = (lamaBekerja > 4) ? (int) (0.05 * gajiPokok) : 0;

        // Hitung tunjangan pegawai berdasarkan posisi jabatan
        int tunjanganPegawai = hitungTunjanganPegawai(posisiJabatan);

        // Hitung gaji kotor
        int gajiKotor = gajiPokok + tunjanganKeluarga + tunjanganJabatan + tunjanganPegawai;

        // Hitung potongan pensiun, BPJS, dan PPH
        int potonganPensiun = (int) (0.02 * gajiKotor);
        int potonganBPJS = (int) (0.02 * gajiKotor);
        int potonganPPH = (int) (0.05 * gajiKotor);

        // Hitung gaji bersih
        int gajiBersih = gajiKotor - potonganPensiun - potonganBPJS - potonganPPH;

        // Tampilkan hasil
        System.out.println(gajiPokok);
        System.out.println(tunjanganKeluarga);
        System.out.println(tunjanganJabatan);
        System.out.println(tunjanganPegawai);
        System.out.println(gajiKotor);
        System.out.println(potonganPensiun);
        System.out.println(potonganBPJS);
        System.out.println(potonganPPH);
        System.out.println(gajiBersih);
    }

    public static int hitungGajiPokok(String posisiJabatan, int lamaBekerja, int umk) {
        int gajiPokok = 0;
        switch (posisiJabatan.toLowerCase()) {
            case "admin":
                gajiPokok = (lamaBekerja < 2) ? umk : (int) (1.2 * umk);
                break;
            case "coordinator":
                gajiPokok = (lamaBekerja < 3) ? (int) (1.1 * umk) : (int) (1.3 * umk);
                break;
            case "spv":
                if (lamaBekerja < 2) {
                    gajiPokok = (int) (1.25 * umk);
                } else if (lamaBekerja >= 2 && lamaBekerja <= 4) {
                    gajiPokok = (int) (1.4 * umk);
                } else {
                    gajiPokok = (int) (1.5 * umk);
                }
                break;
            case "sprinter":
                gajiPokok = (int) (0.9 * umk);
                break;
            case "officer":
                gajiPokok = umk;
                break;
            case "manager":
                gajiPokok = (lamaBekerja < 3) ? (int) (1.5 * umk) : (int) (2.0 * umk);
                break;
            default:
                System.out.println("Posisi jabatan tidak valid.");
        }
        return gajiPokok;
    }

    public static int hitungTunjanganPegawai(String posisiJabatan) {
        switch (posisiJabatan.toLowerCase()) {
            case "admin":
                return 200000;
            case "coordinator":
                return 500000;
            case "spv":
                return 700000;
            case "manager":
                return 1000000;
            case "sprinter":
            case "officer":
                return 200000;
            default:
                System.out.println("Posisi jabatan tidak valid.");
                return 0;
        }
    }
}
