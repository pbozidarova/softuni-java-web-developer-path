package t08_associativeArrays;

import java.util.*;

public class L01CountRealNumbers {
//    Read a list of real numbers and print them in ascending order along with their number of occurrences.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> someMap = new TreeMap<>();

        for (double num : nums) {
            if(!someMap.containsKey(num)){
                someMap.put(num, 0);
            }
            int newValue = someMap.get(num)+1;
            someMap.put(num, newValue);
        }

        String pattern = "%.0f -> %d%n";
        for (Map.Entry<Double, Integer> kvp : someMap.entrySet()) {

            System.out.printf(pattern, kvp.getKey(), kvp.getValue());
        }
    }
}
