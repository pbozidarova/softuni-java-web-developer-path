package A03_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class E08HandsOfCards {

//    You are given a sequence of people and for every person what cards he draws from the deck. The input will be
//    separate lines in the format:
//    {personName}: {PT, PT, PT,… PT}
//    Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type.
//    The input ends when a "JOKER" is drawn. The name can contain any ASCII symbol except ':'. The input will
//    always be valid and in the format described, there is no need to check it.
//    A single person cannot have more than one card with the same power and type, if he draws such a card
//    he discards it. The people are playing with multiple decks. Each card has a value that is calculated by the
//    power multiplied by the type. Powers 2 to 10 have the same value and J to A are 11 to 14. Types are mapped to
//    multipliers the following way (S -> 4, H-> 3, D -> 2, C -> 1).
//    Finally print out the total value each player has in his hand in the format:
//    {personName}: {value}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        while (!"JOKER".equals(input)){
            String name = input.substring(0, input.indexOf(":"));
            ArrayList<String> cards = Arrays.stream(input.substring(input.indexOf(":") + 2).split(",\\s+"))
                    .collect(Collectors.toCollection(ArrayList::new));

            if(!players.containsKey(name)){
                players.put(name,
                            new HashSet<>(){{addAll(cards);}}
                        );
            }else {
                players.get(name).addAll(cards);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, HashSet<String>> entry : players.entrySet()) {
            int deckPower = calculateDeckPower(entry.getValue());

            System.out.println(entry.getKey() + ": " + deckPower);
        }
    }

    private static int calculateDeckPower(HashSet<String> deck) {
        int sumPower = 0;

        for (String card : deck) {
            int power = 0;
            if(Character.isDigit(card.charAt(0)) && card.charAt(0) != '1'){
                power += card.charAt(0) - '0';
            }else {
                switch (card.charAt(0)){
                    case '1':
                        power+= 10;
                        break;
                    case 'J':
                        power += 11;
                        break;
                    case 'Q':
                        power += 12;
                        break;
                    case 'K':
                        power += 13;
                        break;
                    case 'A':
                        power += 14;
                        break;
                }
            }

            switch (card.charAt(card.length() - 1)){
                case 'S':
                    power *= 4;
                    break;
                case 'H':
                    power *= 3;
                    break;
                case 'D':
                    power *= 2;
                    break;
            }
            sumPower += power;
        }

        return sumPower;
    }
}
