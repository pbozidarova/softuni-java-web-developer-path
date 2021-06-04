package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E07VendingMachine {

//    You task is to calculate the total price of a purchase from a vending machine. Until you receive "Start" you
//    will be given different coins that are being inserted in the machine. You have to sum them in order to have
//    the total money inserted. There is a problem though. Your vending machine only works with 0.1, 0.2, 0.5, 1,
//    and 2 coins. If someone tries to insert some other coins you have to display "Cannot accept {money}",
//    where the value is formated to the second digit after the decimal point and not add it to the total money.
//    On the next few lines until you receive "End" you will be given products to purchase. Your machine has however
//        only "Nuts", "Water", "Crisps", "Soda", "Coke". The prices are: 2.0, 0.7, 1.5, 0.8, 1.0 respectively.
//    If the person tries to purchase a not existing product print “Invalid product”. Be careful that the person
//    may try to purchase a product for which he doesn't have money. In that case print "Sorry, not enough money".
//    If the person purchases a product successfully print "Purchased {product name}". After the “End” command print
//    the money that are left formatted to the second decimal point in the format "Change: {money left}".
//
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        List<Double> coins = new ArrayList(Arrays.asList(0.1, 0.2, 0.5, 1.0, 2.0));
        String input = "";
        double totalMoney = 0;

        while (!"Start".equals(input = reader.readLine())){
            double coin = Double.parseDouble(input);
            if(!coins.contains(coin)){
                System.out.println(String.format("Cannot accept %.2f", coin ));
            }else {
                totalMoney += coin;
            }
        }

        List<String> products = new ArrayList(Arrays.asList("Nuts", "Water", "Crisps", "Soda", "Coke"));
        double[] prices = new double[]{2.0, 0.7, 1.5, 0.8, 1.0};
        String product = "";

        while (!"End".equals(product = reader.readLine())){
            if(!products.contains(product)) {
                System.out.println("Invalid product");
                continue;
            }

            double price = prices[products.indexOf(product)];

            if(totalMoney - price >= 0){
                System.out.println("Purchased " + product);
                totalMoney -= price;
            }else {
                System.out.println("Sorry, not enough money");
            }
        }

        System.out.printf("Change: %.2f", totalMoney);
    }
}
