package T03_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class L07CondenseArrayToNumber {
//  Write a program to read an array of integers and condense them by summing adjacent
//  couples of elements until a single integer is obtained. For example, if we have
//  3 elements {2, 10, 3}, we sum the first two and the second two elements and obtain
//  {2+10, 10+3} = {12, 13}, then we sum again all adjacent elements and obtain {12+13} = {25}.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int[] inputInts = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        while (inputInts.length > 2){
            int[] condensed = new int[inputInts.length -1];

            for (int i = 1; i < inputInts.length; i+=2) {
                condensed[i - 1] = inputInts[i] + inputInts[i - 1];
                if(i != inputInts.length -1){
                    condensed[i] = inputInts[i] + inputInts[i + 1];
                }
            }

            inputInts = condensed;
        }

        System.out.println(Arrays.stream(inputInts).sum());
    }
}
