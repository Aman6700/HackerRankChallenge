package breaking.the.records;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BreakingTheRecords {
    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {

        int maxScore, minScore;
        List<Integer> minList = new ArrayList<>();
        List<Integer> maxList = new ArrayList<>();

        minScore = scores[0];
        maxScore = scores[0];

        minList.add(minScore);
        maxList.add(maxScore);

        for (int score : scores) {
            if (score < minScore) {
                minScore = score;
                minList.add(score);
            } else if (score > maxScore) {
                maxScore = score;
                maxList.add(score);
            }
        }

        int[] result = new int[2];
        result[0] = maxList.size() - 1;
        result[1] = minList.size() - 1;

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        /*for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
