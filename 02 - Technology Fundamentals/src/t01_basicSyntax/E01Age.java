package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E01Age {

//    Write a program that determines whether based on the given age a person is: baby, child, teenager, adult, elder.
//    The bounders are:
//  •	0-2 – baby;
//  •	3-13 – child;
//  •	14-19 – teenager;
//  •	20-65 – adult;
//  •	>=66 – elder;
//  •	All the values are inclusive.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        int age = Integer.parseInt(reader.readLine());

        if(age >= 0 && age <= 2){
            System.out.println("baby");
        }else if(age >= 3 && age <= 13){
            System.out.println("child");
        }else if(age >= 14 && age <= 19){
            System.out.println("teenager");
        }else if(age >= 20 && age <= 65){
            System.out.println("adult");
        }else {
            System.out.println("elder");
        }
    }
}
