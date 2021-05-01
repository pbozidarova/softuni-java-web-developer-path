package techFinal_14042019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class e2_ {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap <String, List<String>> storeWithItems = new LinkedHashMap<>();
        String input = "";

        while(!"END".equals(input = reader.readLine())){
            String command = input.split("->")[0];
            String store = input.split("->")[1];

            if(command.equals("Add")) {
                String[] items = input.split("->")[2].split(",");
                if(!storeWithItems.containsKey(store))
                    storeWithItems.put(store, new ArrayList<>() );
                    for (int i = 0; i < items.length ; i++) {
                        storeWithItems.get(store).add(items[i]);
                    }
            } else if(command.equals("Remove")){
                storeWithItems.remove(store);
            }
        }

        System.out.println("Stores list:");
        storeWithItems.entrySet().stream()
                .sorted((e1,e2) -> {
                    int sort = Integer.compare(e2.getValue().size(),e1.getValue().size());
                    if(sort == 0){
                        sort = e2.getKey().compareTo(e1.getKey());
                    }
                    return sort;
                })
                .forEach(kvp -> {
                    System.out.println(kvp.getKey());
                    kvp.getValue().stream().forEach(e -> System.out.println(String.format("<<%s>>", e)));

                });

    }
}
