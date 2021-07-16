package A03_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class E03PeriodicTable {

//    You are given an n number of chemical compounds. You need to keep track of all chemical elements used in
//    the compounds and at the end print all unique ones in ascending order:

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        while (n-- > 0){
            String[] inputElements = scanner.nextLine().split("\\s+");

            elements.addAll(Arrays.asList(inputElements));
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
