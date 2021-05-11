package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E09ForceBook {
//    The force users are struggling to remember which side are the different forceUsers from, because they switch
//    them too often. So you are tasked to create a web application to manage their profiles. You should store
//    information for every unique forceUser, registered in the application.
//    You will receive several input lines in one of the following formats:
//    {forceSide} | {forceUser}
//    {forceUser} -> {forceSide}
//    The forceUser and forceSide are strings, containing any character.
//    If you receive forceSide | forceUser you should check if such forceUser already exists, and if not,
//    add him/her to the corresponding side.
//    If you receive a forceUser -> forceSide you should check if there is such forceUser already and if so,
//    change his/her side. If there is no such forceUser, add him/her to the corresponding forceSide,
//    treating the command as new registered forceUser.
//    Then you should print on the console: "{forceUser} joins the {forceSide} side!"
//    You should end your program when you receive the command "Lumpawaroo". At that point you should print
//    each force side, ordered descending by forceUsers count, than ordered by name.
//    For each side print the forceUsers, ordered by name.
//    In case there are no forceUsers in a side, you shouldn`t print the side information.

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Set<String>> forceBook = new LinkedHashMap<>();

        String input = "";

        while (!"Lumpawaroo".equals(input = reader.readLine())) {
            String[] data = Arrays.stream(input.split("\\s+\\|\\s+|\\s+->\\s+")).toArray(String[]::new);

            if (input.contains("|")) {
                String forceSiDe = data[0];
                String forceUser = data[1];

                if (!forceBook.containsKey(forceSiDe)) {
                    forceBook.put(forceSiDe, new TreeSet<>());
                }

                boolean found = false;
                for (Map.Entry<String, Set<String>> kvp : forceBook.entrySet()) {
                    if (kvp.getValue().contains(forceUser)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    forceBook.get(forceSiDe).add(forceUser);
                }
            } else {
                String forceSiDe = data[1];
                String forceUser = data[0];

                forceBook.forEach((key, value) -> value.remove(forceUser));

                if (!forceBook.containsKey(forceSiDe)) forceBook.put(forceSiDe, new TreeSet<>());
                forceBook.get(forceSiDe).add(forceUser);

                System.out.printf("%s joins the %s side!\n", forceUser, forceSiDe);
            }

        }

        forceBook
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                }).forEach(kvp -> {

            System.out.println(
                    String.format(
                            "Side: %s, Members: %d", kvp.getKey(), kvp.getValue().size()));
            kvp.getValue().forEach(u -> {
                System.out.println(String.format("! %s", u));
            });
        });

    }
}
