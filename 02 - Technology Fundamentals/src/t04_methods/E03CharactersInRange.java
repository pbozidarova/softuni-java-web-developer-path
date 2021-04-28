package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E03CharactersInRange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        String firstChar = reader.readLine();
        String secondChar = reader.readLine();
        char start = firstChar.charAt(0);
        char end = secondChar.charAt(0);
        if (start < end ) {
            printChars(start, end);
        } else {
            printChars(end, start);
        }

    }

    private static void printChars(char str, char end) {
        for (int i = str+1; i < end; i++) {
            System.out.print((char)i + " ");
        }
    }
}
