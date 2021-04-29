package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E10TopNumber {
//    A top number is an integer that holds the following properties:
//            •	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
//            •	Holds at least one odd digit, e.g. 232, 707, 87578.
//    Write a program to print all master numbers in the range [1…n].

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int endNumber = Integer.parseInt(reader.readLine());

        sumDiv8(endNumber);
    }

    private static void sumDiv8(int endNumber) {

        for (int i = 1; i < endNumber ; i++) {
            int sum = 0;
            for (int j = 0; j < String.valueOf(i).length() ; j++) {
                int numb = Integer.parseInt("" + String.valueOf(i).charAt(j));
                sum += numb;
            }
            if(sum % 8 == 0 && oddNumb(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean oddNumb(int numb) {
        boolean flag = false;
        for (int i = 0; i < String.valueOf(numb).length() ; i++) {
            int digit = Integer.parseInt("" + String.valueOf(numb).charAt(i));
            if (digit % 2 != 0) flag =true;
        }
        return flag;
    }
}
