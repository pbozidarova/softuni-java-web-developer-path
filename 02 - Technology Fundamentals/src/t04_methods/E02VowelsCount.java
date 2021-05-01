package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E02VowelsCount {
//  Write a method that receives a single string and prints the count of the vowels. Use appropriate name for the method.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        String input = reader.readLine().toLowerCase();
//        vowelsCount(input);
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if(isVowel2(input.charAt(i))){
                count++;
            }
        }

        System.out.println(count);
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

    static boolean isVowel(char symbol){
//        return "aeoiuy".contains( String.valueOf(symbol));
        return "aeoiuy".indexOf(symbol) > 0;

    }

    static boolean isVowel2(char symbol){
        switch (symbol){
            case 'a':
            case 'e':
            case 'o':
            case 'i':
            case 'u':
            case 'y':
                return true;
        }

        return false;
    }
}
