package t01_basicSyntax;

import java.util.Scanner;

public class L07TheatrePromotions {
// 7.	Theatre Promotions
//    A theatre is doing a ticket sale, but they need a program to calculate the price
//    of a single ticket. If the given age does not fit one of the categories,
//    you should print "Error!".  You can see the prices in the table below:

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        if(age >= 0 && age <= 18){
            daySwitch(dayType, 0);
        }else if(age > 18 && age <= 64){
            daySwitch(dayType, 1);
        }else if(age > 64 && age <= 122){
            daySwitch(dayType, 2);
        }else {
            System.out.println("Error!");
        }

    }

    private static void daySwitch(String dayType, int ageGroupIndex) {
        String result = "";
        String[] weekday = {"12", "18", "12"};
        String[] weekend = {"15", "20", "15"};
        String[] holiday = {"5", "12", "10"};

        switch (dayType){
            case "Weekday":
                result = weekday[ageGroupIndex];
                break;
            case "Weekend":
                result = weekend[ageGroupIndex];
                break;
            case "Holiday":
                result = holiday[ageGroupIndex];
                break;
            default:
                break;
        }
        System.out.println(result + "$");
    }
}
