package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L06CharsToString {

//    Write a program that reads 3 lines of input. On each line you get a single character.
//    Combine all the characters into one string and print it on the console.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        char f = reader.readLine().charAt(0);
        char s = reader.readLine().charAt(0);
        char t = reader.readLine().charAt(0);

        System.out.println( String.valueOf(f)
                + String.valueOf(s) + String.valueOf(t) );
    }
}
