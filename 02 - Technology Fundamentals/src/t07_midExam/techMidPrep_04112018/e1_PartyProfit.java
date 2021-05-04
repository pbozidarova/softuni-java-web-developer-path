package techMidPrep_04112018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class e1_PartyProfit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int partySize = Integer.parseInt(reader.readLine());
        int days = Integer.parseInt(reader.readLine());

        int amount = 0;

        for (int i = 1; i <= days; i++) {
            if(i % 10 == 0) partySize -=2;
            if(i % 15 == 0) partySize +=5;

            amount += (50 - 2*partySize);

            if(i % 3 == 0) amount -=3*partySize;
            if(i % 5 == 0) amount +=20*partySize;
            if(i % 3 == 0 && i % 5 == 0) amount -=2*partySize
                    ;
        }

        System.out.printf("%d companions received %d coins each.", partySize, amount/partySize);
    }
}
