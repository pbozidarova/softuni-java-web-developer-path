package t03_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E09KaminoFactory {
//  The clone factory in Kamino got another order to clone troops. But this time you are tasked to find the best
//  DNA sequence to use in the production.
//  You will receive the DNA length and until you receive the command "Clone them!" you will be receiving a DNA
//  sequences of ones and zeroes, split by "!" (one or several).
//  You should select the sequence with the longest subsequence of ones. If there are several sequences with same
//  length of subsequence of ones, print the one with the leftmost starting index, if there are several sequences
//  with same length and starting index, select the sequence with the greater sum of its elements.
//  After you receive the last command "Clone them!" you should print the collected information in the following
//  format:
//          "Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
//          "{DNA sequence, joined by space}"

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        String input = "";
        int bestSequenceIndex = Integer.MAX_VALUE;
        int bestSequenceSum = 0;
        int bestSequenceIndexRow = 0;
        int bestSequenceIndexRowOutput = 0;
        String sequenceOutput = "";

        while (!"Clone them!".equals(input = reader.readLine())) {
            ++bestSequenceIndexRow;
            String[] data = Arrays.stream(input.split("!+"))
                    .filter(e -> !e.equals(""))
                    .toArray(String[]::new);
            
            int[] sequenceDNA = new int[size];

            int index = 0;
            for (int i = 0; i < data.length; i++) {
                sequenceDNA[index++] = Integer.parseInt(data[i]);
            }

            int maxCount = 0;
            int sequenceIndex = 0;
            for (int i = 0; i < sequenceDNA.length; i++) {
                int currCont = 0;
                for (int j = i; j < sequenceDNA.length; j++) {
                    if (sequenceDNA[i] == sequenceDNA[j]) {
                        currCont++;
                        if (currCont > maxCount) {
                            maxCount = currCont;
                            sequenceIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }

            int sequenceSum = 0;
            for (int i = 0; i < sequenceDNA.length; i++) {
                if (sequenceDNA[i] == 1) {
                    sequenceSum += sequenceDNA[i];
                }
            }

            if (sequenceIndex < bestSequenceIndex || sequenceSum > bestSequenceSum) {
                sequenceOutput = " ";
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sequenceSum;
                bestSequenceIndexRowOutput = bestSequenceIndexRow;
                for (int i = 0; i < sequenceDNA.length; i++) {
                    sequenceOutput += sequenceDNA[i] + " ";
                }

            }
        }
        System.out.println(String.format("Best DNA sample %d with sum: %d.", bestSequenceIndexRowOutput, bestSequenceSum));
        System.out.println(sequenceOutput.trim());
    }
}
