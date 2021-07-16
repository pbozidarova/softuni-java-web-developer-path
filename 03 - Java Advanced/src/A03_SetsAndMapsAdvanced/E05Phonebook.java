package A03_SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeMap;

public class E05Phonebook {

//    Write a program that receives some info from the console about people and their phone numbers.
//    You are free to choose the manner in which the data is entered; each entry should have just one name and one
//    number (both of them strings). If you receive a name that already exists in the phonebook, simply update its number.
//    After filling this simple phonebook, upon receiving the command "search", your program should be able to
//    perform a search of a contact by name and print her details in format "{name} -> {number}". In case the
//    contact isn't found, print "Contact {name} does not exist." Examples:

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        TreeMap<String, String> phonebook = new TreeMap<>();

        while (!"search".equals(input = scanner.nextLine())){
            phonebook
                .put(input.split("-")[0], input.split("-")[0]);
        }
    }
}
