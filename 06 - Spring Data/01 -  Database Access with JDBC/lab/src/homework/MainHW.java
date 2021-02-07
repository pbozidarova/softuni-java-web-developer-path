package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MainHW {
    public static void main(String[] args) throws SQLException, IOException {

        Homework homework = new Homework();
        homework.setConnection("root", "1234");

        BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));

        System.out.println("Please enter a task number from 2 to 9 in order to review it: ");
        String taskN = reader.readLine();

        switch (taskN) {
            case "2":
//              2.	Get Villains’ Names
//              Write a program that prints on the console all villains’ names and their number of minions.
//              Get only the villains who have more than 15 minions. Order them by number of minions in descending order.
                homework.getVillainsNamesEx2();
                break;
            case "3":
//              3.	Get Minion Names
//              Write a program that prints on the console all minion names and their age for given villain id. For the output, use the formats given in the examples.
                homework.getMinionNamesEx3();
                break;
            case "4":
//              4.	Add Minion
//              Write a program that reads information about a minion and its villain and adds it to the database. In case the town of the minion is not in the database,
//              insert it as well. In case the villain is not present in the database, add him too with default evilness factor of “evil”.
//              Finally, set the new minion to be servant of the villain. Print appropriate messages after each operation – see the examples.
                homework.addMinionEx4();
                break;
            case "5":
//              5.	Change Town Names Casing
//              Write a program that changes all town names to uppercase for a given country. Print the number of towns that were changed in the format provided in examples.
//              On the next line print the names that were changed, separated by coma and a space.
                homework.changeTownNameCasingEx5();
                break;
            case "6":
//              6.	*Remove Villain
//              Write a program that receives an ID of a villain, deletes him from the database and releases his minions from serving him. As an output print the name of the villain
//              and the number of minions released. Make sure all operations go as planned, otherwise do not make any changes to the database. For the output use the format given in the examples.
                homework.removeVillainEx6();
                break;
            case "7":
//              7.	Print All Minion Names
//              Write a program that prints all minion names from the minions table in order first record, last record,
//              first + 1, last – 1, first + 2, last – 2… first + n, last – n.
                homework.printAllMinionNamesEx7();
                break;
            case "8":
//              8.	Increase Minions Age
//              Read from the console minion IDs, separated by space. Increment the age of those minions by 1 and make their names title to lower case.
//              Finally, print the names and the ages of all minions that are in the database. See the examples below.
                homework.increaseMinionsAgeEx8();
                break;
            case "9":
//              9.	Increase Age Stored Procedure
//              Create a stored procedure usp_get_older (directly in the database using MySQL Workbench or any other similar tool)
//              that receives a minion_id and increases the minion’s years by 1. Write a program that uses that stored procedure
//              to increase the age of a minion, whose id will be given as an input from the console. After that print the name and the age of that minion.
                homework.increaseAgeWithStoredProcedureEx9();
                break;
            default:
                System.out.println("No such task exists!");
                break;
        }
    }
}
