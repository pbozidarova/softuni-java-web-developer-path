package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class L05Orders {
//    Write a method that calculates the total price of an order and prints it on the console.
//    The method should receive one of the following products: coffee, coke, water, snacks; and a
//    quantity of the product. The prices for a single piece of each product are:

//    •	coffee – 1.50
//    •	water – 1.00
//    •	coke – 1.40
//    •	snacks – 2.00

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        String product = reader.readLine();
        int quantity = Integer.parseInt(reader.readLine());

        List<String> products = Arrays.stream(new String[]{"coffee",  "water", "coke", "snacks"}).collect(Collectors.toList());
        double[] prices = {1.5, 1.0, 1.4, 2.0};

        System.out.printf("%.2f", prices[products.indexOf(product)] * quantity);

    }

}
