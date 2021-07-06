package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class L04Calculations {
//    Write a program that receives a string on the first line (add, multiply, subtract, divide) and on the next
//    two lines receives two numbers. Create four methods (for each calculation) and invoke the right one depending
//    on the command. The method should also print the result (needs to be void)

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String command = reader.readLine();

        int firstN = Integer.parseInt(reader.readLine());
        int secondN = Integer.parseInt(reader.readLine());

        switch (command){
            case "add" :
                addMethod(firstN, secondN);
                break;
            case "multiply":
                multiplyMethod(firstN, secondN);
                break;
            case "subtract":
                subtractMethod(firstN, secondN);
                break;
            case "divide":
                divideMethod(firstN, secondN);
                break;
            default:
                break;
        }
    }

    private static void divideMethod(int firstN, int secondN) {
        System.out.println(firstN / secondN);
    }

    private static void subtractMethod(int firstN, int secondN) {
        System.out.println(firstN - secondN);
    }

    private static void multiplyMethod(int firstN, int secondN) {
        System.out.println(firstN * secondN);
    }

    private static void addMethod(int firstN, int secondN) {
        System.out.println(firstN + secondN);
    }
}
