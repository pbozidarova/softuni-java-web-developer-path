package A04_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class L01ReadFile {
//    You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes
//    (the binary representation of the ASCII code for each character) separated by a single comma.

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String path = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/input.txt";

        try(FileInputStream fis = new FileInputStream(path)){

            int oneByte = fis.read();
            while (oneByte >= 0){
                String res = Integer.toBinaryString(oneByte);
                System.out.print(res + " ");
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
