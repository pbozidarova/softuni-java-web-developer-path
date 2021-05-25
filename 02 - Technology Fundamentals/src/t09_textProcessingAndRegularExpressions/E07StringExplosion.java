package t09_textProcessingAndRegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E07StringExplosion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String text = reader.readLine();
        String result = "";
        int strength = 0;

        for (int i = 0; i < text.length(); i++) {
            result += text.charAt(i);

            if (text.charAt(i) == '>'){
                strength += Integer.parseInt(
                        String.valueOf(text.charAt(i + 1))
                );

            }

            while (strength > 0){
                strength--;
                i++;

                if( i + 1 >= text.length() || text.charAt(i + 1) == '>'){
                    break;
                }
            }

//            result += text.charAt(i);
        }

        System.out.println(result);

    }
}
