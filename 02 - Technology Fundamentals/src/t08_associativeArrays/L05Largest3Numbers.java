package t08_associativeArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L05Largest3Numbers {
//    Read a list of integers and print largest 3 of them. If there are less than 3, print all of them.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Arrays.stream(scanner.nextLine()
//                .split("\\s+"))
//                .map(Integer::parseInt)
//                .sorted((n1, n2) -> n2.compareTo(n1))
//                .limit(3)
//                .forEach(n -> System.out.print(n + " "));

        System.out.println(
                Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}
