package t04_methods;

import java.util.Scanner;

public class E09PalindromeIntegers {
//    A palindrome is a number which reads the same backward as forward, such as 323 or 1001. Write a program which reads a positive integer numbers until you receive "End", for each number print whether the number is palindrome or not.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while(!input.equals("END")) {
            palindromeChecker(input);
            input = scanner.nextLine();
        }
    }

    private static void palindromeChecker(String input) {
        int rotations = input.length() / 2;
        int count = 0;
        for (int i = 0; i < rotations ; i++) {
            if(input.charAt(i) == input.charAt(input.length()-i-1)){
                count++;
            }
        }
        if (count == rotations) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }

}
