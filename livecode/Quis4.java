import java.util.Scanner;
public class Quis4{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int x3 = scanner.nextInt();

        sortDescending(x1, x2, x3);
        scanner.close();
    }

    private static void sortDescending(int a, int b, int c){
        int temp;
        //menukar nilai
        if (a < b){
            temp = a;
            a = b;
            b = temp;
        }
        if (a < b){
            temp = a;
            a = c;
            c = temp;
        }
        if (b < c){
            temp = b;
            b = c;
            c = temp;
        }
        System.out.println(a + " " + b + " " + c);
    }
}