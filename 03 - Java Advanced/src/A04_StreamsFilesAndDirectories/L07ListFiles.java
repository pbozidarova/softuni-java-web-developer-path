package A04_StreamsFilesAndDirectories;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class L07ListFiles {
//    You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes
//    (in bytes) of all files that are placed directly in it (do not include files in nested folders).

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = "C:\\Users\\Petya Kuzmanova\\Desktop\\SoftUni\\softuni-java-web-developer-path\\03 - Java Advanced\\src\\A04_StreamsFilesAndDirectories\\Resources\\lab\\Files-and-Streams";

        File f = new File(pathIn);

        File[] allFiles = f.listFiles();

        if(allFiles == null) return;

        for (File file : allFiles) {
            if(!file.isDirectory()){
                System.out.println(String.format("%s: [%d]", file.getName(), file.length()));

            }
        }

    }
}
