package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E10SoftUniExamResults {
//    Judge statistics on the last Programing Fundamentals exam was not working correctly, so you have the task to
//    take all the submissions and analyze them properly. You should collect all the submission and print the final
//    results and statistics about each language that the participants submitted their solutions in.
//    You will be receiving lines in the following format: "{username}-{language}-{points}" until you receive
//    "exam finished". You should store each username and his submissions and points.
//    You can receive a command to ban a user for cheating in the following format: "{username}-banned".
//    In that case, you should remove the user from the contest, but preserve his submissions in the total
//    count of submissions for each language.
//    After receiving "exam finished" print each of the participants, ordered descending by their max points,
//    then by username, in the following format:
//    Results:
//    {username} | {points}...
//    After that print each language, used in the exam, ordered descending by total submission count
//    and then by language name, in the following format:
//    Submissions:
//    {language} – {submissionsCount}...

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
