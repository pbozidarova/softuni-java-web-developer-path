package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E03LegendaryFarming {
//    You’ve beaten all the content and the last thing left to accomplish is own a legendary item. However,
//    it’s a tedious process and requires quite a bit of farming. Anyway, you are not too pretentious –
//    any legendary will do. The possible items are:
//            •	Shadowmourne – requires 250 Shards;
//•	Valanyr – requires 250 Fragments;
//•	Dragonwrath – requires 250 Motes;
//    Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as
//2 motes 3 ores 15 stones. Keep track of the key materials - the first that reaches the 250 mark wins the race.
// At that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes,
// ordered by quantity in descending order, then by name in ascending order, each on a new line. Finally,
// print the collected junk items, in alphabetical order.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards",0);
        keyMaterials.put("fragments",0);
        keyMaterials.put("motes",0);

        LinkedHashMap<String, Integer> junks = new LinkedHashMap<>();
        String winner = "";
        boolean flag = false;

        while(true) {
            String[] data = reader.readLine().split("\\s+");
            for (int i = 0; i < data.length; i+=2) {
                int quantity = Integer.parseInt(data[i]);
                String material = data[i+1].toLowerCase();

                if(!keyMaterials.containsKey(material)){
                    if(!junks.containsKey(material)){
                        junks.put(material,quantity);
                    }else{
                        junks.put(material, junks.get(material) + quantity);
                    }
                }else{
                    keyMaterials.put(material, keyMaterials.get(material)+quantity);
                    if(keyMaterials.get(material) >= 250){
                        keyMaterials.put(material, keyMaterials.get(material)-250);
                        winner = material;
                        flag = true;
                        break;
                    }
                }
            }

            if(flag) break;

        }

        if(winner.equals("shards") ){
            System.out.println("Shadowmourne obtained!");
        }else if(winner.equals("motes")){
            System.out.println("Dragonwrath obtained!");
        }else if(winner.equals("fragments")){
            System.out.println("Valanyr obtained!");
        }

        keyMaterials.entrySet().stream().sorted((e1,e2) -> {
            int sort = Integer.compare(e2.getValue(), e1.getValue());
            if(sort == 0){
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).forEach( e-> {
            System.out.println(String.format("%s: %d", e.getKey(), e.getValue()));
        });

        junks.entrySet().stream()
                .sorted((e1,e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), e.getValue()));
                });

    }
}
