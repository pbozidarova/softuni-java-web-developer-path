package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E8_BeerKegs {
//    Write a program, which calculates the volume of n beer kegs. You will receive in total 3 * n lines. Each three lines will hold information for a single keg. First up is the model of the keg, after that is the radius of the keg, and lastly is the height of the keg.
//    Calculate the volume using the following formula: π * r^2 * h.
//    At the end, print the model of the biggest keg.

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in)
                );
        int n = Integer.parseInt(reader.readLine());
        double maxVolume = 0;
        String maxModel = "";

        for (int i = 0; i < n ; i++) {
            String model = reader.readLine();
            double r = Double.parseDouble(reader.readLine());
            int h = Integer.parseInt(reader.readLine());
            double volume = Math.PI * Math.pow(r, 2) * h;

            if (volume > maxVolume) {
                maxVolume = volume;
                maxModel = model;
            }

        }
        System.out.println(maxModel);
    }
}
