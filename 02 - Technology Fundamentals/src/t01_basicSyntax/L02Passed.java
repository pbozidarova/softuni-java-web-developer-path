package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L02Passed {

//    Write a program, which takes as an input a grade and prints "Passed!" if the grade is equal or more than 3.00.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        if(Double.parseDouble(reader.readLine()) >= 3.00){
            System.out.println("Passed!");
        }
    }
}
