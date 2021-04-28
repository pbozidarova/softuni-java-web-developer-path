package t05_lists_arrays_advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E05BombNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        List<String> numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .collect(Collectors.toList());
        String [] data = reader.readLine().split("\\s+");
        String bombNumber = data[0];
        int power = Integer.parseInt(data[1]);

        while (numbers.contains(bombNumber)){
            int bombIndex = numbers.indexOf(bombNumber);

            int left = Math.max(0, bombIndex-power);
            int right = Math.min(bombIndex+power,numbers.size()-1);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }

        System.out.println(numbers.stream().mapToInt(Integer::parseInt).sum());
    }
}
