package A01_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L04MatchingBrackets {
//    We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
//    Print the result back at the terminal.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
        String expr = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expr.length(); i++) {
            char openBracket = expr.charAt(i);
            if('(' == openBracket){
                stack.push(i);
            }else if(')' == openBracket){
                System.out.println(expr.substring(stack.pop(), i + 1));
            }
        }

    }
}
