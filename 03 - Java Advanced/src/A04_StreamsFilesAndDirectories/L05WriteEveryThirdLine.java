package A04_StreamsFilesAndDirectories;

import javax.sound.sampled.Line;
import java.io.*;

public class L05WriteEveryThirdLine {
//    Read the file provided, named "input.txt" and write to another file all lines which number is divisible by 3.
//    Line numbers start from one.

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/input.txt";
        String pathOut = userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/output.txt";
        int pos = 1;
        try (BufferedReader bfr = new BufferedReader (new FileReader(pathIn));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))
        ){
            String line = "";
            while ((line = bfr.readLine()) != null){
                if(pos % 3 == 0){
                    bfw.write(line);
                    bfw.newLine();
                }
                pos++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

