package t08_associativeArrays;

import java.util.*;

public class L03OddOccurrences {

//    Write a program that extracts from a given sequence of words all elements that
//    present in it odd number of times (case-insensitive).
//            •	Words are given in a single line, space separated.
//            •	Print the result elements in lowercase, in their order of appearance.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputWords = scanner.nextLine().split("\\s+");
        Map<String, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < inputWords.length; i++) {
            String word = inputWords[i].toLowerCase();
            occurrences.putIfAbsent(word, 0);
            occurrences.put(word, occurrences.get(word) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> pair : occurrences.entrySet()) {
            if(pair.getValue() % 2 != 0){
                result.add(pair.getKey());
            }
        }
        System.out.println(String.join(", ", result));
    }
}
