package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class E1_IntegerOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        int firstNumber= Integer.parseInt(reader.readLine());
        int secondNumber= Integer.parseInt(reader.readLine());
        int thirdNumber= Integer.parseInt(reader.readLine());
        int fourthNumber= Integer.parseInt(reader.readLine());

        int sum = firstNumber + secondNumber;
        int divide = sum / thirdNumber;
        int multiply = divide * fourthNumber;

        System.out.println(multiply);

    }
}
