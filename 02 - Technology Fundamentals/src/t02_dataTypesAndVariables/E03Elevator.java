package t02_dataTypesAndVariables;

import java.util.Scanner;

public class E03Elevator {
//    Calculate how many courses will be needed to elevate n persons by using an elevator of capacity of p persons.
//    The input holds two lines: the number of people n and the capacity p of the elevator.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());

        int courses  = (int) Math.ceil((double) n / p);

        System.out.println(courses);
    }

}
