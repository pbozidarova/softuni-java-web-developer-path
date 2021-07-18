package A04_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L02WriteToFile {

//    Read the file named "input.txt" that is provided for this exercise and write all its content to a file
//    while skipping any punctuation. Skip the following symbols: ',', '.', '!', '?'.

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/input.txt";
        String pathOut = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/output.txt";

        try(FileInputStream fis = new FileInputStream(pathIn);
            FileOutputStream fos = new FileOutputStream(pathOut)){

            int oneByte = fis.read();
            while (oneByte >= 0){
                if(oneByte != '.'
                        && oneByte != ','
                        && oneByte != '?'
                        && oneByte != '!'){
                    fos.write(oneByte);
                }

                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
