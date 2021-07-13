package A01_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E03MaximumElement {
//    You have an empty sequence, and you will be given N commands. Each command is one of the following types:
//            •	"1 X" - Push the element X into the stack.
//            •	"2" - Delete the element present at the top of the stack.
//            •	"3" - Print the maximum element in the stack.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            String command = tokens[0];

            switch (command){
                case "1":
                    int element = Integer.parseInt(tokens[1]);
                    numbers.push(element);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbers));
                    break;
//                    System.out.println(
//                            numbers.
//                                    stream()
//                                    .max(Integer::compareTo)
//                                    .get()
//                    );

                default: break;
            }

        }
    }
}
