package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L09CenturiesToMinutes {

//    Write program to enter an integer number of centuries and convert it to years, days, hours and minutes.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int centuries = Integer.parseInt(reader.readLine());

        System.out.println(
                String.format(
                        "%d centuries = %d years = %s days = %s hours = %s minutes",
                        centuries,
                        centuries * 100,
                        Math.round(centuries * 100 * 365.2422),
                        Math.round(centuries * 100 * 365.2422 * 24),
                        Math.round(centuries * 100 * 365.2422 * 24 * 60)
                )
        );
    }

}
