package grading.students;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GradingStudents {

    static List<Integer> gradingStudents(List<Integer> grades) {

        int[] result = new int[grades.size()];
        List<Integer> resultList = new ArrayList<>();


        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) % 5 >= 3) {
                int newGrade = grades.get(i) + (5 - (grades.get(i) % 5));
                if (newGrade < 40) {
                    System.out.println(grades.get(i));
                    resultList.add(grades.get(i));
                } else {
                    System.out.println(newGrade);
                    resultList.add(newGrade);
                }
            } else {
                System.out.println(grades.get(i));
                resultList.add(grades.get(i));
            }
        }

        /*for (int grade : grades) {
            if (grade % 5 >= 3) {
                int newGrade = grade + (5 - (grade % 5));
                if (newGrade < 40) {
                    System.out.println(grade);
                } else {
                    System.out.println(newGrade);
                }
            }
        }*/


        return resultList;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = GradingStudents.gradingStudents(grades);

        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }

}

