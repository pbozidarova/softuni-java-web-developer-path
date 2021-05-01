package techFinal_14042019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class e1_ {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(^[\\w\\!\\@\\#\\$\\?]+)=([1-9])+<<";
        Pattern pattern = Pattern.compile(regex);

        String input = "";
        while (!"Last note".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                Integer length = Integer.parseInt(input.split("=")[1].split("<<")[0]);
                String geohashcode = input.split("=")[1].split("<<")[1];

                if (geohashcode.length() == length) {
                    String mountainEncr = input.split("=")[0];
                    String mountain = "";

                    for (int i = 0; i < mountainEncr.length(); i++) {
                        if (Character.isLetterOrDigit(mountainEncr.charAt(i))) {
                            mountain += mountainEncr.charAt(i);
                        }
                    }
                    System.out.printf("Coordinates found! %s -> %s%n", mountain, geohashcode);
                } else {
                    System.out.println("Nothing found!");
                }
            }else{
                System.out.println("Nothing found!");
            }

        }
    }
}