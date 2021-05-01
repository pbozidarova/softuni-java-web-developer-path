package techFinal_16122018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class e1_Concert {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        String input = "";

        HashMap<String, List<String>> bandMembers = new LinkedHashMap<>();
        HashMap<String, Integer> bandTimes = new LinkedHashMap<>();
        System.out.println();
        while(!"start of concert".equals(input=reader.readLine())) {
            String command = input.split("; ")[0];
            String band = input.split("; ")[1];

            if (command.equals("Add")) {
                bandMembers.putIfAbsent(band, new ArrayList<>());
                String[] bandMembersInput = input.split("; ")[2].split(", ");
                for (int i = 0; i < bandMembersInput.length; i++) {
                    if (!bandMembers.get(band).contains(bandMembersInput[i])) {
                        bandMembers.get(band).add(bandMembersInput[i]);
                    }
                }
            } else if (command.equals("Play")) {
                Integer bandTime = Integer.parseInt(input.split("; ")[2]);
                bandTimes.putIfAbsent(band, 0);
                bandTimes.put(band, (bandTimes.get(band) + bandTime));
            }
        }
        input = reader.readLine();

        int sum = bandTimes.values().stream().mapToInt(p -> p).sum();
        System.out.println("Total time: " + sum);
        bandTimes.entrySet().stream()
                .sorted((e1,e2)-> {
                    int sort = Integer.compare(e2.getValue(),e1.getValue());
                    if(sort == 0){
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                }).forEach(kvp-> {
            System.out.println(String.format(
                    "%s -> %d", kvp.getKey(), kvp. getValue()
            ));
        });
        System.out.println(input);
        bandMembers.get(input).stream().forEach(e -> System.out.println(String.format("=> %s", e)));
    }
}
