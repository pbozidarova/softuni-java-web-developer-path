package t06_objectsAndClasses;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class L03BigFactorial {
//  You will receive two numbers (0 to 1050), print their sum.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n ; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        System.out.println(result);
    }
}
