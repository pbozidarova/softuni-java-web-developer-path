package techDemoPrep_06042019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e2_Deciphering {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String firstLine = reader.readLine();
        String[] secondLine = reader.readLine().split("\\s+");

        String regex = "^([d-zD-Z]*[{}\\\\|\\\\#]*)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstLine);

        if(matcher.find()){
            String decipheredString = "";
            for (int i = 0; i < firstLine.length(); i++) {
                char[] ch = Character.toChars(firstLine.charAt(i)-3);
                decipheredString += Character.toString(ch[0]);
            }

            System.out.println(decipheredString.replaceAll(secondLine[0], secondLine[1]));
        }else{
            System.out.println("This is not the book you are looking for.");
        }


    }
}
