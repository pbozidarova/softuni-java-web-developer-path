package A01_StackAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class E06BalancedParentheses {
//    Given a sequence consisting of parentheses, determine whether the expression is balanced.
//    A sequence of parentheses is balanced if every open parenthesis can be paired uniquely with a
//    closed parenthesis that occurs after the former. Also, the interval between them must be balanced.
//    You will be given three types of parentheses: (, {, and [.
//        {[()]} - This is a balanced parenthesis.
//        {[(])} - This is not a balanced parenthesis.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sequence = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean areBalanced = true;
        for (int i = 0; i < sequence.length(); i++) {
            char current = sequence.charAt(i);

            if(current == '{' || current == '(' || current == '['){
                stack.push(current);
            }else {
                if(stack.isEmpty()){
                    areBalanced = false;
                    break;
                }else{

                    char topElement = stack.pop();

                    if(current == '}' && topElement != '{') {
                        areBalanced = false;
                        break;
                    }else if(current == ')' && topElement != '('){
                        areBalanced = false;
                        break;
                    }else if(current == ']' && topElement != '['){
                        areBalanced = false;
                        break;
                    }
                }
            }
        }
        if(areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
