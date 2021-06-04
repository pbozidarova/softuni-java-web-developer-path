package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L02ConvertPoundsToDollars {

//    Write a program that converts British pounds to US dollars formatted to 3th decimal point.
//    1 British Pound = 1.31 Dollars

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        System.out.printf("%.3f", Double.parseDouble(reader.readLine()) * 1.31);

    }

}
