package A04_StreamsFilesAndDirectories;

import java.io.*;
import java.math.BigInteger;

public class E02SumBytes {
//    Write a program that reads a text file (input.txt from the Resources - Exercises)  and prints on the console the
//    sum of the ASCII symbols of all characters inside of the file. Use BufferedReader in combination with FileReader.

    public static void main(String[] args) throws IOException {
        String filePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/input.txt";
        String outputFilePath = "src/A04_StreamsFilesAndDirectories/Resources/ex/output.txt";

        FileReader fileReader = new FileReader(filePath);

        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();
        BigInteger totalSum = BigInteger.ZERO;
        while (line != null){
            for (char symbol : line.toCharArray()) {
                totalSum = totalSum.add(BigInteger.valueOf(symbol));
            }
            line = reader.readLine();
        }
        

        PrintWriter printer = new PrintWriter(outputFilePath);
        printer.println(totalSum.toString());
        printer.close();

    }
}
