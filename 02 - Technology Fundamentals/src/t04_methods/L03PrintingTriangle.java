package t04_methods;

import java.util.Scanner;

public class L03PrintingTriangle {
//    Create a method for printing triangles as shown below:
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printLine(i);
        }

        for (int i = n-1; i > 0 ; i--) {
            printLine(i);
        }
    }

    private static void printLine(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
