package A02_MultidimensionalArrays;

import java.util.Scanner;

public class E05MatrixShuffling {
//    Write a program which reads a string matrix from the console and performs certain operations with its elements.
//    User input is provided in a similar way like in the problems above – first you read the dimensions
//    and then the data.
//    Your program should then receive commands in format: "swap row1 col1 row2c col2" where row1, row2, col1, col2
//    are coordinates in the matrix. In order for a command to be valid, it should start with the "swap" keyword
//    along with four valid coordinates (no more, no less). You should swap the values at the given coordinates
//    (cell [row1, col1] with cell [row2, col2]) and print the matrix at each step (thus you'll be able to check
//    if the operation was performed correctly).

//    If the command is not valid (doesn't contain the keyword "swap", has fewer or more coordinates
//    entered or the given coordinates do not exist), print "Invalid input!" and move on to the next command.
//    Your program should finish when the string "END" is entered.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");

        }

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");

            if(tokens[0].equals("swap") && tokens.length == 5){
                int firstRow = Integer.parseInt(tokens[1]);
                int firstCol = Integer.parseInt(tokens[2]);
                int secondRow = Integer.parseInt(tokens[3]);
                int secondCol = Integer.parseInt(tokens[4]);

                if(isInBounds(matrix, firstRow, firstCol) &&
                    isInBounds(matrix, secondRow, secondCol)){
                    String temp = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = temp;

                    printMatrix(matrix);

                } else {
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }


            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >= 0 &&
               row < matrix.length &&
               col >= 0 &&
               col < matrix[row].length;
    }
}
