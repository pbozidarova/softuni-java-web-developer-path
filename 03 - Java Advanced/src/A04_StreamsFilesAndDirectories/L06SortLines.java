package A04_StreamsFilesAndDirectories;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class L06SortLines {
//    Read the file provided, named "input.txt" and sort all lines. Write text to another text file.
//    Use Path and Files Classes.
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");

        Path pathIn = Paths.get(userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/input.txt");
        Path pathOut = Paths.get( userDir + "/src/A04_StreamsFilesAndDirectories/Resources/lab/output.txt");

        List<String> inputLines = Files.readAllLines(pathIn)
                .parallelStream()
                .filter(s -> !s.isEmpty())
                .sorted()
                .collect(Collectors.toList());

        //        inputLines.sort(Comparator.naturalOrder());

        Files.write(pathOut, inputLines, Charset.forName("UTF-8"));
    }

}
