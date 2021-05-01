package techMidPrep_02032019;

import java.util.*;
import java.util.stream.Collectors;

public class e3_CookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Integer maxSum = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        Double maxAverage = Double.MIN_VALUE;
        String output = "";

        String input = "";
        while(!"Bake It!".equals(input = scanner.nextLine())){
            String[] batches = input.split("\\#");
            Integer batchSum = 0;

            for (String batch : batches) {
                batchSum += Integer.parseInt(batch);
            }

            //batchSum = Arrays.stream(batches).mapToDouble(d->Double.parseDouble(d)).sum();
            int batchLength = batches.length;
            double batchAverage = batchSum/batchLength;

            if (batchSum > maxSum) {
                maxSum = batchSum;
                maxAverage = batchAverage;
                minLength = batchLength;
                output = getString(batches);

            } else if(batchSum == maxSum && batchAverage > maxAverage){
                    maxSum = batchSum;
                    maxAverage = batchAverage;
                    minLength = batchLength;
                    output = getString(batches);

            } else if (batchSum == maxSum && batchAverage == maxAverage){
                   if(batchLength < minLength){
                        maxSum = batchSum;
                        maxAverage = batchAverage;
                        minLength = batchLength;
                        output = getString(batches);
                    }
            }
        }
        System.out.print(String.format("Best Batch quality: %d%n", maxSum));
        System.out.println(output);
    }

    private static String getString(String[] batches) {
        String output;
        output = "";
        for (int i = 0; i < batches.length; i++) {
            output += batches[i] + " ";
        }
        return output;
    }

}
