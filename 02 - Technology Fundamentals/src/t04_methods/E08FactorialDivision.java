package t04_methods;

import java.util.Scanner;

public class E08FactorialDivision {
//    Read two integer numbers. Calculate factorial of each number. Divide the first result by the second and print the division formatted to the second decimal point.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long numb1 = Integer.parseInt(scanner.nextLine());
        long numb2 = Integer.parseInt(scanner.nextLine());
        if (numb1 == 0) numb1 =1;
        if (numb2 == 0) numb2 =1;

        div(fact(numb1), fact(numb2));

    }

    private static double fact(double numb1) {
        double result = 1;
        for (int i = 1; i <= numb1; i++) {
            result *= i;
        }
        return result;
    }

    private static void div(double numb1, double numb2) {
        System.out.printf("%.2f", numb1/numb2);
    }

}
