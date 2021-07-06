package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class L11MathOperations {
//    Write a method that receives two number and an operator, calculates the result and returns it.
//    You will be given three lines of input. The first will be the first number, the second one will be the
//    operator and the last one will be the second number. The possible operators are: / * + -

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        double firstNum = Double.parseDouble(reader.readLine());
        String operator = reader.readLine();
        double secondNum = Double.parseDouble(reader.readLine());


        System.out.println(new DecimalFormat("0.##").format(calculate(firstNum, operator, secondNum)));
    }

    private static double calculate(double firstNum, String operator, double secondNum) {
        double result = 0.0;
        switch (operator){
            case "/":
                result = firstNum / secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            default:
                break;
        }
        return result;
    }

}
