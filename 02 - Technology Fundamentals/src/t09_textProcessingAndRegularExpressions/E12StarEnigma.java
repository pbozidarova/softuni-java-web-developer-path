package t09_textProcessingAndRegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12StarEnigma {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        Pattern pattern = Pattern.compile("[star]", Pattern.CASE_INSENSITIVE);

        while (n-- > 0){
            String encryptedMessage = reader.readLine();

            Matcher matcher = pattern.matcher(encryptedMessage);

            int countLetters = 0;
            while (matcher.find()){
                countLetters++;
            }

            StringBuilder decryptedMessage = new StringBuilder();
            for (int i = 0; i < encryptedMessage.length(); i++) {
                decryptedMessage.append(String.valueOf(
                        Character.toChars(
                                encryptedMessage.charAt(i) - countLetters)
                ));
            }

            Pattern patternPlanets = Pattern.compile("@([A-Z][a-z]+)(?:[^@!\\-:>]*):(\\d+)(?:[^@!\\-:>]*)!([AD])!(?:[^@!\\-:>]*)->(\\d+)");
            Matcher matcherPlanets = patternPlanets.matcher(decryptedMessage.toString());

            while (matcherPlanets.find()){
                String planetName = matcherPlanets.group(1);
                String attackType = matcherPlanets.group(3);

                if(attackType.equals("A")){
                    attackedPlanets.add(planetName);
                }else {
                    destroyedPlanets.add(planetName);
                }
            }
        }

        System.out.println(String.format("Attacked planets: %d", attackedPlanets.size()));
        attackedPlanets.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .forEach(e -> {
                    System.out.println(String.format("-> %s", e));
                });

        System.out.println(String.format("Destroyed planets: %d", destroyedPlanets.size()));
        destroyedPlanets.stream()
                .sorted((e1, e2) -> e1.compareTo(e2))
                .forEach(e -> {
                    System.out.println(String.format("-> %s", e));
                });


    }
}
