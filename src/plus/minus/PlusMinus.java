package plus.minus;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {
    // Complete the plusMinus function below.

    static void plusMinus(int[] arr) {

        DecimalFormat df = new DecimalFormat("#.######");

        int positiveCount = 0, negativeCount = 0, zeroCount = 0;
        int length = arr.length;

        for (int number : arr) {
            if (number > 0) {
                positiveCount = positiveCount + 1;
            } else if (number < 0) {
                negativeCount = negativeCount + 1;
            }
        }
        zeroCount = length - (positiveCount + negativeCount);
        System.out.println(df.format(Double.valueOf(positiveCount) / length));
        System.out.println(df.format(Double.valueOf(negativeCount) / length));
        System.out.println(df.format(Double.valueOf(zeroCount) / length));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();

    }
}
