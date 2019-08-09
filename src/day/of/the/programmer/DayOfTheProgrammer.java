package day.of.the.programmer;

import java.io.*;

public class DayOfTheProgrammer {
    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {

        String dd = "";
        String result;
        if (year >= 1700 && year <= 1917) {
            //Julian Calendar
            if (year % 4 == 0) {
                dd = "12";
            } else {
                dd = "13";
            }

        } else if (year == 1918) {
            //transition period
            // jan 31, feb 15, mar 31, apr 30 may 31 jun 30 jul 31 aug 31 sep 26= 230
            //int totalDayas =
            dd = "26";
        } else if (year >= 1919) {
            //Gregorian Calendar
            if (year % 400 == 0) {
                dd = "12";
            } else if (year % 4 == 0 && year % 100 != 0) {
                dd = "12";
            } else {
                dd = "13";
            }

        }

        result = dd + ".09." + year;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        /*bufferedWriter.write(result);
        bufferedWriter.newLine();*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
