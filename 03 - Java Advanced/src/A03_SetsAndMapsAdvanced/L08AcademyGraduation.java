package A03_SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class L08AcademyGraduation {

//    Write a program that:
//•	Read from console number of students for a track
//•	Read on pair of rows:
//    o	First line is the name of student
//    o	Second line is his score for different number of courses
//•	Print on console “{name} is graduated with {average scores)”

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> asd = new TreeMap<>();

        while (count-- != 0){
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            asd.putIfAbsent(name, new ArrayList<>());
            asd.get(name).addAll(grades);
        }

//        DecimalFormat format = new DecimalFormat("#.####");
        asd.forEach((name, grades) -> {
            double sum = 0.0;

            for (int i = 0; i < grades.size(); i++) {
                sum += grades.get(i);
            }
            double avg = sum / grades.size();
            System.out.println(String.format("%s is graduated with %s",
                    name,
                    avg
//                    format.format(avg)
                    ));
        });

    }
}
