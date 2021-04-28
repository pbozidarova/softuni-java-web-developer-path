package t07_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class E08CompanyUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        Map<String, LinkedHashSet<String>> collection = new TreeMap<>();

        String input = "";

        while (!"End".equals(input = reader.readLine())){
            String[] data = input.split(" -> ");
            String companyName = data[0];
            String id = data[1];

            collection.putIfAbsent(companyName, new LinkedHashSet<>());
            collection.get(companyName).add(id);
        }


        for (Map.Entry<String, LinkedHashSet<String>> kvp : collection.entrySet()) {
            System.out.println(String.format("%s", kvp.getKey()));
            kvp.getValue().stream().forEach(e -> System.out.println(String.format("-- %s", e)));
        }

        //   collection.entrySet()
        //           .stream()
        //           .forEach(e -> {
        //               System.out.println(e.getKey());
        //               e.getValue().stream()
        //                       .distinct()
        //                       .forEach(d -> {
        //                   System.out.println("-- " + d);
        //               });
        //           });
    }
}
