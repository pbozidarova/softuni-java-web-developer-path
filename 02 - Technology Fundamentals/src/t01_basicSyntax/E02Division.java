package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02Division {

//    You will be given an integer and you have to print on the console whether that number is divisible by the
//    following numbers: 2, 3, 6, 7, 10. You should always take the bigger division. If the number is divisible
//    by both 2 and 3 it is also divisible by 6 and you should print only the division by 6. If a number is divisible
//    by 2 it is sometimes also divisible by 10 and you should print the division by 10. If the number is not divisible
//    by any of the given numbers print “Not divisible”. Otherwise print "The number is divisible by {number}".
//

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );
        int number = Integer.parseInt(reader.readLine());
        int[] dividers = new int[]{2, 3, 6, 7, 10};
        boolean divisible = false;

        for (int i = dividers.length -1; i >= 0; i--) {
            if(number % dividers[i] == 0){
                System.out.println("The number is divisible by " + dividers[i]);
                divisible = true;
                break;
            }
        }

        if(!divisible){
            System.out.println("Not divisible");
        }

    }
}
