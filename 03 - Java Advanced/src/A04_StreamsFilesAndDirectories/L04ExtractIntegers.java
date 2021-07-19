package A04_StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class L04ExtractIntegers {

//    Read the file provided, named "input.txt" and extracts all integers that are not a part of
//    a word in a separate file. A valid integer is surrounded with white spaces.

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/input.txt";
        String pathOut = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/output.txt";

        try(Scanner scanner = new Scanner(new FileReader(pathIn));
            PrintWriter writer = new PrintWriter(pathOut)) {
            while (scanner.hasNext()) {
                scanner.next();
                if(scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
