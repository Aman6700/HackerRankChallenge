package day6.lets.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetsReview {
    private static final Scanner scanner = new Scanner(System.in);

    static void review(List<String> words) {
        for (String word : words) {
            int length = word.length();
            StringBuilder evenBuilder = new StringBuilder();
            StringBuilder oddBuilder = new StringBuilder();
            for (int i = 0; i < length - 1; i = i + 2) {
                evenBuilder.append(word.charAt(i));
                oddBuilder.append(word.charAt(i + 1));
            }
            if (length % 2 == 1) {
                evenBuilder.append(word.charAt(length - 1));
            }
            System.out.println(evenBuilder.toString() + " " + oddBuilder.toString());
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int t = scanner.nextInt();
        List<String> words = new ArrayList<>();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < t; i++) {
            words.add(scanner.nextLine());
        }
        review(words);
        scanner.close();
    }
}
