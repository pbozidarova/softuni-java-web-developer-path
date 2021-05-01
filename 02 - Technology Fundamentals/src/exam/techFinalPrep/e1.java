package techFinalPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class e1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, HashMap<String, Integer>> listMap = new HashMap<>();

        listMap.put("BG", new HashMap<>());
        listMap.get("BG").put("Ivan", 20);

        listMap.put("EN", new HashMap<>());
        listMap.get("EN").put("Pesho", 15);
        listMap.get("EN").put("Maria", 15);
        listMap.get("EN").put("Gosho", 15);


        HashMap<String, Integer> sortedOuterKey = new HashMap<>();

        listMap.forEach((key, value) -> {
            HashMap<String, Integer> inner = listMap.get(key);

            sortedOuterKey.put(key, 0);
            inner.forEach((k,v) -> {
                    sortedOuterKey.put(key, sortedOuterKey.get(key)+v);
            });
        });

        sortedOuterKey.entrySet()
                .stream().sorted((e1,e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> {
                    System.out.println(e.getKey());

                    listMap.get(e.getKey()).forEach((key, value) ->  {
                        System.out.println(
                                String.format("-- %s -> %d", key, value)
                        );
                    });
                });

        System.out.println();
    }
}
