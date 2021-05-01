package techDemoPrep_06042019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class e1_Dictionary {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap <String, List<String>> dictionary = new LinkedHashMap<>();

        String[] input = reader.readLine().split(" \\| ");

        for (int i = 0; i < input.length; i++) {
            String word = input[i].split(": ")[0];
            String meaning = input[i].split(": ")[1];

            if(!dictionary.containsKey(word)){
                dictionary.put(word, new ArrayList<>());
                dictionary.get(word).add(meaning);
            } else {
                dictionary.get(word).add(meaning);
            }
        }

        String[] words = reader.readLine().split(" \\| ");
        for (int i = 0; i < words.length ; i++) {
            if(dictionary.containsKey(words[i])){
                System.out.println(words[i]);
                dictionary.get(words[i]).stream()
                        .sorted((p1,p2)-> {
                            int sort = Integer.compare(p2.length(), p1.length());
                            return sort;
                        })
                        .forEach(e1 -> {
                            System.out.println(" -"+e1);
                        });
            }
        }

        String command = reader.readLine();

        if(command.equals("End")) {
            return;
        } else{
            dictionary.entrySet().stream()
                    .sorted((e1,e2) -> e1.getKey().compareTo(e2.getKey()))
                    .forEach(kvp -> {
                        System.out.print(kvp.getKey()+" ");
                    });
        }

    }
}
