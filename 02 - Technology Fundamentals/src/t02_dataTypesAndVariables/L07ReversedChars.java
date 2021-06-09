package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L07ReversedChars {
//    Write a program that takes 3 lines of characters and prints them in reversed order with a space between them.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        char f = reader.readLine().charAt(0);
        char s = reader.readLine().charAt(0);
        char t = reader.readLine().charAt(0);

        System.out.println(
                String.join(" ",
                    String.valueOf(t),
                    String.valueOf(s),
                    String.valueOf(f)
        ));


    }
}
