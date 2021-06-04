package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E05Login {

//    You will be given a string representing a username. The password will be that username reversed.
//    Until you receive the correct password print on the console "Incorrect password. Try again.".
//    When you receive the correct password print "User {username} logged in." However on the fourth try if
//    the password is still not correct print "User {username} blocked!" and end the program.
//
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder username = new StringBuilder();
        String password = username.append(reader.readLine()).reverse().toString();

        for (int i = 0; i < 4; i++) {
            if(password.equals(reader.readLine())){
                System.out.printf("User %s logged in.", username.reverse().toString());
                break;
            }else {
                if(i == 3){
                    System.out.printf("User %s blocked!", username.reverse().toString());
                    break;
                }
                System.out.println("Incorrect password. Try again.");
            }
        }
    }
}
