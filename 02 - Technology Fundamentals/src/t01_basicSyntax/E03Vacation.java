package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E03Vacation {

//    You are given a group of people, type of the group, on which day of the week they are going to stay.
//    Based on that information calculate how much they have to pay and print that price on the console.
//    Use the table below. In each cell is the price for a single person. The output should look like that:
//        "Total price: {price}". The price should be rounded to the second decimal point.
//
//              Friday	Saturday	Sunday
//    Students	8.45	9.80	10.46
//    Business	10.90	15.60	16
//    Regular	15	    20	    22.50
//    There are also discounts based on some conditions:
//            •	Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
//            •	Business – if the group is bigger than or equal to  100 people 10 of them can stay for free.
//•	Regular – if the group is bigger than or equal 10 and less than or equal to 20 reduce the total price by 5%
//    You should reduce the prices in that EXACT order

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int totalNumberOfPeople = Integer.parseInt(reader.readLine());
        String groupType = reader.readLine();
        String dayOfWeek = reader.readLine();

        double singlePersonPrice = allocateSinglePrice(groupType, dayOfWeek);
        double discount = 0;

        if(groupType.equals("Students") && totalNumberOfPeople >= 30){
            discount += 0.15;
        }else if(groupType.equals("Business") && totalNumberOfPeople > 100){
            totalNumberOfPeople -= 10;
        }else if(groupType.equals("Regular") && (totalNumberOfPeople >= 10 && totalNumberOfPeople <=20)){
            discount += 0.05;
        }

        double totalPrice = singlePersonPrice * totalNumberOfPeople;
        totalPrice -= totalPrice * discount;

        System.out.printf("Total price: %.2f", totalPrice);

    }

    private static double allocateSinglePrice(String groupType, String dayOfWeek) {
        double[] students = {8.45, 9.80, 10.46};
        double[] business = {10.90, 15.60, 16};
        double[] regular = {15, 20, 22.50};

        List<String> indexDays = Arrays.asList(new String[]{"Friday", "Saturday", "Sunday"});

        double singlePrice = 0;
        switch (groupType){
            case "Students":
                singlePrice = students[indexDays.indexOf(dayOfWeek)];
                break;
            case "Business":
                singlePrice = business[indexDays.indexOf(dayOfWeek)];
                break;
            case "Regular":
                singlePrice = regular[indexDays.indexOf(dayOfWeek)];
                break;
            default:
                break;
        }

        return singlePrice;
    }

}
