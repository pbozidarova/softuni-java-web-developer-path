package t04_methods;

import java.util.Scanner;

public class E09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while(!input.equals("END")) {
            palindromeChecker(input);
            input = scanner.nextLine();
        }
    }

    private static void palindromeChecker(String input) {
        int rotations = input.length() / 2;
        int count = 0;
        for (int i = 0; i < rotations ; i++) {
            if(input.charAt(i) == input.charAt(input.length()-i-1)){
                count++;
            }
        }
        if (count == rotations) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }

}
