package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L09GreaterOfTwoValues {
//    You are given two values of the same type as input. The values can be of type int, char of String.
//    Create a method getMax() that returns the greater of the two values:

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String type = reader.readLine();
        String firstVal = reader.readLine();
        String secondVal = reader.readLine();

        switch ( type ){
            case "int":
                System.out.println(
                        getMax(Integer.parseInt(firstVal), Integer.parseInt(secondVal))
                );
                break;
            case "char":
                System.out.println(
                        getMax(firstVal.charAt(0), secondVal.charAt(0))
                );
                break;
            case "string":
                System.out.println(
                        getMax(firstVal, secondVal)
                );
                break;
            default:
                break;
        }

    }

    static int getMax(int f, int s) {
        return f >= s ? f : s;
    }
    static char getMax(char f, char s) {
        return f >= s ? f : s;
    }
    static String getMax(String f, String s) {
        return f.compareTo(s) >= 0 ? f : s;
    }

}
