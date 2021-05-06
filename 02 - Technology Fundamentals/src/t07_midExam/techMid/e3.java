package t07_midExam.techMid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class e3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> paintings = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String input = "";
        while (!"END".equals(input = reader.readLine())){
            String command = input.split("\\s+")[0];

            switch (command){
                case "Change":
                    String paintingNumber = input.split("\\s+")[1];
                    String changePainting = input.split("\\s+")[2];

                    if( paintings.contains(paintingNumber) ) {
                        int index = paintings.indexOf(paintingNumber);
                        paintings.remove(paintingNumber);
                        paintings.add(index, changePainting);
                    }
                    break;
                case "Hide":
                    String paintingNumberHide = input.split("\\s+")[1];
                    if( paintings.contains(paintingNumberHide)) paintings.remove(paintingNumberHide);
                    break;

                case "Switch":
                    String paintingNumberSwitch1 = input.split("\\s+")[1];
                    String paintingNumberSwitch2 = input.split("\\s+")[2];

                    if( paintings.contains(paintingNumberSwitch1)&& paintings.contains(paintingNumberSwitch2))  {
                        int index1 = paintings.indexOf(paintingNumberSwitch1);
                        int index2 = paintings.indexOf(paintingNumberSwitch2);

                        paintings.remove(paintingNumberSwitch1);
                        paintings.add(index2, paintingNumberSwitch1);

                        paintings.remove(paintingNumberSwitch2);
                        paintings.add(index1, paintingNumberSwitch2);




                    }
                    break;
                case "Insert":
                    String paintingNumberInsert = input.split("\\s+")[2];
                    int place = 1+ Integer.parseInt(input.split("\\s+")[1]);

                    if( place >= 0 && place < paintings.size() ) {
                        paintings.add(place, paintingNumberInsert);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(paintings);
                    break;


            }

        }

        System.out.println(paintings.toString().replaceAll("[\\[,\\]]", ""));

    }

}
