package t01_basicSyntax;

import java.util.Scanner;

public class L09_SumOfOddNumbers {
//    Write a program that prints the next n odd numbers (starting from 1) and on the
//    last row prints the sum of them.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int num = 1;
        int sum = 0;
        StringBuilder result = new StringBuilder();

        while (n > 0){
            if(num % 2 != 0){
                result.append(num).append(System.lineSeparator());
                sum += num;
                n--;
            }
            num++;
        }
        result.append("Sum: ").append(sum);
        System.out.println(result.toString());
    }

}
