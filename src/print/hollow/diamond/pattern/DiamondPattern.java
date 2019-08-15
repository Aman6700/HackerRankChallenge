package print.hollow.diamond.pattern;

import java.util.Scanner;

public class DiamondPattern {

    public static void main(String[] args) {
        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        int[] diamondArr = new int[t];
        for (int i = 0; i < t; i++) {
            diamondArr[i] = scanner.nextInt();
        }
        System.out.println("");
        System.out.println(diamondArr[0] + "....." + diamondArr[diamondArr.length - 1]);

    }
}
