package t03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E05TopInteger {
//  Write a program to find all the top integers in an array. A top integer is an integer which is bigger
//  than all the elements to its right.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(" ");

        for (int i = 0; i < numbers.length ; i++) {
            int count = 0;
            int secondCount = 0;
            Boolean flag = true;
            for (int j = i+1; j < numbers.length; j++) {
                secondCount++;
                if (Integer.parseInt(numbers[i]) <= Integer.parseInt(numbers[j])){
                    flag = false;
                    break;
                }
            }
            if (flag ) System.out.print(numbers[i] +" ");
        }

    }

}
