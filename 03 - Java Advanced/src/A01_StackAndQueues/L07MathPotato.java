package A01_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class L07MathPotato {

//    Rework the previous problem so that a child is removed only on a composite (not prime) cycle (cycles start from 1)
//    If a cycle is prime, just print the child's name.
//    As before, print the name of the child that is left last.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(kidsQueue::offer);

        int passes = Integer.parseInt(scanner.nextLine());

        String primeKid = kidsQueue.getFirst();

        while (kidsQueue.size() > 1){

            for (int i = 1; i <= passes; i++) {
                String kid = kidsQueue.peek();
                if(i != passes) {
                    kidsQueue.offer(kidsQueue.poll());
                    continue;
                }
                if (primeKid.equals(kid)){
                    System.out.println("Prime " + kid);
//                    kidsQueue.offer(kidsQueue.poll());
                    primeKid = kidsQueue.getFirst();
                }else {
                    System.out.println("Removed " + kidsQueue.poll());
                }

            }
        }

        System.out.println( "Last is " + kidsQueue.poll());
    }
}
