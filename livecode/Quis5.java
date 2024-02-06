import java.util.Scanner;
public class Quis5{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        double totalPrice = scanner.nextDouble();
        int birthDate = scanner.nextInt();

        double Hasil = calculate(totalPrice,birthDate);
        System.out.printf("%.2f%n",Hasil);
        scanner.close();
        
    } 

    private static double calculate(double totalPrice, int birthDate){
        //double discountRate = 0.02;
        // double discount = discountRate * birthDate * totalPrice ;
        
        // return totalPrice - discount ;
        if (totalPrice >= 50000) {
            double discount = 0.02 * birthDate * totalPrice;
            
            return totalPrice - discount;
        } else {
            return totalPrice;
        }
    }
}