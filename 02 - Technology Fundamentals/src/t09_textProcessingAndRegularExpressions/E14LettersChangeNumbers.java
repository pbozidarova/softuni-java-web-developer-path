package t09_textProcessingAndRegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E14LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String[] input = reader.readLine().split("\\s+");

        Pattern pattern = Pattern.compile("([A-Za-z])(\\d+)([A-Za-z])");

        String alfabet = " abcdefghijklmnopqrstuvwxyz";

        double sum = 0.0;

        for (String text : input) {
            Matcher mather = pattern.matcher(text);

            while (mather.find()){
                String leftSymbol = mather.group(1);
                double number = Double.parseDouble(mather.group(2));
                String rightSymbol = mather.group(3);

                if(leftSymbol.equals(leftSymbol.toLowerCase())){
                    number *= alfabet.indexOf(leftSymbol.toLowerCase());
                }else {
                    if(number != 0){
                        number /= alfabet.indexOf(leftSymbol.toLowerCase());
                    }
                }

                if(rightSymbol.equals(rightSymbol.toLowerCase())){
                    number += alfabet.indexOf(rightSymbol.toLowerCase());
                }else {
                    number -= alfabet.indexOf(rightSymbol.toLowerCase());
                }

                sum += number;
            }
        }

        System.out.println(String.format("%.2f", sum));
    }
}
