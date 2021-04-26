package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E8_BeerKegs {
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
