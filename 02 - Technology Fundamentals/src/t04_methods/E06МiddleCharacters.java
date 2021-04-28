package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E06МiddleCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String input = reader.readLine();

        midChar(input,input.length());
    }

    private static void midChar(String value, int length) {
        if (length % 2 == 0){
            System.out.print(value.charAt(length/2-1));
            System.out.println(value.charAt(length/2));
        }else{
            System.out.println(value.charAt(length/2));
        }
    }
}
