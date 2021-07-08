package A01_StackAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class E01ReverseNumbersWithAStack {
//    Write a program that reads N integers from the console and reverses them using a stack.
//    Use the ArrayDeque<Integer>class. Just put the input numbers in the stack and pop them.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );
        ArrayDeque<String> numbersStack = new ArrayDeque<>();

        Arrays.stream(reader.readLine()
                .split("\\s+"))
                .forEach(numbersStack::push);

//        numbersStack.forEach(num -> System.out.print(num + " "));

        while (numbersStack.size() > 0){
            System.out.print(numbersStack.pop() + " ");
        }
    }


}
