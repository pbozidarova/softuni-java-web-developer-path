package t04_methods;

import java.util.Scanner;

public class E01SmallestOfThreeNumbers {
//    Write a method to print the smallest of three integer numbers. Use appropriate name for the method.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        smallestOfThreeNumbers(first,second,third);
    }

    static void smallestOfThreeNumbers(int first, int second, int third){
//        int compareN = Integer.MAX_VALUE;
//
//        if (first < compareN) {
//            compareN = first;
//        }
//        if (second < compareN){
//            compareN = second;
//        }
//        if (third < compareN) {
//            compareN = third;
//        }
//        System.out.println(compareN);

        int smaller = min(first, second);
        int smallest = min(smaller, third);

        System.out.println(smallest);

    }

    static int min(int first, int sec){
        return Math.min(first, sec);
    }
}
