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

//        String primeKid = kidsQueue.getFirst();
        int count = 0;
        while (kidsQueue.size() > 1){
            count++;
            for (int i = 1; i <= passes; i++) {
                String kid = kidsQueue.peek();
                if(i != passes) {
                    kidsQueue.offer(kidsQueue.poll());
                    continue;
                }
                if (isPrimeCycle(count)){
                    System.out.println("Prime " + kid);
//                    kidsQueue.offer(kidsQueue.poll());
                }else {
                    System.out.println("Removed " + kidsQueue.poll());
                }
            }

        }

        System.out.println( "Last is " + kidsQueue.poll());
    }

    private static boolean isPrimeCycle(int n) {
        // Check if number is less than equal to 1
        if (n <= 1)
            return false;

        // Check if number is 2
        else if (n == 2)
            return true;

        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

}

