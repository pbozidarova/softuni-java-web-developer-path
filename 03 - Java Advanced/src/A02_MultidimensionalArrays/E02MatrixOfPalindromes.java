package A02_MultidimensionalArrays;

import java.util.Scanner;

public class E02MatrixOfPalindromes {
//    Write a program to generate the following matrix of palindromes of 3 letters with r rows and c columns
//    like the one in the examples below.
//            •	Rows define the first and the last letter: row 0  ‘a’, row 1  ‘b’, row 2  ‘c’, …
//            •	Columns + rows define the middle letter:
//    o	column 0, row 0  ‘a’, column 1, row 0  ‘b’, column 2, row 0  ‘c’, …
//    o	column 0, row 1  ‘b’, column 1, row 1  ‘c’, column 2, row 1  ‘d’, …

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int size = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        int row = 0, col = 0;
        int primarySum = 0;
        while (row < size && col < size){
            primarySum += matrix[row][col];
            row++; col++;
        }

        row--;
        col = 0;

        int secondarySum = 0;
        while (row >= 0 && col < size){
            secondarySum += matrix[row][col];
            row--; col++;
        }

        System.out.println(Math.abs(primarySum - secondarySum));
    }
}
