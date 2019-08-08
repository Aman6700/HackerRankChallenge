package migratory.birds;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MigratoryBirds {
    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        Collections.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int ar : arr) {
            int k = ar;
            Integer v = map.get(k);
            if (v != null) {
                v = v + 1;
            } else {
                v = 1;
            }
            map.put(k, v);
        }
        int maxV = map.get(1);
        int minK = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int newK = entry.getKey();
            int newV = entry.getValue();
            if (newV > maxV) {
                maxV = newV;
                minK = newK;
            } else if (newV == maxV) {
                if (newK < minK) {
                    minK = newK;
                    maxV = newV;
                }
            }
        }
        return minK;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
