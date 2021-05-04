package techMidPrep_04112018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class e3_QuestJurnal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> journal = Arrays.stream(reader.readLine().split(", "))
                                                              .collect(Collectors.toList());

        String input = "";
        while(!"Retire!".equals(input = reader.readLine())){
            String[] quest = input.split(" - ");
            if(quest[0].equals("Start") && !journal.contains(quest[1])){
                journal.add(quest[1]);
            } else if(quest[0].equals("Complete") && journal.contains(quest[1])){
                journal.remove(quest[1]);
            } else if(quest[0].equals("Side Quest")){
                String[] sideQuest = quest[1].split(":");
                if(journal.contains(sideQuest[0]) && !journal.contains(sideQuest[1])){
                    journal.add(journal.indexOf(sideQuest[0])+1, sideQuest[1]);
                }
            } else if(quest[0].equals("Renew") && journal.contains(quest[1])){
                journal.remove(quest[1]);
                journal.add(quest[1]);
            }
        }

        System.out.println(journal.toString().replaceAll("[\\[\\]]", ""));

    }

}
