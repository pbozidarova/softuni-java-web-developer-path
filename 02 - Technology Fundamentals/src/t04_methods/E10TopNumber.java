package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E10TopNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int endNumber = Integer.parseInt(reader.readLine());

        sumDiv8(endNumber);
    }

    private static void sumDiv8(int endNumber) {

        for (int i = 1; i < endNumber ; i++) {
            int sum = 0;
            for (int j = 0; j < String.valueOf(i).length() ; j++) {
                int numb = Integer.parseInt("" + String.valueOf(i).charAt(j));
                sum += numb;
            }
            if(sum % 8 == 0 && oddNumb(i)){
                System.out.println(i);
            }
        }
    }

    private static boolean oddNumb(int numb) {
        boolean flag = false;
        for (int i = 0; i < String.valueOf(numb).length() ; i++) {
            int digit = Integer.parseInt("" + String.valueOf(numb).charAt(i));
            if (digit % 2 != 0) flag =true;
        }
        return flag;
    }
}
