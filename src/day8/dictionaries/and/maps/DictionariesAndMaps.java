package day8.dictionaries.and.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionariesAndMaps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Long> dictionary = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            dictionary.put(name, new Long(phone));
        }
        while (in.hasNext()) {
            String s = in.next();
            // Write code here
            if (dictionary.containsKey(s)) {
                System.out.println(s + "=" + dictionary.get(s));
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
