package t03_arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class L04_ReverseAnArrayOfStrings {
//  Write a program to read an array of strings, reverse it and print its elements.
//  The input consists of a sequence of space separated strings. Print the output
//  on a single line (space separated).

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

//        StringBuilder result = new StringBuilder();
//        for (int i = input.length - 1; i >= 0; i--) {
//            result.append(input[i]).append(" ");
//        }
//        System.out.println(result.toString());

        for (int i = 0; i < input.length / 2; i++) {
            String temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
        System.out.println(String.join(" ", input));
    }
}
