package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E04PasswordValidator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String password = reader.readLine();

        if(!isInRange(password)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if(!isLetterOrDigit(password)){
            System.out.println("Password must consist only of letters and digits");
        }
        if(!haveAtLeast2Digits(password)){
            System.out.println("Password must have at least 2 digits");
        }
        if(isInRange(password) && isLetterOrDigit(password) && haveAtLeast2Digits(password)){
            System.out.println("Password is valid");
        }
    }

    private static boolean haveAtLeast2Digits(String password){
        int count = 0;
        for (int i = 0; i < password.length() ; i++) {
            if(Character.isDigit(password.charAt(i))){
                count++;
            }
        }
        if (count < 2 ) {
            return false;
        }else{
            return true;
        }

    }

    private static boolean isLetterOrDigit(String password){
        for (int i = 0; i < password.length(); i++) {
            if(!Character.isLetterOrDigit(password.charAt(i))){
                return false;
            }

        }
        return true;
    }

    private static boolean isInRange(String password){
        if(password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return  false;
        }
    }
}
