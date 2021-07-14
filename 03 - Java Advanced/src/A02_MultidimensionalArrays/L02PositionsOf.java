package A02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L02PositionsOf {
//    Write a program that reads a matrix of integers from the console, then a number and prints all the positions at
//    which that number appears in the matrix.
//    The matrix definition on the console will contain a line with two positive integer numbers R and C – the number
//    of rows and columns in the matrix – followed by R lines, each containing C numbers (separated by spaces),
//    representing each row of the matrix.

//    The number you will need to find the positions of will be entered on a single line, after the matrix.
//    You should print each position on a single line – first print the row, then the column at which the number appears.
//    If the number does not appear in the matrix, print not found

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = new int[dim[0]][dim[1]];
        StringBuilder inputData = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            inputData.append(scanner.nextLine()).append(System.lineSeparator());
        }
        int searchNumber = Integer.parseInt(scanner.nextLine());;

        boolean hasMatch = false;
        String[] inputNumbers = inputData.toString().split("\\s+");
        int index = 0;
        for (int row = 0; row < matrix.length; row++) {
//            String[] inputNumbers = inputLines[row].split("\\s+");

            for (int col = 0; col < dim[1]; col++) {
                int value = Integer.parseInt(inputNumbers[index++]);

                if(value == searchNumber){
                    System.out.println(row + " " + col);
                    hasMatch = true;
                }

                matrix[row][col] = value;
            }
        }



        if(!hasMatch){
            System.out.println("not found");
        }

    }
}
