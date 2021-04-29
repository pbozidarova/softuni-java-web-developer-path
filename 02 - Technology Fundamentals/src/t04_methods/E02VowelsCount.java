package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02VowelsCount {
//    Write a method that receives a single string and prints the count of the vowels. Use appropriate name for the method.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();
        vowelsCount(input);

    }

    static void vowelsCount (String name){
        int count = 0;
        for (int i = 0; i < name.length() ; i++) {
            if( name.charAt(i) == 'a' ||
                    name.charAt(i) == 'e' ||
                    name.charAt(i) == 'i' ||
                    name.charAt(i) == 'o' ||
                    name.charAt(i) == 'u' ){
                count ++;
            }
        }
        System.out.println(count);
    }

}
