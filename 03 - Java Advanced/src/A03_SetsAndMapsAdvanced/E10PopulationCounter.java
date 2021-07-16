package A03_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E10PopulationCounter {

//    So many people! It’s hard to count them all. But that’s your job as a statistician. You get raw data for a
//    given city and you need to aggregate it.
//    On each input line you’ll be given data in format: "city|country|population". There will be no redundant
//    whitespaces anywhere in the input. Aggregate the data by country and by city and print it on the console.
//    For each country, print its total population and on separate lines the data for each of its cities.
//    Countries should be ordered by their total population in descending order and within each country,
//    the cities should be ordered by the same criterion. If two countries/cities have the same population,
//    keep them in the order in which they were entered. Check out the examples; follow the output format strictly!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationCounter = new LinkedHashMap();


        while (!"report".equals(input)){

            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if(!populationCounter.containsKey(country)){
                populationCounter
                        .put(country,
                                new LinkedHashMap<>(){{put(city, population);}});
            }else {
                populationCounter.get(country).putIfAbsent(city, population);
            }


            input = scanner.nextLine();
        }
        populationCounter
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                  Long firstPopulation = populationCounter.get(f.getKey())
                           .entrySet()
                           .stream()
                           .mapToLong(Map.Entry::getValue)
                           .sum();

                  Long secondPopulation = populationCounter.get(s.getKey())
                           .entrySet()
                           .stream()
                           .mapToLong(Map.Entry::getValue)
                           .sum();

                  return secondPopulation.compareTo(firstPopulation);
                }).forEach(entry -> {
                    long totalPopulation = entry.getValue()
                            .values()
                            .stream()
                            .mapToLong(value -> value)
                            .sum();

                    System.out.println(String.format("%s (total population: %d)", entry.getKey(), totalPopulation));

                    entry.getValue()
                            .entrySet()
                            .stream()
                            .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(e -> {
                                System.out.println(String.format("=>%s: %d", e.getKey(), e.getValue()));
                            });

                });


    }
}
