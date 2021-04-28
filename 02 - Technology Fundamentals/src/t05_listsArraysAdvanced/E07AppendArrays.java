package t05_listsArraysAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E07AppendArrays {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        List<String> input = Arrays.stream(reader.readLine().split("\\|+"))
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();

        for (int i = input.size()-1; i >= 0; i--) {
            result.add(input.get(i));
        }

        System.out.println(result.toString().replaceAll("[\\[,\\]]"," ").replaceAll("\\s+"," "));
    }

}
