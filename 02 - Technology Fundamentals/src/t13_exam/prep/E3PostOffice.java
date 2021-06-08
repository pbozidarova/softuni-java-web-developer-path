package t13_exam.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E3PostOffice {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String[] encryptedMessage = reader.readLine().split("\\|");

        String fEncryptedMessage = encryptedMessage[0];
        String sEncryptedMessage = encryptedMessage[1];
        String tEncryptedMessage = encryptedMessage[2];

        String firstRegex = "[#$%*&](?<letters>[A-Z]+)\\1";
        Pattern firstPattern = Pattern.compile(firstRegex);
        Matcher firstMatch = firstPattern.matcher(fEncryptedMessage);

        String secondRegex = "(?<asciiCode>\\d{2}):(?<length>\\d{2})";
        Pattern secondPattern = Pattern.compile(secondRegex);
        Matcher secondMatch = secondPattern.matcher(sEncryptedMessage);

        String thirdRegex = "|[^\s]+";


        String letters = "";
        while (firstMatch.find()){
            letters += firstMatch.group("letters");
        }

        LinkedHashMap<String, Integer> matches = new LinkedHashMap<>();

        for (int i = 0; i < letters.length(); i++) {
            matches.put(String.valueOf(letters.charAt(i)), 0);
        }

        if(!letters.equals("")){
            while(secondMatch.find()){
                String asciiCodeSymbol = String.valueOf(Character.toChars(
                        Integer.parseInt(secondMatch.group("asciiCode"))));

                int length = Integer.parseInt(secondMatch.group("length"));

                if(matches.containsKey(asciiCodeSymbol)){
                    matches.put(asciiCodeSymbol, length);
                }
           }

            matches.forEach((ascii, length) -> {
                Arrays.stream(tEncryptedMessage.split("\\s+"))
                        .forEach(word -> {
                            if(word.length() == length +1 &&
                                    String.valueOf(word.charAt(0)).equals(ascii)){
                                System.out.println(word);
                            }
                        });
            });
        }
    }
}
