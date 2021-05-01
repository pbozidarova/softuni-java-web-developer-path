package techMidPrep_18122018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e1_ChristmasMood {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int quantity = Integer.parseInt(reader.readLine());
        int daysTillChristmas = Integer.parseInt(reader.readLine());

        int ornametSet = 2;
        int treeSkirt = 5;
        int treeGralands = 3;
        int treeLights = 15;

        int budget = 0;
        int totalSpirit = 0;

        for (int i = 1; i <= daysTillChristmas; i++) {

            if(i % 11 == 0) quantity += 2;

            if(i % 2 == 0){
                budget += ornametSet*quantity;
                totalSpirit += 5;
            }
            if( i % 3 == 0){
                budget += (treeGralands + treeSkirt)*quantity;
                totalSpirit += 13;
            }
            if( i % 5 == 0){
                budget += (treeLights*quantity);
                totalSpirit += 17;
                if(i % 3 == 0) totalSpirit += 30;
            }
            if( i % 10 == 0){
                budget += (treeGralands + treeLights + treeSkirt);
                totalSpirit -= 20;

                if(daysTillChristmas == i) totalSpirit -= 30;
            }
        }
        System.out.println("Total cost: " + budget);
        System.out.println("Total spirit: "+ totalSpirit);
    }
}
