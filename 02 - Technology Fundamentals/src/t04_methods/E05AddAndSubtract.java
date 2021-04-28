package t04_methods;

import java.util.Scanner;

public class E05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());


        substract(sum(first, second), third);
    }

    private static void substract(int numb1, int numb2) {
        System.out.println((numb1 - numb2));
    }

    private static int sum(int first, int second) {
        int result = (first+second);
        return result;
    }

}
