package t03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L01DaysOfWeek {
//  Enter a day number [1…7] and print the day name (in English) or "Invalid day!". Use an array of strings.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int index = Integer.parseInt(reader.readLine());
        if(index <= 0 || index > 7){
            System.out.println("Invalid day!");
        }else {
            System.out.println(daysOfWeek[index - 1]);
        }
    }
}
