package A02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L01CompareMatrices {
//    Write a program that reads two integer matrices (2D arrays) from the console and compares them element by element.
//    For better code reusability, you could do the comparison in a method, which returns true if they
//    are equal and false if not.
//    Each matrix definition on the console will contain a line with a positive integer number R – the number of
//    rows in the matrix and C – the number of columns – followed by R lines containing the C numbers, separated
//    by spaces (each line will have an equal amount of numbers.

//    The matrices will have at most 10 rows and at most 10 columns.
//    Print equal if the matrices match, and not equal if they don’t match.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstMatrixDim = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] firstMatrix = new int[firstMatrixDim[0]][firstMatrixDim[1]];
        for (int row = 0; row < firstMatrix.length; row++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            firstMatrix[row] = new int[inputData.length];

            for (int col = 0; col < inputData.length; col++){
                int number = Integer.parseInt(inputData[col]);
                firstMatrix[row][col] = number;
            }
        }

        int[] secondMatrixDim = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] secondMatrix = new int[secondMatrixDim[0]][secondMatrixDim[1]];

        for (int row = 0; row < secondMatrix.length; row++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            secondMatrix[row] = new int[inputData.length];

            for (int col = 0; col < inputData.length; col++){
                int number = Integer.parseInt(inputData[col]);
                secondMatrix[row][col] = number;
            }
        }

        if(firstMatrixDim[0] != secondMatrixDim[0] || firstMatrixDim[1] != secondMatrixDim[1]){
            System.out.println("not equal");
            return;
        }

        for (int row = 0; row < firstMatrixDim[0]; row++) {
            boolean areArraysNotEqual = firstMatrix[row].length != secondMatrix[row].length;

            if(areArraysNotEqual){
                System.out.println("not equal");
                return;
            }

            for (int col = 0; col < firstMatrix[row].length; col++) {
                int firstValue = firstMatrix[row][col];
                int secondValue = secondMatrix[row][col];

                if(firstValue != secondValue){
                    System.out.println("not equal");
                    return;
                }
            }
        }

        System.out.println("equal");
    }
}
