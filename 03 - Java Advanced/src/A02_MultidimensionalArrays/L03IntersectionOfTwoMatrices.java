package A02_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L03IntersectionOfTwoMatrices {
//    Write a program that reads two char matrices (A[][] and B[][]) of the same order M * N and prints
//    third matrix C[][] which is filled with the intersecting elements of A and B, otherwise set the element to '*'.
//    On the first two lines you receive M and N, then on 2 * M lines N characters – the matrices elements.
//    The matrix elements may be any ASCII char except '*'.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows * 2; row++) {
            String[] elements = scanner.nextLine().split("\\s+");

            for (int col = 0; col < elements.length; col++) {
                if(row < rows){
                    firstMatrix[row][col] = elements[col].charAt(0);
                }else {
                    secondMatrix[row - rows][col] = elements[col].charAt(0);
                }
            }
        }

        char[][] resultMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstElement = firstMatrix[row][col];
                char secondElement = secondMatrix[row][col];

                if(firstElement != secondElement){
                    resultMatrix[row][col] = '*';
                    continue;
                }
                resultMatrix[row][col] = firstElement;
            }
        }

        for (char[] matrix : resultMatrix) {
            System.out.println(Arrays.toString(matrix)
                    .replaceAll("\\[|\\]|,", ""));
        }
    }
}
