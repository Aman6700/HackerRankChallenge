package day12.inheritance;

import java.util.Arrays;
import java.util.Scanner;

public class Inheritance {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String lastName = scan.next();
        int id = scan.nextInt();
        int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate());
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int id;

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    void printPerson() {
        System.out.println("Name: " + firstName + ", " + lastName);
        System.out.println("ID: " + id);
    }
}

class Student extends Person {
    private int[] testScores;


    public Student(String firstName, String lastName, int id, int[] testScores) {
        super(firstName, lastName, id);
        this.testScores = testScores;
    }


    String calculate() {
        int avg = (Arrays.stream(testScores).sum()) / testScores.length;
        String grade = "";
        if (avg >= 90 && avg <= 100) {
            grade = "O";
        } else if (avg >= 80 && avg < 90) {
            grade = "E";
        } else if (avg >= 70 && avg < 80) {
            grade = "A";
        } else if (avg >= 55 && avg < 70) {
            grade = "P";
        } else if (avg >= 40 && avg < 55) {
            grade = "D";
        } else {
            grade = "T";
        }

        return grade;
    }
}
