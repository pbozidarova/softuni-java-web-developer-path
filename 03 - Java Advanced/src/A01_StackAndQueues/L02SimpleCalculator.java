package A01_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class L02SimpleCalculator {
//    Create a simple calculator that can evaluate simple expressions that will not hold any operator different
//    from addition and subtraction. There will not be parentheses or operator precedence.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String expr = scanner.nextLine();

        String[] els = expr.split("\\s+");

        for (int i = els.length - 1; i >= 0 ; i--) {
            stack.push(els[i]);
        }

        while (stack.size() > 1){
            int firstNum = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if("+".equalsIgnoreCase(op)){
                stack.push(firstNum + secondNum + "");
            }else {
                stack.push(firstNum - secondNum + "");
            }
        }

        System.out.println(stack.peek());
    }
}
