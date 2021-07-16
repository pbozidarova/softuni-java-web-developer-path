package A03_SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02SetsOfElements {

//    On the first line you are given the length of two sets n and m. On the next n + m lines there are n numbers
//    that are in the first set and m numbers that are in the second one. Find all non-repeating element that appears
//    in both of them, and print them in same order at the console:
//    Set with length n = 4: {1, 3, 5, 7}
//    Set with length m = 3: {3, 4, 5}
//    Set that contains all repeating elements -> {3, 5}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        LinkedHashSet<Integer> firstNumbers = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondNumbers = new LinkedHashSet<>();

        while (n-- > 0){
            int number = scanner.nextInt();
            firstNumbers.add(number);
        }

        while (m-- > 0){
            int number = scanner.nextInt();
            secondNumbers.add(number);
        }

        firstNumbers.retainAll(secondNumbers);

        firstNumbers.forEach(e -> System.out.print(e + " "));

    }
}
