package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class L08MathPower {
//    Create a method that calculates and returns the value of a number raised to a given power:

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        double number = Double.parseDouble(reader.readLine());
        int power = Integer.parseInt(reader.readLine());

        System.out.println(new DecimalFormat("0.####").format(mathPower(number, power)));

    }

    private static double mathPower(double number, int power) {
        return Math.pow(number, power);
    }
}
