package t08_associativeArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L04WordFilter {
//    Read an array of strings, take only words which length is even. Print each word on a new line.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(w -> w.length() % 2 == 0 )
                .forEach(System.out::println);
    }
}
