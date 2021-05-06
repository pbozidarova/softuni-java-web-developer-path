package t07_midExam.techMid;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'mostActive' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY customers as parameter.
     */

    public static List<String> mostActive(List<String> customers) {
        // Write your code here
        List<String> customersWithTrades = new ArrayList<>();
        int customersCount = customers.size();
        for (int i = 0; i < customers.size(); i++) {
            int countingTotals = 0;
            String element = customers.get(i);
            for (int j = 1; j < customers.size(); j++) {
                String element2 = customers.get(j);
                if(element.equals(element2)) {
                    countingTotals++;
                }
            }
            if((countingTotals*1.0 / customersCount) > 0.05) {
                customersWithTrades.add(customers.get(i));
            }

        }
        Collections.sort(customersWithTrades);
        return customersWithTrades;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int customersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> customers = IntStream.range(0, customersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.mostActive(customers);

        System.out.println(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
    }
}
