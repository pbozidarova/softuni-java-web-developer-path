package A01_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L06HotPotato {

//    Hot potato is a game in which children form a circle and start passing a hot potato. The counting starts
//    with the fist kid. Every nth toss the child left with the potato leaves the game. When a kid leaves the game,
//    it passes the potato forward. This continues repeating until there is only one kid left.
//    Create a program that simulates the game of Hot Potato.  Print every kid that is removed from the circle.
//    In the end, print the kid that is left last.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(kidsQueue::offer);

        int passes = Integer.parseInt(scanner.nextLine());

        while (kidsQueue.size() > 1){
            for (int i = 1; i <= passes; i++) {
                String kid = kidsQueue.poll();
                if(i == passes){
                    System.out.println("Removed " + kid);
                }else {
                    kidsQueue.offer(kid);
                }
            }
        }

        System.out.println( "Last is " + kidsQueue.poll());
    }
}
