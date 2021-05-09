package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E07StudentAcademy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap<String, Double> students = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> countGrades = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String student = reader.readLine();
            Double grade = Double.parseDouble(reader.readLine());

            if(!students.containsKey(student)){
                students.put(student, grade);
                countGrades.put(student, 1);

            }else{
                students.put(student, students.get(student) + grade);
                countGrades.put(student, countGrades.get(student)+1);
            }
        }

        students.forEach((key, value) -> {
            students.put(key, value / countGrades.get(key));
        });

        students.entrySet()
                .stream()
                .filter(e -> e.getValue() >= 4.5 )
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(p -> {
                    System.out.println(String.format(
                            "%s -> %.2f", p.getKey(), p.getValue()
                    ));
                });
    }
}
