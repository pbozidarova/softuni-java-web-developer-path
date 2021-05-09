package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E10SoftUniExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> users = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> points = new LinkedHashMap<>();

        String input = "";

        while(!"exam finished".equals(input = reader.readLine())){
            String[] data = input.split("-");
            String usernames = data[0];
            String command = "";
            String language = "";
            int langPoints = 1;
            if(data[1].equals("banned")){
                command = data[1];
            }else{
                language = data[1];
                langPoints = Integer.parseInt(data[2]);
            }

            if(command.equals("banned")){
                users.remove(usernames);
                continue;
            }else{
                if(!users.containsKey(usernames)) {
                    users.putIfAbsent(usernames, langPoints);
                } else{
                    if(users.get(usernames) < langPoints)
                        users.put( usernames, langPoints);
                }
                if(!points.containsKey(language)) {
                    points.putIfAbsent(language, 1);
                }else{
                    points.put(language, points.get(language)+1);
                }
            }

        }
        System.out.println("Results:");
        users.entrySet().stream()
                .sorted((p1,p2) -> {
                    int sort = Integer.compare(p2.getValue(), p1.getValue());
                    if(sort == 0) {
                        sort = p1.getKey().compareTo(p2.getKey());
                    }
                    return sort;
                })
                .forEach(e -> {
                    System.out.println(e.getKey() + " | " +e.getValue());
                });

        System.out.println("Submissions:");
        points.entrySet().stream()
                .sorted((p1,p2)->{
                    int sort = Integer.compare(p2.getValue(), p1.getValue());
                    if(sort == 0) {
                        sort = p1.getKey().compareTo(p2.getKey());
                    }
                    return sort;
                })
                .forEach(e->{
                    System.out.println(e.getKey()+ " - " + e.getValue());
                });

    }
}
