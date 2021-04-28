package t05_listsArraysAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class E01Train {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader(System.in));

        String[] inputData = reader.readLine().split("\\s+");

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < inputData.length ; i++) {
            numbers.add(Integer.parseInt(inputData[i]));

        }

        int maxCapacity = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        while(!"end".equals(input)){
            String [] data = input.split("\\s+");

            if(data.length == 2){
                int number = Integer.parseInt(data[1]);
                numbers.add(number);
            } else{
                int number = Integer.parseInt(data[0]);
                for (int i = 0; i < numbers.size(); i++) {
                    int currentElement = numbers.get(i);

                    if(currentElement + number <= maxCapacity){
                        numbers.set(i, currentElement + number);
                        break;
                    }
                }
            }

            input = reader.readLine();
        }
        System.out.println(
                numbers.toString().replaceAll("[\\[,\\]]", ""));
    }
}
