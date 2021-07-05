package A01_StackAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class L08BrowserHistoryUpgrade {
//    Extend "Browser History" with a "forward" instruction which visits URLs that were navigated away from by "back"
//    Each forward instruction visits the next most-recent such URL. If a normal navigation happens, all potential
//    forward URLs are removed until a new back instruction is given If the forward instruction can’t be executed, print
//    "no next URLs".

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        String input = "";

        while (!"Home".equalsIgnoreCase(input = reader.readLine())){
            if(!"back".equalsIgnoreCase(input) && !"forward".equalsIgnoreCase(input)){
                stack.push(input);
                System.out.println(input);
                forwardStack.clear();
            } else {
                if("back".equalsIgnoreCase(input)){
                    if(stack.size() > 1){
                        forwardStack.push(stack.pop());
                        System.out.println(stack.peek());
                    }else {
                        System.out.println("no previous URLs");
                    }
                }else {
                    if(forwardStack.size() > 0){
                        stack.push(forwardStack.peek());
                        System.out.println(forwardStack.pop());
                    }else {
                        System.out.println("no next URLs");
                    }
                }
            }
        }

    }
}
