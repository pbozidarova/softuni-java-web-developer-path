package T03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E03ZigZag {
//  Write a program which creates 2 arrays. You will be given an integer n. On the next n lines you get 2 integers.
//  Form 2 arrays as shown below.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[] arr1 = new String[n];
        String[] arr2 = new String[n];

        for (int i = 0; i < n ; i++) {
            String[] input = reader.readLine().split(" ");
            if (i % 2 == 0) {
                arr1[i] = input[0];
                arr2[i] = input[1];
            }else{
                arr1[i] = input[1];
                arr2[i] = input[0];
            }
        }

        for (int i = 0; i < n ; i++) {
            System.out.print(arr1[i] +" ");
        }

        for (int i = 0; i < n ; i++) {
            System.out.print(arr2[i] +" ");
        }
    }
}
