package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E10Pokemon {

//  A Poke Mon is a special type of pokemon which likes to Poke others. But at the end of the day, the Poke Mon wants
//  to keeps statistics, about how many pokes it has managed to make.
//  The Poke Mon pokes his target, and then proceeds to poke another target. The distance between his targets reduces
//  his poke power.
//  You will be given the poke power the Poke Mon has, N – an integer.
//  Then you will be given the distance between the poke targets, M – an integer.
//  Then you will be given the exhaustionFactor Y – an integer.
//  Your task is to start subtracting M from N until N becomes less than M, i.e. the Poke Mon does not have enough
//  power to reach the next target.
//  Every time you subtract M from N that means you’ve reached a target and poked it successfully. COUNT how many
//  targets you’ve poked – you’ll need that count.
//  The Poke Mon becomes gradually more exhausted. IF N becomes equal to EXACTLY 50 % of its original value, you must
//  divide N by Y, if it is POSSIBLE. This DIVISION is between integers.
//  If a division is not possible, you should NOT do it. Instead, you should continue subtracting.
//  After dividing, you should continue subtracting from N, until it becomes less than M.
//  When N becomes less than M, you must take what has remained of N and the count of targets you’ve poked,
//  and print them as output.

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader (
                        new InputStreamReader(
                                System.in
                        )
                );
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        int Y = Integer.parseInt(reader.readLine());

        int counter = 0;
        double half = N /2;

        while(N >= M) {
            counter++;
            N -= M;

            if( half == N && Y > 0 ) N /= Y;

        }
        System.out.println(String.format("%d%n%d", N, counter));

    }
}
