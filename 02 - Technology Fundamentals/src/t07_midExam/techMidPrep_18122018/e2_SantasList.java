package techMidPrep_18122018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class e2_SantasList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        List<String> noisyKids = Arrays.stream(reader.readLine().split("&")).collect(Collectors.toList());
        String input = "";

        while (!"Finished!".equals(input = reader.readLine())){
            String[] data = input.split("\\s+");
            String command = data[0];
            String noisyKid = data[1];

            switch (command){
                case "Bad":
                    if(!noisyKids.contains(noisyKid)) noisyKids.add(0, noisyKid);
                    break;
                case "Good":
                    if(noisyKids.contains(noisyKid)) noisyKids.remove(noisyKid);
                    break;
                case "Rename":
                    if(noisyKids.contains(noisyKid)) {
                        noisyKids.add(noisyKids.indexOf(noisyKid), data[2]);
                        noisyKids.remove(noisyKid);
                    }
                    break;
                case "Rearrange":
                    if(noisyKids.contains(noisyKid)) {
                        noisyKids.remove(noisyKid);
                        noisyKids.add(noisyKid);
                    }
                    break;

            }

        }
        System.out.println(noisyKids.toString().replaceAll("[\\[\\]]", ""));

    }
}
