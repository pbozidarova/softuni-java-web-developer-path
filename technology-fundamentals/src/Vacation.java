import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vacation {
    public static void main(String[] args) throws IOException {
//        3.	Vacation
//        You are given a group of people, type of the group, on which day of the week they are going to stay.
//        Based on that information calculate how much they have to pay and print that price on the console.
//        Use the table below. In each cell is the price for a single person.
//        The output should look like that: "Total price: {price}". The price should be rounded to the second decimal point.
//                Friday	Saturday	Sunday
//        Students	8.45	9.80        10.46
//        Business	10.90	15.60       16
//        Regular	15	    20	        22.50
//        There are also discounts based on some conditions:
//•	Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
//•	Business – if the group is bigger than or equal to  100 people 10 of them can stay for free.
//•	Regular – if the group is bigger than or equal 10 and less than or equal to 20 reduce the total price by 5%
//                You should reduce the prices in that EXACT order
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        int groupNumber = Integer.parseInt(reader.readLine());
        String groupType = reader.readLine();
        String dayOfTheWeek = reader.readLine();
        Double[] studentsPrice = {8.45, 9.80, 10.46};
        Double[] businessPrice = {10.9, 15.6, 16.0};
        Double[] regularPrice = {15.0, 20.0, 22.5};

        Double totalDue = 0.0;
        switch (groupType){
            case "Students":
                totalDue = calculatePrice(studentsPrice, groupNumber, dayOfTheWeek);
                if(groupNumber >= 30) totalDue -= totalDue * 0.15;
                break;
            case "Business":
                if(groupNumber >= 100) groupNumber -= 10;
                totalDue = calculatePrice(businessPrice, groupNumber, dayOfTheWeek);
                break;
            case "Regular":
                totalDue = calculatePrice(regularPrice, groupNumber, dayOfTheWeek);
                if(groupNumber >= 10 && groupNumber <= 20) totalDue -= totalDue * 0.05;
                break;
            default:
                break;
        }

        System.out.printf("Total price: %.2f", totalDue);

    }

    private static Double calculatePrice(Double[] prices, int groupNumber, String dayOfTheWeek) {
        switch (dayOfTheWeek){
            case "Friday":
                return prices[0] * groupNumber;
            case "Saturday":
                return prices[1] * groupNumber;
            case "Sunday":
                return prices[2] * groupNumber;
            default:
                return null;
        }
    }
}
