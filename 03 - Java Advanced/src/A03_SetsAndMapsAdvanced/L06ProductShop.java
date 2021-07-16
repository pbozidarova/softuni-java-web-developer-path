package A03_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L06ProductShop {

//    Write a program that prints information about food shops in Sofia and the products they store. Until the "Revision" command you will receive an input in the format: "{shop}, {product}, {price}"
//    Take in mind that if you receive a shop you already have received, you must collect its product information.
//    Your output must be ordered by shop name and must be in the format:
//    {shop}->
//    Product: {product}, Price: {price}
//    The price should be formated to one digit after the decimal point.


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Map<String, Map<String, Double>> shop = new TreeMap<>();
        while(!"Revision".equals(input = scanner.nextLine()) ){
            String[] tokens = input.split(",\\s+");

            String shopName = tokens[0];
            String productName = tokens[1];
            Double productPrice = Double.parseDouble(tokens[2]);

            shop.putIfAbsent(shopName, new LinkedHashMap<>());
            shop.get(shopName).putIfAbsent(productName, productPrice);

        }

        shop.forEach((shopName, products) ->{
            System.out.println(shopName + "->");
            products.forEach((productName, productPrice) ->{
                System.out.println(String.format(
                        "Product: %s, Price: %.1f", productName, productPrice));
            });
        });
    }
}
