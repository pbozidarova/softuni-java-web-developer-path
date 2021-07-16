package A03_SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L04CountRealNumbers {
//    Write a program that counts the occurrence of real numbers. The input is a single line with real numbers
//    separated by spaces. Print the numbers in the order of appearance. All numbers must be formatted to one
//    digit after the decimal point.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split("\\s+");

        Map<Double, Integer> result = new LinkedHashMap<>();

        for (String inputElement : input) {
            Double key = Double.parseDouble(inputElement);
            if(!result.containsKey(key)){
                result.put(key, 0);
            }
            result.put(key, result.get(key) + 1);
        }

        for (Map.Entry<Double, Integer> kvp : result.entrySet()) {
            System.out.println(String.format("%.1f -> %s", kvp.getKey(), kvp.getValue()));
        }
    }
}
