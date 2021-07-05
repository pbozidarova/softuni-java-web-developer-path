package A01_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Scanner;
import java.util.Stack;

public class L03DecimalToBinaryConverter {

//    Create a simple program that can convert a decimal number to its binary representation.
//    Implement an elegant solution using a Stack .
//    Print the binary representation back at the terminal.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimal == 0) stack.push(0);

        while (decimal != 0){
            stack.push(decimal % 2);
            decimal /= 2;
        }

        stack.forEach(System.out::print);
    }
}
