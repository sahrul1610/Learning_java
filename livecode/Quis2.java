import java.util.Scanner;
public class Quis2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int x3 = scanner.nextInt();

        int maxNumber = findMax(x1, x2, x3);

        System.out.println(maxNumber);


    }
    //membandingkan nilai
    public static int findMax(int a, int b, int c) {
        return Math.max(Math.max(a,b), c);
    }
}