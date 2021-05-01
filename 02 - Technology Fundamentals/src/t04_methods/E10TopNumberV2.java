package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E10TopNumberV2 {
//    A top number is an integer that holds the following properties:
//            •	Its sum of digits is divisible by 8, e.g. 8, 16, 88.
//            •	Holds at least one odd digit, e.g. 232, 707, 87578.
//    Write a program to print all master numbers in the range [1…n].

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        for (int i = 0; i < number; i++) {
            if(hasOneOddDigit(i) && isDigitDivisibleBy8(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean hasOneOddDigit(int number){
        String num = String.valueOf(number);

        for (int i = 0; i < num.length(); i++) {
            if(Integer.parseInt(String.valueOf(num.charAt(i))) % 2 == 1){
                return true;
            }
        }
        return false;
    }

    private static boolean isDigitDivisibleBy8(int number){
        int sum = 0;
        while (number > 0){
            sum += number %10;
            number /= 10;
        }

        return sum % 8 == 0;
    }
}
