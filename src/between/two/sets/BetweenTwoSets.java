package between.two.sets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here

        //Find LCM of a
        int aLcm = 1;
        for (int aa : a) {
            aLcm = LCM(aLcm, aa);
        }

        //Find GCD of b
        int bGcd = b.get(0);
        for (int i = 1; i < b.size(); i++) {
            bGcd = GCD(bGcd, b.get(i));
        }

        List<Integer> resultList = new ArrayList<>();
        int k = 1;

        while (true) {
            if (bGcd % (aLcm * k) == 0) {
                resultList.add(aLcm * k);
                //break;
            } else if (aLcm * k > bGcd) {
                break;
            }
            k = k + 1;
        }
        return resultList.size();
    }

    static int LCM(int x, int y) {
        int lcm;
        lcm = (x * y) / GCD(x, y);
        return lcm;
    }

    static int GCD(int x, int y) {
        int a;
        int b;
        a = x > y ? x : y;
        b = x < y ? x : y;
        int r = b;
        while (a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = BetweenTwoSets.getTotalX(arr, brr);

        /*bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
