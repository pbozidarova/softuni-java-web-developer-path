package t08_associativeArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class E04Orders {
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
