package t03_arrays;

import java.util.Scanner;

public class E08MagicSum {
//  Write a program, which prints all unique pairs in an array of integers whose sum is equal to a given number.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numbers.length ; i++) {
            for (int j = i+1; j < numbers.length ; j++) {
                if (Integer.parseInt(numbers[i]) + Integer.parseInt(numbers[j]) == n){
                    System.out.println(numbers[i] + " " + numbers[j]);
                }
            }
        }
    }
}
