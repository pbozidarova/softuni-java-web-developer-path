package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ME05DragonArmy {
//    Heroes III is the best game ever. Everyone loves it and everyone plays it all the time. Stamat is no exclusion
//    to this rule. His favorite units in the game are all types of dragons – black, red, gold, azure etc… He likes
//    them so much that he gives them names and keeps logs of their stats: damage, health and armor. The process of
//    aggregating all the data is quite tedious, so he would like to have a program doing it. Since he is no programmer,
//    it’s your task to help him
//
//    You need to categorize dragons by their type. For each dragon, identified by name, keep information about
//    his stats. Type is preserved as in the order of input, but dragons are sorted alphabetically by name.
//    For each type, you should also print the average damage, health and armor of the dragons.
//    For each dragon, print his own stats.
//
//    There may be missing stats in the input, though. If a stat is missing you should assign it default values.
//    Default values are as follows: health 250, damage 45, and armor 10. Missing stat will be marked by null.
//
//    The input is in the following format {type} {name} {damage} {health} {armor}. Any of the integers may be
//    assigned null value. See the examples below for better understanding of your task.
//    If the same dragon is added a second time, the new stats should overwrite the previous ones.
//    Two dragons are considered equal if they match by both name and type.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, TreeMap<String, List<Double>>> dragonsType = new LinkedHashMap<>();

        while (n-- > 0){
            String[] data = reader.readLine().split("\\s+");

            String type = data[0];
            String name = data[1];
            double damage = data[2].equals("null") ? 45 : Double.parseDouble(data[2]);
            double health = data[3].equals("null") ? 250 : Double.parseDouble(data[3]);
            double armour = data[4].equals("null") ? 10 : Double.parseDouble(data[4]);

            List<Double> stats = new ArrayList<>();
            stats.add(damage);
            stats.add(health);
            stats.add(armour);

            if(!dragonsType.containsKey(type)){
                dragonsType.put(type, new TreeMap<>());
            }

            if(!dragonsType.get(type).containsKey(name)){
                dragonsType.get(type).put(name, new ArrayList<>());
            }

            dragonsType.get(type).get(name).clear();
            dragonsType.get(type).get(name).addAll(stats);
        }

        dragonsType.forEach((key, value) -> {
            double armour = 0;
            double health = 0;
            double damage = 0;

            TreeMap<String, List<Double>> dragonsWithStats = value;

            for (List<Double> stats : value.values()) {
                damage += stats.get(0);
                health += stats.get(1);
                armour += stats.get(2);
            }


            System.out.println(
                    String.format("%s::(%.2f/%.2f/%.2f)",
                            key,
                            damage / dragonsWithStats.size(),
                            health / dragonsWithStats.size(),
                            armour / dragonsWithStats.size()
            ));

            dragonsWithStats.forEach((d, s) -> {
                System.out.println(
                        String.format(
                                "-%s -> damage: %.0f, health: %.0f, armor: %.0f",
                                d,
                                s.get(0),
                                s.get(1),
                                s.get(2)
                        )
                );
            });
        });
    }

}
