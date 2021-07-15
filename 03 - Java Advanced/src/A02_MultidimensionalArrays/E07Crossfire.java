    package A02_MultidimensionalArrays;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    public class E07Crossfire {
    //    You will receive two integers which represent the dimensions of a matrix. Then, you must fill the matrix with
    //    increasing integers starting from 1, and continuing on every row, like this:
    //    first row: 1, 2, 3, …, n
    //    second row: n + 1, n + 2, n + 3, …, n + n
    //    third row: 2 * n + 1, 2 * n + 2, …, 2 * n + n

    //    You will also receive several commands in the form of 3 integers separated by a space. Those 3 integers will
    //    represent a row in the matrix, a column and a radius. You must then destroy the cells which correspond
    //    to those arguments cross-like.

    //    Destroying a cell means that, that cell becomes completely nonexistent in the matrix. Destroying cells cross-like
    //    means that you form a cross figure with center point - equal to the cell with coordinates – the given row and
    //    column, and lines with length equal to the given radius. See the examples for more info.
    //    The input ends when you receive the command “Nuke it from orbit”. When that happens, you must print what has
    //    remained from the initial matrix.


        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader (
                    new InputStreamReader(
                            System.in
                    )
            );

            String[] data = reader.readLine().split("\\s+");

            int rows = Integer.parseInt(data[0]);
            int cols = Integer.parseInt(data[1]);

            ArrayList<ArrayList<Integer>> matrix = generateMatrix(rows, cols);

            String input = reader.readLine();

            while (!input.equals("Nuke it from orbit")){
                int[] tokens = Arrays.stream(input.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int row = tokens[0];
                int col = tokens[1];
                int radius = tokens[2];

                for (int r = row - radius; r <= row + radius; r++) {
                    if(isInBounds(matrix, r, col)){
                        matrix.get(r).set(col, 0);
                    }
                }

                for (int c = col - radius; c <=  col + radius; c++) {
                    if(isInBounds(matrix, row, c)){
                        matrix.get(row).set(c, 0);
                    }
                }

                for (int r = 0; r < matrix.size(); r++) {
                    matrix.get(r).removeAll(new ArrayList<Integer>(){{add(0);}});
//
//                    matrix.set(r, matrix.get(r)
//                            .stream()
//                            .filter(element -> element != 0)
//                            .collect(Collectors.toCollection(ArrayList::new)));

                    if(matrix.get(r).size() == 0){
                        matrix.remove(r);
                        r--;
                    }
                }

                input = reader.readLine();
            }

            printMatrix(matrix);
        }

        private static boolean isInBounds(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
            return row >= 0
                    && row < matrix.size()
                    && col >= 0
                    && col < matrix.get(row).size();

        }

        private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
            for (int row = 0; row < matrix.size(); row++) {
                for (int col = 0; col < matrix.get(row).size(); col++) {
                    System.out.print(matrix.get(row).get(col) + " ");
                }
                System.out.println();
            }
        }

        private static ArrayList<ArrayList<Integer>> generateMatrix(int rows, int cols) {
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

            int value = 1;
            for (int row = 0; row < rows; row++) {
                ArrayList<Integer> newRow = new ArrayList<>();
                for (int col = 0; col < cols; col++) {
                    newRow.add(value);
                    value++;
                }
                matrix.add(newRow);
            }

            return matrix;
        }
    }
