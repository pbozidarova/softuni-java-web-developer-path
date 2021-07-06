package t04_methods;

import java.util.Scanner;

public class L06CalculateRectangleArea {
//    Create a method that calculates and returns the area of a triangle by given width and length:
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

//        double area = calcArea(width,height);

        System.out.print(calcArea(width,height));
    }

    static int calcArea(double width, double height) {
        double result = width *height;
        String formatRes = String.format("%.0f",result);
        int res = Integer.parseInt(formatRes);
        return res;
    }

}
