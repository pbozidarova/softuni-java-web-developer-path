package A03_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E07FixEmails {

//    You are given a sequence of strings, each on a new line, unitll you receive “stop” command.
//    First string is a name of a person. On the second line you receive his email. Your task is to collect
//    their names and emails, and remove emails whose domain ends with "us", "uk" or “com” (case insensitive).
//    Print: {name} – > {email}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        while (!"stop".equalsIgnoreCase(name)){
            String email = scanner.nextLine();

            if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")){
                emails.putIfAbsent(name, email);
            }

            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.println(
                    String.format("%s -> %s", entry.getKey(), entry.getValue())
            );
        }
    }
}
