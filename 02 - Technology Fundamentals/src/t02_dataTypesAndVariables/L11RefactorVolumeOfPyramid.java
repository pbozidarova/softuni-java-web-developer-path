package t02_dataTypesAndVariables;

import java.util.Scanner;

public class L11RefactorVolumeOfPyramid {

//    You are given a working code that is a solution to Problem 9. Special Numbers. However, the variables are improperly named, declared before they are needed and some of them are used for multiple things. Without using your previous solution, modify the code so that it is easy to read and understand.
//•	Reduce the span of the variables by declaring them in the moment they receive a value, not before
//•	Rename your variables to represent their real purpose (example: "dul" should become length, etc.)
//•	Search for variables that have multiple purpose. If you find any, introduce a new variable.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double length, width, height = 0;
        System.out.print("Length: ");
        length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        height = Double.parseDouble(scanner.nextLine());

        System.out.printf("Pyramid Volume: %.2f",
                (length * width * height) / 3);


    }

}
