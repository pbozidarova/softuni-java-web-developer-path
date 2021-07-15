package A03_SetsAndMapsAdvanced;

import java.util.*;

public class L02SoftUniParty {

//    There is a party in SoftUni. Many guests are invited and they are two types: VIP and regular.
//    When guest come check if he/she exist in any of two reservation lists.
//    All reservation numbers will be with 8 chars.
//    All VIP numbers start with digit.
//    There will be 2 command lines. First is "PARTY" - party is on and guests start coming.
//    Second is "END" – then party is over and no more guest will come.
//    Output shows all guests, who didn't come to the party (VIP must be first).


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String input;

        while (!"PARTY".equals(input = scanner.nextLine())){
            if(input.length() != 8){
                continue;
            }
            if(Character.isDigit(input.charAt(0))){
                vipGuests.add(input);
            }else {
                regularGuests.add(input);
            }
        }

        while (!"END".equals(input = scanner.nextLine())){
            if(Character.isDigit(input.charAt(0))){
                vipGuests.remove(input);
            }else {
                regularGuests.remove(input);
            }
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        vipGuests.forEach(System.out::println);
        regularGuests.forEach(System.out::println);
    }

}

