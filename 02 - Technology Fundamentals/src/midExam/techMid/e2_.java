package techMid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e2_ {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] items = reader.readLine().split("\\|");

        Double budget = Double.parseDouble(reader.readLine());
        Double sumNewPrices = 0.0;
        Double profit = 0.0;
        List<Double> profitPrices = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            String item = items[i].split("->")[0];
            Double itemPrice = Double.parseDouble(items[i].split("->")[1]);

            switch (item){
                case "Clothes":
                    if(itemPrice <= 50 && budget - itemPrice >= 0){
                       budget -= itemPrice;
                        profit += 0.4 * itemPrice;
                        itemPrice += 0.4* itemPrice;
                        sumNewPrices += itemPrice;
                        profitPrices.add(itemPrice);
                    }
                    break;
                case "Shoes":
                    if(itemPrice <= 35 && budget - itemPrice >= 0){
                        budget -= itemPrice;
                        profit += 0.4 * itemPrice;
                        itemPrice += 0.4* itemPrice;
                        sumNewPrices += itemPrice;
                        profitPrices.add(itemPrice);
                    }
                    break;
                case "Accessories":
                    if(itemPrice <= 20.50 && budget - itemPrice >= 0){
                        budget -= itemPrice;
                        profit += 0.4 * itemPrice;
                        itemPrice += 0.4* itemPrice;
                        sumNewPrices += itemPrice;
                        profitPrices.add(itemPrice);
                    }
                    break;
            }
        }
        String output = "";

        for (int i = 0; i < profitPrices.size(); i++) {
           output += String.format("%.2f ",profitPrices.get(i));
        }
        System.out.println(output);
        System.out.printf("Profit: %.2f%n", profit);
        if(sumNewPrices + budget>= 150 ){
            System.out.println("Hello, France!");
        }else{
            System.out.println("Time to go.");
        }

    }

}
