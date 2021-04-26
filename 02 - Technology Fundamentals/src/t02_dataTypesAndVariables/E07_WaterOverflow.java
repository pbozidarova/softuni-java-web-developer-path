package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E07_WaterOverflow {
//  You have a water tank with capacity of 255 liters. On the next n lines, you will receive liters of water, which you have to pour in your tank. If the capacity is not enough, print “Insufficient capacity!” and continue reading the next line. On the last line, print the liters in the tank.
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(System.in)
                );

        int n = Integer.parseInt(reader.readLine());
        int capacity = 255;

        int sum = 0;
        for (int i = 0; i < n ; i++) {
            int quantity = Integer.parseInt(reader.readLine());
            if ( sum + quantity > capacity ) {
                System.out.println("Insufficient capacity!");
            } else sum += quantity;
        }
        System.out.println(sum);
    }
}
