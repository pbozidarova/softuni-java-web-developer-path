package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L01ConvertMetersToKilometers {

//    You will be given an integer that will be distance in meters.
//    Write a program that converts meters to kilometers formatted to the second decimal point.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        System.out.printf("%.2f", Double.parseDouble(reader.readLine()) / 1000);

    }

}
