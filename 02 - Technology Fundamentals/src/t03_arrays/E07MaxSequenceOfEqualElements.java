package T03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E07MaxSequenceOfEqualElements {
//  Write a program that finds the longest sequence of equal elements in an array of integers. If several longest
//  sequences exist, print the leftmost one.
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < input.length; i++) {
            int currCont = 0;
            for (int j = i; j < input.length; j++) {
                if (input[i] == input[j]) {
                    currCont++;
                    if (currCont > maxCount) {
                        maxCount = currCont;
                        maxIndex = i;
                    }
                }else{
                    break;
                }
            }
        }

        for (int i = 0; i < maxCount; i++) {
            System.out.print(input[i + maxIndex] + " ");
        }
    }
}
