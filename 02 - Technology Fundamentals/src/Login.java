import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login {
    public static void main(String[] args) throws IOException {
//        You will be given a string representing a username. The password will be that username reversed.
//        Until you receive the correct password print on the console "Incorrect password. Try again.".
//        When you receive the correct password print "User {username} logged in."
//        However on the fourth try if the password is still not correct print
//        "User {username} blocked!" and end the program.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userName = reader.readLine();
        String guessPassword = "gPSW";
        String password = "";
        Integer counter = 0;

        while (!guessPassword.equals(password)) {
            guessPassword = reader.readLine();
            for (int i = userName.length() - 1; i >= 0; i--) {
                password += userName.charAt(i);
            }

            if (guessPassword.equals(password)) {
                System.out.println("User " + userName + " logged in.");
                break;
            } else {
                counter++;
                if (counter != 4) {
                    System.out.println("Incorrect password. Try again.");
                } else {
                    System.out.println("User " + userName + " blocked.");
                    break;
                }
            }

        }
    }
}
