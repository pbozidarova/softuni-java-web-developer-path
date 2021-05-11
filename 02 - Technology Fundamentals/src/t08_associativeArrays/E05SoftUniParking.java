package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E05SoftUniParking {
//    SoftUni just got a new parking lot. It’s so fancy, it even has online parking validation. Except, the online
//    service doesn’t work. It can only receive users’ data, but doesn’t know what to do with it.
//    Good thing you’re on the dev team and know how to fix it, right?
//    Write a program, which validates parking for an online service. Users can register to park and unregister to leave.
//    The program receives 2 commands:
//            •	"register {username} {licensePlateNumber}":
//    o	The system only supports one car per user at the moment, so if a user tries to register another license plate,
//    using the same username, the system should print:
//            "ERROR: already registered with plate number {licensePlateNumber}"
//    o	If the aforementioned checks pass successfully, the plate can be registered, so the
//    system should print:
//            "{username} registered {licensePlateNumber} successfully"
//            •	"unregister {username}":
//    o	If the user is not present in the database, the system should print:
//            "ERROR: user {username} not found"
//    o	If the aforementioned check passes successfully, the system should print:
//            "{username} unregistered successfully"
//    After you execute all of the commands, print all the currently registered users and their
//    license plates in the format:
//            •	"{username} => {licensePlateNumber}"

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
