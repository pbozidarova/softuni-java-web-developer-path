package t05_lists_arrays_advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E06CardsGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        List<Integer> firstPlayersCards = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayersCards = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (!(firstPlayersCards.size() == 0 || secondPlayersCards.size() == 0)){
            if ( firstPlayersCards.get(0) > secondPlayersCards.get(0) ){
                firstPlayersCards.add(firstPlayersCards.get(0));
                firstPlayersCards.add(secondPlayersCards.get(0));

            }else if(firstPlayersCards.get(0) < secondPlayersCards.get(0)) {
                secondPlayersCards.add(secondPlayersCards.get(0));
                secondPlayersCards.add(firstPlayersCards.get(0));
            }

            firstPlayersCards.remove(0);
            secondPlayersCards.remove(0);
        }

        if(firstPlayersCards.size() > secondPlayersCards.size()){
            int sum = firstPlayersCards.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("First player wins! Sum: %d", sum);
        }else {
            int sum = secondPlayersCards.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("Second player wins! Sum: %d", sum);
        }

    }
}
