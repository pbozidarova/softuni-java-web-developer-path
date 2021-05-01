package techMidPrep_18122018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class e3_PresentDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] houses = Arrays.stream(reader.readLine().split("@")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = Arrays.stream(houses).sum();
        int houseIndex = 0;
        int housesCount = 0;

        //System.out.println(3%8);

        String input = "";
        while (!"Merry Xmas!".equals(input = reader.readLine())) {
            int jumpLength = Integer.parseInt(input.split("\\s+")[1]);

            for (int i = 0; i < jumpLength; i++) {
                houseIndex++;
                if(houseIndex == houses.length) houseIndex = 0;
            }
            if (houses[houseIndex] > 0) {
                    houses[houseIndex] -= 2;
                    if(houses[houseIndex]<0)houses[houseIndex] = 0;
            }else{
                System.out.println("House " + houseIndex + " will have a Merry Christmas.");
            }
            sum = Arrays.stream(houses).sum();
        }

        System.out.println("Santa's last position was "+houseIndex+".");
        if(sum == 0) {
            System.out.println("Mission was successful.");
        } else{
            for (int i = 0; i <  houses.length; i++) {
                if(houses[i] > 0) housesCount++;
            }
            System.out.println("Santa has failed "+ housesCount +" houses.");
        }
    }
}
