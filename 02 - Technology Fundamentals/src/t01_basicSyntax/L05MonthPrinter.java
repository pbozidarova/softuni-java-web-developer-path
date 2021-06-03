package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class L05MonthPrinter {

//    Write a program, which takes an integer from the console and prints the corresponding month.
//    If the number is more than 12 or less than 1 print "Error!".

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int index = Integer.parseInt(reader.readLine());

        String[] months = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        if(index < 1 || index > months.length){
            System.out.println("Error!");
        }else {
            System.out.println(months[index -1]);
        }


    }
}
