package day10.binary.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryNumbers {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        List<Integer> binList = new ArrayList<>();
        while (n > 0) {
            binList.add(n % 2);
            n = n / 2;
        }

        int maxCount = 0;

        for (int i = 0; i < binList.size(); i++) {
            if (binList.get(i) == 1) {
                int j = i + 1;
                int currCount = 1;
                while ((j < binList.size()) && (binList.get(j) == 1)) {
                    currCount++;
                    j++;
                }
                if (currCount > maxCount) {
                    maxCount = currCount;
                }
            }
        }

        /*binList.forEach(System.out::print);
        System.out.println();
        System.out.println("Max One count" + maxCount);*/
        System.out.println(maxCount);
    }
}
