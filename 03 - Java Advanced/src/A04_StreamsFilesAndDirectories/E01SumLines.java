package A04_StreamsFilesAndDirectories;

import java.io.*;

public class E01SumLines {
//    Write a program that reads a text file (input.txt from the Resources - Exercises) and prints on the console
//    the sum of the ASCII symbols of each of its lines. Use BufferedReader in combination with FileReader.

    public static void main(String[] args) throws IOException {

        String filePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/input.txt";
        String outputFilePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/output.txt";

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(outputFilePath)
                )
        );

//        FileWriter writer = new FileWriter(outputFilePath);

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath)
            );
            String line = reader.readLine();
            while (line != null){
                int asciiSum = 0;

                for (char symbol : line.toCharArray()) {
                    asciiSum += symbol;
                }

                writer.write(asciiSum + "");
                writer.write(System.lineSeparator());
                line = reader.readLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        writer.close();
    }
}
