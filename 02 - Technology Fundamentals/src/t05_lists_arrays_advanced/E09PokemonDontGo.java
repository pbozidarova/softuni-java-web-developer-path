package t05_lists_arrays_advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class E09PokemonDontGo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> pokemons = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sumPokemons = 0;

        while (pokemons.size() > 0) {
            int index = Integer.parseInt(reader.readLine());
            int caughtPokemon = 0;

            if (index < 0) {
                caughtPokemon = pokemons.get(0);
                pokemons.set(0, pokemons.get(pokemons.size() - 1));
            } else if (index > pokemons.size() - 1) {
                caughtPokemon = pokemons.get(pokemons.size() - 1);
                pokemons.set(pokemons.size() - 1, pokemons.get(0));
            } else {
                caughtPokemon = pokemons.get(index);
                pokemons.remove(index);
            }

            sumPokemons += caughtPokemon;

            for (int i = 0; i < pokemons.size(); i++) {
                if (pokemons.get(i) <= caughtPokemon) {
                    pokemons.set(i, pokemons.get(i) + caughtPokemon);
                } else {
                    pokemons.set(i, pokemons.get(i) - caughtPokemon);
                }
            }

        }

        System.out.println(sumPokemons);

    }
}