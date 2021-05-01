package t04_methods;

import java.util.Scanner;

public class E07NxNMatrix {
//    Write a method that receives a single integer n and prints nxn matrix with that number.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

//        NxN(n, n);

        for (int i = 0; i < n; i++) {
            System.out.println(newString(String.valueOf(n), n));
        }
    }

    private static void NxN(int n, int n1) {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n1 ; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static String newString(String symbol, int count){
        String result = "";

        for (int i = 0; i < count; i++) {
            result += symbol + " ";
        }
        return result.trim();
    }
}
