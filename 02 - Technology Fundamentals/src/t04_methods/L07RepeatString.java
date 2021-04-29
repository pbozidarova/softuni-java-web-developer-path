package t04_methods;

import java.util.Scanner;

public class L07RepeatString {
//    Write a method that receives a string and a repeat count n (integer). The method should return a new string (the old one repeated n times)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());
        System.out.println(repeatString(text,count));
    }

    static String repeatString(String text, int count){
        String result = "";
        for (int i = 0; i <  count; i++) {
            result += text;
        }
        return  result;
    }
}
