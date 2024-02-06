import java.util.Scanner;
public class Test1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double hargaBarang = scanner.nextDouble();
        int jumlahBarang = scanner.nextInt();

        double harga = 0;

        if (jumlahBarang % 3 == 0 && jumlahBarang % 4 == 0) {
            double potongan = 0.15 * hargaBarang * jumlahBarang;
            harga = (hargaBarang * jumlahBarang) - potongan;


        }else{
            harga = hargaBarang * jumlahBarang;
        }

        System.out.printf("%.2f\n", harga);
    }
}