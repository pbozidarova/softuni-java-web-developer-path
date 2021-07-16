package A03_SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E04CountSymbols {

//    Write a program that reads some text from the console and counts the occurrences of each character in it.
//    Print the results in alphabetical (lexicographical) order.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        TreeMap<Character, Integer> symbolsCount = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            symbolsCount.putIfAbsent(symbol, 0);
            symbolsCount.put(symbol, symbolsCount.get(symbol) + 1);
        }

        for (Map.Entry<Character, Integer> keyValPair : symbolsCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", keyValPair.getKey(), keyValPair.getValue());
        }
    }
}
