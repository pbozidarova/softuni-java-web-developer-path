package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E09RageExpenses {

//    As a MOBA challenger player, Pesho has the bad habit to trash his PC when he loses a game and rage quits.
//    His gaming setup consists of headset, mouse, keyboard and display. You will receive Pesho`s lost games count.
//    Every second lost game, Pesho trashes his headset.
//    Every third lost game, Pesho trashes his mouse.
//    When Pesho trashes both his mouse and headset in the same lost game, he also trashes his keyboard.
//    Every second time, when he trashes his keyboard, he also trashes his display.
//    You will receive the price of each item in his gaming setup. Calculate his rage expenses
//    for renewing his gaming equipment.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int lostGamesCount = Integer.parseInt(reader.readLine());
        double headsetPrice = Double.parseDouble(reader.readLine());
        double mousePrice = Double.parseDouble(reader.readLine());
        double keyboardPrice = Double.parseDouble(reader.readLine());
        double displayPrice = Double.parseDouble(reader.readLine());

        double rageExpenses = (lostGamesCount / 2) * headsetPrice +
                (lostGamesCount / 3) * mousePrice +
                (lostGamesCount / 6) * keyboardPrice +
                (lostGamesCount / 12) * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);

    }

}
