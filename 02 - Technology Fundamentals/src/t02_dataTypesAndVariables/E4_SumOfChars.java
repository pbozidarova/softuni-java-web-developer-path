package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E4_SumOfChars {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int sum = 0;
        while (n-- > 0){
            sum += reader.readLine().charAt(0);
        }
        System.out.println("The sum equals: " + sum);
    }
}
