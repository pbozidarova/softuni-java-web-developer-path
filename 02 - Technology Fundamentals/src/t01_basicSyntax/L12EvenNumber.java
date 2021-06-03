package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L12EvenNumber {

//    Take as an input an even number and print its absolute value.
//    If the number is odd, print "Please write an even number." and continue reading numbers.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int number = Integer.parseInt(reader.readLine());

        while (number % 2 != 0){
            System.out.println("Please write an even number.");
            number = Integer.parseInt(reader.readLine());
        }

        System.out.println("The number is: " + Math.abs(number));
    }
}
