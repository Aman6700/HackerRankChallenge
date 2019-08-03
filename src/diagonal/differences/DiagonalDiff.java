package diagonal.differences;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDiff {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int dimension = arr.size();
        int LRDiag = 0, RLDiag = 0;

        for (int i = 0; i < dimension; i++) {
            LRDiag = LRDiag + arr.get(i).get(i);
            RLDiag = RLDiag + arr.get(i).get(dimension - i - 1);
        }

        /*for (List<Integer> line : arr) {
            for (int i = 0; i < dimension; i++) {
                LRDiag = LRDiag + line.get(i);

                RLDiag = RLDiag + line.get(dimension - i - 1);
            }
        }*/
        int result = LRDiag > RLDiag ? (LRDiag - RLDiag) : (RLDiag - LRDiag);
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDiff.diagonalDifference(arr);

        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
