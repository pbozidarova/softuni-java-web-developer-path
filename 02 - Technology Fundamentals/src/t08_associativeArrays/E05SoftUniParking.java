package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E05SoftUniParking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap<String, String> users = new LinkedHashMap<>();
        Integer n = Integer.parseInt(reader.readLine());

        String input = "";

        for (int i = 0; i < n ; i++) {
            input = reader.readLine();
            String[] data = input.split("\\s+");

            String command = data[0];
            String user = data[1];
            String plate = "";
            if(data.length > 2 ) plate = data[2];

            switch (command){
                case "register":
                    if(!users.containsKey(user)){
                        users.put(user, plate);
                        System.out.println(
                                String.format("%s registered %s successfully", user, plate)
                        );
                    }else{
                        System.out.println("ERROR: already registered with plate number " +plate);
                    }
                    break;
                case "unregister":
                    if(!users.containsKey(user)){
                        System.out.println("ERROR: user " + user + " not found");
                    }else{
                        users.remove(user);
                        System.out.println(user +" unregistered successfully");
                    }
                    break;
                default:
                    break;
            }


        }

        users.entrySet().stream().forEach(e -> {
            System.out.println(String.format("%s => %s",e.getKey(), e.getValue()));
        });
    }
}
