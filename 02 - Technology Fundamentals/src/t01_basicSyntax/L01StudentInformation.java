package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L01StudentInformation {

//    You will be given 3 lines of input – student name, age and average grade. Your task is to print all the info about
//    the student in the following format: "Name: {student name}, Age: {student age}, Grade: {student grade}".
//

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String studentName = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        double grade = Double.parseDouble(reader.readLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", studentName, age, grade);
    }
}
