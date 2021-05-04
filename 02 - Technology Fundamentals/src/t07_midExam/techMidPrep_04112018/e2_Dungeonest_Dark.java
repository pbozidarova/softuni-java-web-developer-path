package techMidPrep_04112018;

import java.util.Scanner;

public class e2_Dungeonest_Dark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|");
        int health =100;
        int coins = 0;

        for (int i = 0; i < rooms.length; i++) {
            String [] room = rooms[i].split(" ");
            String action = room[0];
            int amount = Integer.parseInt(room[1]);

            if(action.equals("potion")){
                int initialHealth = health;
                health += amount;
                if(health > 100) {
                    health = 100;
                    amount = 100 - initialHealth;
                }

                System.out.printf("You healed for %d hp.%n", amount);
                System.out.printf("Current health: %d hp.%n", health);
            } else if(action.equals("chest")){
                System.out.printf("You found %d coins.%n", amount);
                coins += amount;
            } else{
                health -= amount;

                if(health <= 0) {
                    System.out.println("You died! Killed by " + action + ".");
                    System.out.printf("Best room: %d%n", i+1);
                    return;
                } else {
                    System.out.printf("You slayed %s.%n", action);
                }

            }

        }

        System.out.printf("You've made it! %nCoins: %d%nHealth: %d", coins, health);
    }

}
