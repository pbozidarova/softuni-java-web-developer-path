package t03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02_CommonElements {
//  Write a program, which prints common elements in two arrays.
//  You have to compare the elements of the second array to the elements of the first.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String[] first = reader.readLine().split(" ");
        String[] second = reader.readLine().split(" ");

//        for (int i = 0; i < second.length; i++) {
//            for (int j = 0; j < first.length; j++) {
//                if (second[i].equals(first[j])) System.out.print(second[i]+" ");
//            }
//
//        }

        String[] output = new String[30];

        int index = 0;
        for (int i = 0; i < second.length; i++) {
            for (int j = 0; j < first.length; j++) {
                if(second[i].equals(first[j])){
                    output[index++] = second[i];
                }
            }
        }

        for (String s : output) {
            if(s != null){
                System.out.println(s + " ");
            }
        }

    }
}
