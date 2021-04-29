package t04_methods;

import java.util.Scanner;

public class L02Grades {
//    Write a method that receives a grade between 2.00 and 6.00 and prints the corresponding grade in words
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());

        gradeAsWord(number);
    }
    static void gradeAsWord(double grade){
        if( grade >= 2 && grade < 3  ) {
            System.out.println("Fail");
        }else if(grade >= 3 && grade < 3.50 ){
            System.out.println("Poor");
        }else if(grade >= 3.5 && grade < 4.5 ){
            System.out.println("Good");
        }else if(grade >= 4.5 && grade < 5.5 ){
            System.out.println("Very good");
        }else if(grade >= 5.5 && grade <= 6 ) {
            System.out.println("Excellent");
        }
    }
}
