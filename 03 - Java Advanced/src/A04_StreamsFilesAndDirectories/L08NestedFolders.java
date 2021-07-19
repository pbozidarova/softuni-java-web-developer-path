package A04_StreamsFilesAndDirectories;

import java.io.File;

public class L08NestedFolders {
//    You are provided a folder named "Files-and-Streams". Create a program that lists the names of all directories
//    in it (including all nested directories).
//    On the last line, print the count of all folders, including the root folder.

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");

        String pathIn = "C:\\Users\\Petya Kuzmanova\\Desktop\\SoftUni\\softuni-java-web-developer-path\\03 - Java Advanced\\src\\A04_StreamsFilesAndDirectories\\Resources\\lab\\Files-and-Streams";

        File f = new File(pathIn);

        DFS(f);
    }

    static void DFS(File root){
        if(root == null) return;
        File[] files = root.listFiles();
        if(files == null) return;

        for (File file : files){
            if(file.isDirectory()){
                System.out.println("DIR: " + file.getName());
                DFS(file);
            }else {
                System.out.println(file.getName());
            }
        }
    }
}

