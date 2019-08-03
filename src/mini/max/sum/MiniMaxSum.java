package mini.max.sum;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MiniMaxSum {
    static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long maxSum = 0, minSum = 0;
        for (int i = 1; i < arr.length; i++) {
            maxSum = maxSum + arr[i];
        }
        minSum = arr[0] + maxSum - arr[arr.length - 1];

        System.out.println(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
