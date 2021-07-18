package A04_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L03CopyBytes {
//    Read the file named "input.txt" and write to another file every character's ASCII representation.

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/input.txt";
        String pathOut = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/output.txt";

        try(FileInputStream fis = new FileInputStream(pathIn);
            FileOutputStream fos = new FileOutputStream(pathOut)){

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
