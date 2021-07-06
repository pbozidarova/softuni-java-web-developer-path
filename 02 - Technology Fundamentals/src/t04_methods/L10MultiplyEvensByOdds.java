package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L10MultiplyEvensByOdds {
//    Create a program that reads an integer number and multiplies the sum of all its even digits by the sum
//    of all its odd digits:

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String n = reader.readLine();

        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < n.length(); i++) {
            int val = Integer.parseInt(String.valueOf(n.charAt(i)));

            if(val % 2 == 0){
                oddSum += val;
            }else {
                evenSum += val;
            }

        }

        System.out.println(oddSum * evenSum);

    }
}
