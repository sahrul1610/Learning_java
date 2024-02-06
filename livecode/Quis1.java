import java.util.Scanner;
public class Quis1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] X = new int[4][4];

        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                X[i][j] = scanner.nextInt();
            }
        }

        int countOdd = countOddNumbers(X);
        System.out.println(countOdd);
        scanner.close();
    } 

    private static int countOddNumbers(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++){
                if(array[i][j] % 2 != 0){
                    count++;
                }
            }
        }
        return count;
    }
}