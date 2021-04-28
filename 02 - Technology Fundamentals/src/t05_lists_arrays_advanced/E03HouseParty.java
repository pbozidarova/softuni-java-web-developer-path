package t05_lists_arrays_advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E03HouseParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        System.in
                ));

        int n = Integer.parseInt(reader.readLine());
        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = reader.readLine().split("\\s+");

            if(data[2].equals("not")){
                if(!names.contains(data[0])) {
                    System.out.printf("%s is not in the list!\n", data[0]);
                }
                names.remove(data[0]);

            }else{
                if(names.contains(data[0])){
                    System.out.printf("%s is already in the list!\n", data[0]);
                }else {
                    names.add(data[0]);
                }

            }

        }
        System.out.println(String.join("\n", names));
    }
}
