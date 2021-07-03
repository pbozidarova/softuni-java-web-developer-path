package A01_StackAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class L01History {

    //    Write a program which takes 2 types of browser instructions:
//•	Normal navigation: a URL is set, given by a string
//•	The string "back" that sets the current URL to the last set URL
//    After each instruction the program should print the current URL. If the back instruction can’t be executed, print
//    "no previous URLs". The input ends with "Home" command, then simply you have to stop the program.


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = "";

        while (!"Home".equalsIgnoreCase(input = reader.readLine())){
            if(!"back".equalsIgnoreCase(input)){
                stack.push(input);
                System.out.println(input);
            }else {
                if(stack.size() > 1){
                    stack.pop();
                    System.out.println(stack.peek());
                }else {
                    System.out.println("no previous URLs");
                }
            }
        }
    }
}
