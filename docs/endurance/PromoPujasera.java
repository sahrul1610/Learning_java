import java.util.Scanner;

public class PromoPujasera{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        double JumlahHarga = scanner.nextDouble();
        int TanggalLahir = scanner.nextInt();

        double Hasil = calculate(JumlahHarga,TanggalLahir);
        System.out.printf("%.2f%n",Hasil);
        scanner.close();
        
    } 

    private static double calculate(double JumlahHarga, int TanggalLahir){

        if (JumlahHarga >= 50000) {
            double discount = 0.02 * TanggalLahir * JumlahHarga;
            
            return JumlahHarga - discount;
        } else {
            return JumlahHarga;
        }
    }
}