package time.conversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeConversion {
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String h = s.split(":")[0];
        String mm = s.split(":")[1];
        String ss = s.substring(s.length() - 4, s.length() - 2);

        String AmPm = s.substring(s.length() - 2);
        String hh = "";
        if (AmPm.equals("PM")) {
            if (Integer.valueOf(h) == 12) {
                hh = h;
            } else {
                hh = String.valueOf(Integer.valueOf(h) + 12);
            }
        } else {
            if (Integer.valueOf(h) == 12) {
                hh = "00";
            } else {
                hh = h;
            }
        }
        String result = hh + ":" + mm + ":" + ss;
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String isContinue = "Y";

        while (isContinue.equalsIgnoreCase("Y")) {

            String s = scan.nextLine();
            String result = timeConversion(s);
            System.out.println(result);

            /*bw.write(result);
            bw.newLine();
            bw.close();*/

            System.out.println("Want to Continue Y/N : ");
            isContinue = scan.nextLine();
            System.out.println("Thank for " + isContinue);

        }
    }
}
