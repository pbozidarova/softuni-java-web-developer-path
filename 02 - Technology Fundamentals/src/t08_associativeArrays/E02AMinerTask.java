package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E02AMinerTask {
//    You are given a sequence of strings, each on a new line. Every odd line on the console is representing a resource
//    (e.g. Gold, Silver, Copper, and so on), and every even – quantity.
//    Your task is to collect the resources and print them each on a new line.
//    Print the resources and their quantities in format: {resource} –> {quantity}

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        String input = "";

        while(!"stop".equals(input = reader.readLine())){
            String res = input;
            int quantity = Integer.parseInt(reader.readLine());

            if(!resources.containsKey(res)){
                resources.put(res, quantity);
            }else{
                resources.put(res, resources.get(res) + quantity);
            }

        }

        resources.entrySet().forEach(e -> {
            System.out.println(String.format("%s -> %d", e.getKey(), e.getValue()));
        });
    }
}
