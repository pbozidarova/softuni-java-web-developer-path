package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L10MultiplicationTable {
//
//    You will receive an integer as an input from the console. Print the 10 times table for this integer.

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int number = Integer.parseInt(reader.readLine());
        int count = 0;

        while (count++ < 10){
            System.out.printf("%d X %d = %d%n", number, count, number * count);
        }


    }
}
