package A03_SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class E14DragonArmy {

//    Heroes III is the best game ever. Everyone loves it and everyone plays it all the time. Stamat is no exclusion
//    to this rule. His favorite units in the game are all types of dragons – black, red, gold, azure etc…
//    He likes them so much that he gives them names and keeps logs of their stats: damage, health and armor.
//    The process of aggregating all the data is quite tedious, so he would like to have a program doing it.
//    Since he is no programmer, it’s your task to help him
//    You need to categorize dragons by their type. For each dragon, identified by name, keep information
//    about his stats. Type is preserved as in the order of input, but dragons are sorted alphabetically by name.
//    For each type, you should also print the average damage, health and armor of the dragons. For each dragon,
//    print his own stats.

//    There may be missing stats in the input, though. If a stat is missing you should assign it default values.
//    Default values are as follows: health 250, damage 45, and armor 10. Missing stat will be marked by null.
//    The input is in the following format {type} {name} {damage} {health} {armor}. Any of the integers may be
//    assigned null value. See the examples below for better understanding of your task.
//    If the same dragon is added a second time, the new stats should overwrite the previous ones.
//    Two dragons are considered equal if they match by both name and type.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");

            String type = tokens[0];
            String name = tokens[1];

            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);

            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);

            int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            if(!dragons.containsKey(type)){
                dragons.put(type, new TreeMap<>(){{
                    put(name, new int[]{damage, health, armor});
                }});
            }else {
                if(!dragons.get(type).containsKey(name)){
                    dragons.get(type).put(name, new int[]{damage, health, armor});
                }else {
                    dragons.get(type).get(name)[0] = damage;
                    dragons.get(type).get(name)[1] = health;
                    dragons.get(type).get(name)[2] = armor;
                }
            }
        }

        dragons.entrySet().forEach(entry -> {

            int[] aggregatedData = new int[3];
            StringBuilder builder = new StringBuilder();


            entry.getValue()
                    .entrySet()
                    .stream()
                    .forEach(dragon -> {
                        int damage = dragon.getValue()[0];
                        int health = dragon.getValue()[1];
                        int armor = dragon.getValue()[2];

                        aggregatedData[0] += damage;
                        aggregatedData[1] += health;
                        aggregatedData[2] += armor;

                        String outputLine = String.format("-%s -> damage: %d, health: %d, armor: %d",
                                                            dragon.getKey(),
                                                            dragon.getValue()[0],
                                                            dragon.getValue()[1],
                                                            dragon.getValue()[2]);

                        builder.append(outputLine).append(System.lineSeparator());
                    });

            double avgDamage = aggregatedData[0] / (1.0 * entry.getValue().size());
            double avgHealth = aggregatedData[1] / (1.0 * entry.getValue().size());
            double avgArmor = aggregatedData[2] / (1.0 * entry.getValue().size());

            System.out.println(
                    String.format("%s::(%.2f/%.2f/%.2f)", entry.getKey(), avgDamage, avgHealth, avgArmor));

            System.out.print(builder.toString());
        });



    }
}

