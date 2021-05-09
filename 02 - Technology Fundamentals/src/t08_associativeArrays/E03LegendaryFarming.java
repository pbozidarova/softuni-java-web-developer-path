package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E03LegendaryFarming {
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
