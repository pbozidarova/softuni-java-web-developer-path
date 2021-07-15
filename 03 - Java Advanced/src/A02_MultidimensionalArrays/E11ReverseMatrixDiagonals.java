package A02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E11ReverseMatrixDiagonals {
//    You are given a matrix (2D array) of integers. You have to print the matrix diagonal but in reversed order.
//    Print each diagonal on new line.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0){
            int r = row;
            int c = col;

            while (c < cols && r >= 0){
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;

            if(col == -1){
                col = 0;
                row --;
            }
        }
    }
}
