package t01_basic_Syntax;

public class L08DivisibleBy3 {
//8.  Divisible by 3
//    Write a program, which prints all the numbers from 1 to 100, which are divisible by 3.
//    You have to use a single for loop. The program should not receive input.

    public static void main(String[] args) {
        for (int i = 3; i <= 100; i+=3) {
            System.out.println(i);
        }
    }

}