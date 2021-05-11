package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E04Orders {
//    Write a program, which keeps information about products and their prices. Each product has a name,
//    a price and its quantity. If the product doesn’t exist yet, add it with its starting quantity.
//    If you receive a product, which already exists increase its quantity by the input quantity and if its price
//    is different, replace the price as well.
//    You will receive products’ names, prices and quantities on new lines. Until you receive the command "buy",
//    keep adding items. When you do receive the command "buy", print the items with their names and total price of
//    all the products with that name.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        LinkedHashMap<String, Double[]> products = new LinkedHashMap<>();

        String input = "";

        while(!"buy".equals(input = reader.readLine())){
            String product = input.split("\\s+")[0];
            Double price = Double.parseDouble(input.split("\\s+")[1]);
            Double quantity = Double.parseDouble(input.split("\\s+")[2]);

            Double[] priceQuant = { price, quantity};

            if(!products.containsKey(product)){
                products.put(product, priceQuant);
            }else{
                //if(price != products.get(product)[0]) price = price;
                Double[] newPriceQuant = {price, products.get(product)[1] + quantity};
                products.put(product, newPriceQuant );
            }
        }

        products.entrySet().stream().forEach(e -> {
            System.out.println(String.format("%s -> %.2f", e.getKey(), (e.getValue()[0]*e.getValue()[1])));

        });


    }
}
