package t02_dataTypesAndVariables;

import java.util.Scanner;

public class L12RefactorSpecialNumbers {
//    You are given a working code that is a solution to Problem 9. Special Numbers. However, the variables are
//    improperly named, declared before they are needed and some of them are used for multiple things.
//    Without using your previous solution, modify the code so that it is easy to read and understand.

//    Hints
//•	Reduce the span of the variables by declaring them in the moment they receive a value, not before
//•	Rename your variables to represent their real purpose (example: "toe" should become isSpecialNum, etc.)
//•	Search for variables that have multiple purpose. If you find any, introduce a new variable


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int currentNumber = i;

            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }

            boolean isSpecial = (sum == 5) || (sum == 7) || (sum == 11);

            System.out.printf("%d -> %b%n", i, isSpecial ? "True" : "False");
        }

    }
}
