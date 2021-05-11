package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class E06Courses {
//    Write a program, which keeps information about courses. Each course has a name and registered students.
//    You will receive course name and student name, until you receive the command "end". Check if such course
//    already exists, and if not, add the course. Register the user into the course. When you do receive the command
//    "end", print the courses with their names and total registered users, ordered by the count of registered users
//    in descending order. For each contest print registered users ordered by name in ascending order.

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
