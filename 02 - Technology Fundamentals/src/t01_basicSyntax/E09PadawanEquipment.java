package t01_basicSyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E09PadawanEquipment {

//    Yoda is starting his newly created Jedi academy. So, he asked master Ivan Cho to buy the needed equipment.
//    The number of items depends on how many students will sign up. The equipment for the Padawan contains lightsabers,
//    belts and robes.
//    You will be given the amount of money Ivan Cho has, the number of students and the prices of each item.
//    You have to help Ivan Cho calculate if the money he has is enough to buy all of the equipment,
//    or how much more money he needs.
//    Because the lightsabres sometimes brake, Ivan Cho should buy 10% more, rounded up to the next integer.
//    Also, every sixth belt is free.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (
                new InputStreamReader(
                        System.in
                )
        );

        double amountOfMoney = Double.parseDouble(reader.readLine());
        int countOfStudents = Integer.parseInt(reader.readLine());
        double priceOfLightsaber = Double.parseDouble(reader.readLine());
        double priceOfRobe = Double.parseDouble(reader.readLine());
        double priceOfBelt = Double.parseDouble(reader.readLine());

        double neededMoney = (countOfStudents + Math.ceil(countOfStudents * 0.1)) * priceOfLightsaber +
                countOfStudents * priceOfRobe +
                (countOfStudents - countOfStudents / 6) * priceOfBelt;

        if(amountOfMoney >= neededMoney){
            System.out.printf("The money is enough - it would cost %.2flv.", neededMoney);
        }else {
            System.out.printf("George Lucas will need %.2flv more.", neededMoney - amountOfMoney);
        }

    }

}
