package t09_textProcessingAndRegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02CharacterMultiplier {
//    Create a method that takes two strings as arguments and returns the sum of
//    their character codes multiplied (multiply str1[0] with str2[0] and add to the
//    total sum). Then continue with the next two characters. If one of the strings is
//    longer than the other, add the remaining character codes to the total sum without
//    multiplication.

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String text = reader.readLine();
        String firstWord = text.substring(0, text.indexOf(' '));
        String secondWord = text.substring(text.indexOf(' ')+1);


        System.out.println(multiplyCharacters(firstWord, secondWord));

    }

    private static int multiplyCharacters(String first, String second){
        int minLength = Math.min(first.length(), second.length());
        int sum = 0;

        for (int i = 0; i < minLength; i++) {
            sum += first.charAt(i) * second.charAt(i);
        }

        String maxLength = first.length() < second.length() ? second : first;

        for (int i = minLength; i < maxLength.length(); i++) {
            sum += maxLength.charAt(i);
        }

        return sum;

    }
}
