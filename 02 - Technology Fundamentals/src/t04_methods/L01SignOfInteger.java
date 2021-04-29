package t04_methods;

import java.util.Scanner;

public class L01SignOfInteger {
//    Create a method that prints the sign of an integer number.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        checkSign(number);
    }

    public static void checkSign( int number ){

        if (number < 0){
            System.out.printf("The number %d is negative.", number);
        } else if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else {
            System.out.println("The number 0 is zero.");
        }
    }
}
