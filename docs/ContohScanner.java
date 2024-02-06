import java.util.Scanner;

public class ContohScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Pembuatan object scanner

        // 1
        System.out.println("Input string 1 : ");
        String input1 = input.nextLine();
        System.out.println("Input int 1 : ");
        double input2 = Double.valueOf(input.nextLine()); // tidak akan mengkonsumsi newLine
        System.out.println("Input string 2 : ");
        String input3 = input.nextLine();
        System.out.println("=================");
        System.out.println("Input 1 : " + input1);
        System.out.println("Input 2 : " + input2);
        System.out.println("Input 3 : " + input3);
        System.out.println("=================");

        // 2
        System.out.println("Input string 1 : ");
        String input1_2 = input.nextLine();
        System.out.println("Input int 1 : ");
        double input2_2 = input.nextDouble();
        input.nextLine(); // tidak akan mengkonsumsi newLine
        System.out.println("Input string 2 : ");
        String input3_2 = input.nextLine();
        System.out.println("=================");
        System.out.println("Input 1 : " + input1_2);
        System.out.println("Input 2 : " + input2_2);
        System.out.println("Input 3 : " + input3_2);
        System.out.println("=================");

        // 2
        System.out.println("Input string 1 : ");
        String input1_3 = input.nextLine();
        System.out.println("Input int 1 : ");
        double input2_3 = input.nextDouble(); // akan mengkonsumsi newLine
        System.out.println("Input string 2 : ");
        String input3_3 = input.nextLine();
        System.out.println("=================");
        System.out.println("Input 1 : " + input1_3);
        System.out.println("Input 2 : " + input2_3);
        System.out.println("Input 3 : " + input3_3);
        System.out.println("=================");

        /*
            input pada input3_3 akan ter-skip. Karena nextDouble (Termasuk next(), nextInt(), dll.) akan mengkonsumsi newLine dari `nextLine()`
        */

        input.close();
    }
}
