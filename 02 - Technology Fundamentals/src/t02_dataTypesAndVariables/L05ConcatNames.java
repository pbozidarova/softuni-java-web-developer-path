package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L05ConcatNames {

//    Read two names and a delimiter. Print the names joined by the delimiter.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String firstName = reader.readLine();
        String lastName = reader.readLine();
        String delimiter = reader.readLine();

        System.out.println(String.join(delimiter, firstName, lastName));

    }
}
