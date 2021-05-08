package t08_associativeArrays;

import java.util.*;

public class L02WordSynonyms {

//    Write a program which keeps a map with synonyms.
//    The key of the map will be the word. The value will be a list of all the synonyms
//    of that word. You will be given a number n. On the next 2 * n lines you will be
//    given a word and a synonym each on a separate line like this:
//            •	{word}
//            •	{synonym}
//    If you get the same word for second time, just add the new synonym to the list.
//    Print the words in the following format:
//    {word} - {synonym1, synonym2… synonymN}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> resMap = new LinkedHashMap<>();

        for (int i = 0; i < num; i++) {
            String key = scanner.nextLine();
            String value = scanner.nextLine();

            resMap.putIfAbsent(key, new ArrayList<>());
            resMap.get(key).add(value);
        }

        String patter = "%s - %s%n";

        for (Map.Entry<String, List<String>> kvp : resMap.entrySet()) {
            String key = kvp.getKey();
            String value = String.join(", ", kvp.getValue());

            System.out.printf(patter, key, value);
        }
    }
}
