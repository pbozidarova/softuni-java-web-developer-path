package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class E06Courses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();

        String input ="";
        while(!"end".equals(input = reader.readLine())){
            String course = input.split(" : ")[0];
            String student = input.split(" : ")[1];

            List<String> studentsCollection = new ArrayList<>();
            if(!courses.containsKey(course)){
                courses.put(course, studentsCollection);
                courses.get(course).add(student);
            }else{
                courses.get(course).add(student);
            }
        }

        courses.entrySet()
                .stream()
                .sorted((e1,e2)-> {
                    int sort = Integer.compare(e2.getValue().size(),e1.getValue().size());
                    return sort;
                }).forEach(kvp -> {
            System.out.println(
                    String.format(
                            "%s: %s", kvp.getKey(), kvp.getValue().size()));
            kvp.getValue().stream()
                    .sorted((p1, p2) -> p1.compareTo(p2))
                    .forEach(u -> {
                        System.out.println(String.format("-- %s", u) );
                    });
        });
    }
}
