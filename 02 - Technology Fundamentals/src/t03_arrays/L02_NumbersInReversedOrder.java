package t03_arrays;

import java.util.Scanner;

public class L02_NumbersInReversedOrder {
//  Read n numbers and print them in reverse order.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++){
            int number = Integer.parseInt(scanner.nextLine());

            array[i] = number;
        }

        StringBuilder result = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            result.append(array[i]).append(" ");
        }

        System.out.println(result);
    }
}
