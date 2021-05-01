package techMidPrep_02032019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e2_BreadFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        String[] events = reader.readLine().split("\\|");
        int energy = 100;
        int coins = 100;

        for (int i = 0; i < events.length; i++) {
            String[] singleDay = events[i].split("-");

            String action = singleDay[0];
            Integer amount = Integer.parseInt(singleDay[1]);

            if(action.equals("rest")){
                int initialEnergy = energy;
                if(energy + amount > 100){
                    energy = 100;
                    amount = energy - initialEnergy;
                } else {
                    energy += amount;
                }
                System.out.printf("You gained %d energy.%n", amount);
                System.out.printf("Current energy: %d.%n", energy);
            } else if(action.equals("order")){
                energy -= 30;
                if(energy >= 0 ) {
                    coins += amount;
                    System.out.printf("You earned %d coins.%n", amount);
                } else {
                    //energy = 0;
                    energy += 80;
                    System.out.printf("You had to rest!%n");
                }
            } else {
                coins -= amount;

                if(coins > 0){
                    System.out.printf("You bought %s.%n", action);
                } else {
                    System.out.printf("Closed! Cannot afford %s.%n", action);
                    return;
                }
            }


        }

        System.out.printf("Day completed!%nCoins: %d%nEnergy: %d", coins,energy);


    }
}
