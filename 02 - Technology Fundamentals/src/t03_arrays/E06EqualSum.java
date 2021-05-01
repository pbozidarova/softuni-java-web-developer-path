package T03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E06EqualSum {
//  Write a program that determines if there exists an element in the array such that the sum of the elements on its
//  left is equal to the sum of the elements on its right. If there are no elements to the left / right, their sum is
//  considered to be 0. Print the index that satisfies the required condition or “no” if there is no such index.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        int [] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum1 = 0;
        int sum2 = 0;
        boolean flag = true;
        for (int i = 0; i < input.length ; i++) {
            for (int j = 0; j < i ; j++) {
                sum1 += input[j];
            }
            //if (i == input.length-1) break;
            for (int j = i+1; j < input.length; j++) {
                sum2 += input[j];
            }
            if (sum1 == sum2) {
                System.out.println(i);
                return;
            }
            sum1 = 0;
            sum2 = 0;
        }

        System.out.println("no");

    }
}
