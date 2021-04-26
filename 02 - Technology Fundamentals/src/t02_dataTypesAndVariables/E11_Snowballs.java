package t02_dataTypesAndVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E11_Snowballs {
//  Tony and Andi love playing in the snow and having snowball fights, but they always argue which makes the best snowballs. Тhey have decided to involve you in their fray, by making you write a program which calculates snowball data, and outputs the best snowball value.
//  You will receive N – an integer, the number of snowballs being made by Tony and Andi.
//  For each snowball you will receive 3 input lines:
//          •	On the first line you will get the snowballSnow – an integer.
//          •	On the second line you will get the snowballTime – an integer.
//          •	On the third line you will get the snowballQuality – an integer.
//  For each snowball you must calculate its snowballValue by the following formula:
//          (snowballSnow / snowballTime) ^ snowballQuality
//  At the end you must print the highest calculated snowballValue.

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in)
                );
        int n = Integer.parseInt(reader.readLine());
        long snowBallValueMax = 0;

        int snowBallSnowOutput = 0;
        int snowBallTimeOutput = 0;
        int snowBallQalityOutput = 0;

        for (int i = 0; i < n; i++) {
            int snowBallSnow = Integer.parseInt(reader.readLine());
            int snowBallTime = Integer.parseInt(reader.readLine());
            int snowBallQuality = Integer.parseInt(reader.readLine());

            long snowBallValue =
                    (long) Math.pow(snowBallSnow / snowBallTime, snowBallQuality);

            if (snowBallValue > snowBallValueMax) {
                snowBallValueMax = snowBallValue;
                snowBallSnowOutput = snowBallSnow;
                snowBallTimeOutput = snowBallTime;
                snowBallQalityOutput = snowBallQuality;
            }
        }
        System.out.println(String.format("%d : %d = %d (%d)",
                snowBallSnowOutput, snowBallTimeOutput, snowBallValueMax, snowBallQalityOutput)
        );
    }

}
