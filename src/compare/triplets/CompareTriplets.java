package compare.triplets;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        Integer[] result = new Integer[2];
        result[0] = result[1] = 0;

        /*if (a.get(0) > b.get(0)) {
            result[0] = result[0] + 1;
        } else if (a.get(0) < b.get(0)) {
            result[1] = result[1] + 1;
        }

        if (a.get(1) > b.get(1)) {
            result[0] = result[0] + 1;
        } else if (a.get(1) < b.get(1)) {
            result[1] = result[1] + 1;
        }


        if (a.get(2) > b.get(2)) {
            result[0] = result[0] + 1;
        } else if (a.get(2) < b.get(2)) {
            result[1] = result[1] + 1;
        }*/

        for (int i = 0; i < 3; i++) {
            if (a.get(i) != b.get(i)) {
                int maxValIndex = a.get(i) > b.get(i) ? 0 : 1;
                result[maxValIndex] = result[maxValIndex] + 1;
            }
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result);
        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
