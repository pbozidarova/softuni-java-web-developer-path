package T03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class L06EqualArrays {
//  Read two arrays and print on the console whether they are identical or not.
//  Arrays are identical if their elements are equal. If the arrays are identical
//  find the sum of the first one and print on the console following message:
//  "Arrays are identical. Sum: {sum}", otherwise find the first index where the arrays
//  differ and print on the console following message: "Arrays are not identical.
//  Found difference at {index} index."
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        int[] firstArray = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArray = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        StringBuilder result = new StringBuilder();
        String notIdentical =  "Arrays are not identical. Found difference at %d index.";
        String identical = "Arrays are identical. Sum: %d";
        boolean areIdentical = true;

        if(firstArray.length != secondArray.length){
            result.append(String.format(notIdentical, firstArray.length));
        }else {
            for (int i = 0; i < firstArray.length; i++) {
                if(firstArray[i] != secondArray[i]){
                    result.append(String.format(notIdentical, i));
                    areIdentical = false;
                    break;
                }
            }
        }

        if(areIdentical) result.append(String.format(identical, Arrays.stream(firstArray).sum()));

        System.out.println(result);
    }
}
