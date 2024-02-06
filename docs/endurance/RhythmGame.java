import java.util.Scanner;
//soalno1 betul
public class RhythmGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 
        String playerName = scanner.nextLine();

        int perfectCount = scanner.nextInt();
        int greatCount = scanner.nextInt();
        int goodCount = scanner.nextInt();
        int missCount = scanner.nextInt();


        int totalScore = calculateScore(perfectCount, greatCount, goodCount, missCount);
        int totalMaxScore = calculateTotalMaxScore(100, 0, 0); // Jumlah maksimal Perfect adalah 100


        double percentage = ((double) totalScore / totalMaxScore) * 100;
        String rank = getRank(percentage);


        printResult(playerName, totalScore, totalMaxScore, rank);

        scanner.close();
    }


    public static int calculateScore(int perfectCount, int greatCount, int goodCount, int missCount) {
        int perfectScore = perfectCount * 100;
        int greatScore = greatCount * 80;
        int goodScore = goodCount * 60;
        int missScore = 0;

        return perfectScore + greatScore + goodScore + missScore;
    }


    public static int calculateTotalMaxScore(int maxPerfect, int maxGreat, int maxGood) {
        return (maxPerfect * 100) + (maxGreat * 80) + (maxGood * 60);
    }

    public static String getRank(double percentage) {
        if (percentage >= 90) {
            return "S (Super)";
        } else if (percentage >= 80) {
            return "A (Amazing)";
        } else if (percentage >= 70) {
            return "B (Brilliant)";
        } else if (percentage >= 60) {
            return "C (Cool)";
        } else {
            return "D (Decent)";
        }
    }


    public static void printResult(String playerName, int totalScore, int totalMaxScore, String rank) {
        System.out.println(totalScore);
        System.out.println(playerName +" peringkat "+ rank);
    }
}
