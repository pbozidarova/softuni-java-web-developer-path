package A03_SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class L01ParkingLot {
//    Write program that:
//•	Record car number for every car that enter in parking lot
//•	Remove car number when the car go out
//•	Input will be string in format [direction, carNumber]
//•	input end with string "END"


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parkingLot = new LinkedHashSet<>();

        String input;

        while(!"END".equals(input = scanner.nextLine())){
            String[] tokens = input.split(",\\s+");

            String command = tokens[0];
            String value = tokens[1];

            switch (command) {
                case "IN":
                    parkingLot.add(value);
                    break;
                case "OUT":
                    parkingLot.remove(value);
                    break;
            }
        }


//        if(!parkingLot.isEmpty()){
//
//            for (String s : parkingLot) {
//                System.out.println(s);
//            }
//        }else {
//            System.out.println("Parking Lot is Empty");
//        }

//        parkingLot.forEach(System.out::println);

//        System.out.println(String.join(System.lineSeparator(), parkingLot));

        System.out.println(parkingLot.isEmpty()
                                ? "Parking Lot is Empty"
                                : String.join(System.lineSeparator(), parkingLot));
    }
}
