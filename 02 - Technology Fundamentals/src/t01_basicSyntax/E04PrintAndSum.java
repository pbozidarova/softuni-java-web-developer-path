package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E04PrintAndSum {

//    Write a program to display numbers from given start to given end and their sum. All the numbers will be integers.
//    On the first line you will receive the start number, on the second the end number.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int startNumber = Integer.parseInt(reader.readLine());
        int endNumber = Integer.parseInt(reader.readLine());
        int sum = 0;

        while (startNumber <= endNumber){
            System.out.print(startNumber + " ");
            sum += startNumber;
            startNumber++;
        }

        System.out.println("\nSum: " + sum);

    }
}
