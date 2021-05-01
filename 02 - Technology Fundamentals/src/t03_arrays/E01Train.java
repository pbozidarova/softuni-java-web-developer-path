package T03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E01Train {
//  You will be given a count of wagons in a train n. On the next n lines you will receive how many people are going
//  to get on that wagon. At the end print the whole train and after that the sum of the people in the train.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new  BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int sum =0;
        for (int i = 0; i <n ; i++) {
            int number = Integer.parseInt(reader.readLine());
            System.out.print(number+" ");
            sum += number;
        }
        System.out.println();
        System.out.println(sum);
    }
}
