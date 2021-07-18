package A04_StreamsFilesAndDirectories;

import java.io.*;

public class L04ExtractIntegers {

//    Read the file provided, named "input.txt" and extracts all integers that are not a part of
//    a word in a separate file. A valid integer is surrounded with white spaces.

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/input.txt";
        String pathOut = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/output.txt";

        try(FileReader fis = new FileReader(pathIn);
            FileWriter fos = new FileWriter(pathOut)){

            int oneByte = fis.read();
            while (oneByte >= 0){
                if(oneByte == 32 || oneByte == 10){
                    fos.write(oneByte);
                }else {
                    String byteAsText = String.valueOf(oneByte);
                    for (char symbol : byteAsText.toCharArray()) {
                        fos.write(symbol);
                    }
                }
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
