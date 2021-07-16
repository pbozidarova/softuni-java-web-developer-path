    package A03_SetsAndMapsAdvanced;

    import java.util.*;
    import java.util.stream.Collectors;

    public class L05AverageStudentsGrades {
    //    Write a program, which reads the name of a student and their grades and adds them to the student record,
    //    then prints grades along with their average grade – ordered the output by the names of the students.

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int count = Integer.parseInt(scanner.nextLine());

            Map<String, List<Double>> studentsAndGrades = new TreeMap<>();

            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine();
                String[] tokens = line.split("\\s+");

                studentsAndGrades.putIfAbsent(tokens[0], new ArrayList<>());

                studentsAndGrades.get(tokens[0]).add(Double.parseDouble(tokens[1]));
            }

            studentsAndGrades.forEach((name, grades)->{
                String allGrades = grades.stream()
                        .map(g -> String.format("%.2f", g))
                        .collect(Collectors.joining(" "));

//                double avg = grades.stream()
//                        .mapToDouble(e->e)
//                        .average()
//                        .getAsDouble();
//
//

//                double avgRound = Math.round(avg * 100.0) / 100.0;
                double sumGrades = 0.0;
                for (int i = 0; i < grades.size(); i++) {
                    sumGrades += grades.get(i);
                }

                double avgGrades = sumGrades / (grades.size() * 1.0);

                System.out.println(
                        String.format("%s -> %s (avg: %.2f)", name, allGrades, avgGrades)
                );
            });

        }
    }
