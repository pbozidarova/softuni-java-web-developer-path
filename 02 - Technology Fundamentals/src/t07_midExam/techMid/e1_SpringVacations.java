package techMid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e1_SpringVacations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int daysOfTrip = Integer.parseInt(reader.readLine());
        int budget = Integer.parseInt(reader.readLine());
        int people = Integer.parseInt(reader.readLine());
        Double fuelPerKm = Double.parseDouble(reader.readLine());
        Double foodExpenses = Double.parseDouble(reader.readLine());
        Double roomPrice = Double.parseDouble(reader.readLine());

        Double hotelExpensesPerDay = people * roomPrice * daysOfTrip;
        if(people > 10) hotelExpensesPerDay -= 0.25 * hotelExpensesPerDay;
        Double foodExpensesPerDay = foodExpenses * people * daysOfTrip;

        Double expenses = hotelExpensesPerDay + foodExpensesPerDay;
        if(budget - expenses < 0) {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", Math.abs(budget - expenses) );
            return;
        }

        for (int i = 1; i <= daysOfTrip; i++) {
            Double n = Double.parseDouble(reader.readLine());
            Double fuelExpenses = n * fuelPerKm;
            expenses += fuelExpenses;
            if(budget - expenses < 0) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", Math.abs(budget - expenses) );
                return;
            }


            if(i % 3 == 0 || i % 5 == 0)expenses += 0.4*expenses;
            if(budget - expenses < 0) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", Math.abs(budget - expenses) );
                return;
            }


            if(i % 7 == 0) expenses -= expenses/people;

        }

        System.out.printf("You have reached the destination. You have %.2f$ budget left.",budget - expenses);

    }
}
