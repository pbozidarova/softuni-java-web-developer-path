package techMidPrep_02032019;

import java.util.Scanner;

public class e1_CookingMasterClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        double aprons = Math.ceil(students + students*0.2);
        int flourPackages = students - students/5;

        double result = flourPackages*flourPrice + students*eggPrice*10 + apronPrice*aprons;

        if(budget >= result) {
            System.out.printf("Items purchased for %.2f$.", result);
        } else {
            System.out.printf("%.2f$ more needed.", Math.abs(budget - result));
        }


    }
}
