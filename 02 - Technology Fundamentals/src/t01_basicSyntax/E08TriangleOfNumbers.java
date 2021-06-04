package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E08TriangleOfNumbers {

//    Write a program, which receives a number – n, and prints a triangle from 1 to n.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );
        
        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
}
