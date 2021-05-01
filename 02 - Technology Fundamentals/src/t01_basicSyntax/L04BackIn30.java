package t01_basic_Syntax;

import java.util.Scanner;

public class L04BackIn30 {
//4.	Back in 30 Minutes
//   Every time Stamat tries to pay his bills he sees on the cash desk the sign:
//   "I will be back in 30 minutes". One day Stamat was sick of waiting and decided
//   he needs a program, which prints the time after 30 minutes. That way he won’t have
//   to wait on the desk and come at the appropriate time. He gave the assignment to you,
//   so you have to do it.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = hours * 60 + minutes + 30;
        //125 2:5
        int rHours = (totalMinutes / 60) >= 24 ? 0 : totalMinutes / 60;
        int rMinutes = totalMinutes % 60;
        System.out.printf("%d:%02d", rHours, rMinutes);
    }
}
