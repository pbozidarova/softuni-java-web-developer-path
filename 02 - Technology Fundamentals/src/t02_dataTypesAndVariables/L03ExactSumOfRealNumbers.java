package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class L03ExactSumOfRealNumbers {

//    Write program to enter n numbers and calculate and print their exact sum (without rounding).

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int n = Integer.parseInt(reader.readLine());
        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i < n; i++) {
            BigDecimal input = new BigDecimal(reader.readLine());
            sum = sum.add(input);
        }

        System.out.println(sum);
    }
}
