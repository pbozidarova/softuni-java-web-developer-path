package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L10SpecialNumbers {

//    A number is special when its sum of digits is 5, 7 or 11.
//    Write a program to read an integer n and for all numbers in the range 1…n to print the number and if it is special or not (True / False).

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int n = Integer.parseInt(reader.readLine());
        List sumOfDigitsForSpecialNumber = Arrays.asList(5, 7, 11);

        for (int i = 1; i <= n; i++) {
            int sumOfDigits = 0;
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                sumOfDigits += Integer.parseInt(String.valueOf(String.valueOf(i).charAt(j)));
            }

            System.out.println(
                    String.format("%s -> %s",
                    i,
                    sumOfDigitsForSpecialNumber.contains(sumOfDigits) ? "True" : "False")
            );

        }
    }

}
