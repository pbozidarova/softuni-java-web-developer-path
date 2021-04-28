package t03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E04ArrayRotation {
//  Write a program that receives an array and number of rotations you have to perform (first element goes at the end)
//  Print the resulting array.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] array1 = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());
        String[] array2 = new String[array1.length];

        if (n > array1.length) n = n % array1.length;

        for (int i = 0; i < n ; i++) {
            array2[array1.length-n+i] = array1[i];
        }

        for (int i = 0; i < array1.length-n; i++) {
            array2[i] = array1[i+n];
        }

        for (int i = 0; i < array2.length ; i++) {
            System.out.print(array2[i] + " ");
        }
    }


}
