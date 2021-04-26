package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2_SumDigits {
//    You will be given a single integer. Your task is to find the sum of its digits.
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        String  n = reader.readLine();
        int sum = 0;
//        for (int i = 0; i < n.length() ; i++) {
//            sum += Integer.parseInt(String.valueOf(n.charAt(i)));
//        }
        int number = Integer.parseInt(n);
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }

        System.out.println(sum);

    }



}
