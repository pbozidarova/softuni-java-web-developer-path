package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E06StrongNumber {

//    Write a program to check if a given number is a strong number or not. A number is strong if the sum of the
//    Factorial of each digit is equal to the number. For example 145 is a strong number, because 1! + 4! + 5! = 145.
//    Print "yes" if the number is strong and "no" if the number is not strong.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String number = reader.readLine();
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
           sum += calculateFactorial(Integer.parseInt(String.valueOf(number.charAt(i))));
        }

        if(Integer.parseInt(number) == sum){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }

    private static int calculateFactorial(int number) {

        int factorial = 1;

        while (number > 0){
            factorial *= number;
            number--;
        }

        return factorial;
    }

}
