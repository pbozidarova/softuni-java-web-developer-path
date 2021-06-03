package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L03PassedOrFailed {

//    Modify the above program, so it will print "Failed!" if the grade is lower than 3.00.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        if(Double.parseDouble(reader.readLine()) >= 3.00){
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }
    }
}
