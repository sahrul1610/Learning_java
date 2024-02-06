import java.util.Scanner;

public class DecimalToRoman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input bilangan bulat
        int decimalNumber = scanner.nextInt();

        // Konversi dan tampilkan hasil
        String romanNumber = convertToRoman(decimalNumber);
        System.out.println(romanNumber);

        scanner.close();
    }

    // Fungsi untuk mengkonversi angka desimal menjadi angka Romawi
    private static String convertToRoman(int number) {
        if (number < 1 || number > 3999) {
            return "Input diluar rentang (1-3999)";
        }

        int[] decimalValues = {3000, 2000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"MMM","MM","M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; i < decimalValues.length; i++) {
            while (number >= decimalValues[i]) {
                romanNumber.append(romanSymbols[i]);
                number -= decimalValues[i];
            }
        }

        return romanNumber.toString();
    }
}
