package T03_arrays;

import java.util.Scanner;

public class E10LadyBugs {
//    You are given a field size and the indexes of ladybugs inside the field. After that on every new line until
//    the "end" command is given, a ladybug changes its position either to its left or to its right by a given
//    fly length.
//    A command to a ladybug looks like this: "0 right 1". This means that the little insect placed on index 0 should
//    fly one index to its right. If the ladybug lands on a fellow ladybug, it continues to fly in the same direction
//    by the same fly length. If the ladybug flies out of the field, it is gone.
//    For example, imagine you are given a field with size 3 and ladybugs on indexes 0 and 1. If the ladybug
//    on index 0 needs to fly to its right by the length of 1 (0 right 1) it will attempt to land on index 1 but
//    as there is another ladybug there it will continue further to the right by additional length of 1, landing
//    on index 2. After that, if the same ladybug needs to fly to its right by the length of 1 (2 right 1),
//    it will land somewhere outside of the field, so it flies away:
//
//    If you are given ladybug index that does not have ladybug there, nothing happens. If you are given ladybug index
//    that is outside the field, nothing happens.
//    Your job is to create the program, simulating the ladybugs flying around doing nothing. At the end,
//    print all cells in the field separated by blank spaces. For each cell that has a ladybug on it print '1' and
//    for each empty cells print '0'. For the example above, the output should be '0 1 0'.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] ladyBugsIndexes = scanner.nextLine().split(" ");
        String[] command = scanner.nextLine().split(" ");
        if (size == 0) return;

        int[] ladybugs = new int[size];

        for (int j = 0; j < ladyBugsIndexes.length ; j++) {
            if (Integer.parseInt(ladyBugsIndexes[j]) < size && Integer.parseInt(ladyBugsIndexes[j]) >= 0){
                ladybugs[Integer.parseInt(ladyBugsIndexes[j])] = 1;
            }
        }

        while(!command[0].equals("end")) {
            int index = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyLength = Integer.parseInt(command[2]);

            while (index < size && index >= 0 && ladybugs[index] == 1 && flyLength != 0) {
                if (direction.equals("left")) {
                    if (index - flyLength < 0 ||  index - flyLength >= size) {
                        ladybugs[index] = 0;
                        break;
                    }
                    if (ladybugs[index - flyLength] == 0) {
                        ladybugs[index - flyLength] = 1;
                        ladybugs[index] = 0;
                        break;
                    } else {
                        flyLength+=flyLength;
                    }
                    //}
                } else if (direction.equals("right")){
                    if (index + flyLength < 0 || index + flyLength >= size) {
                        ladybugs[index] = 0;
                        break;
                    }
                    if (ladybugs[index + flyLength] == 0) {
                        ladybugs[index + flyLength] = 1;
                        ladybugs[index] = 0;
                        break;
                    } else {
                        flyLength+=flyLength;
                    }
                }
            }

            command = scanner.nextLine().split(" ");
        }

        for (int i = 0; i < ladybugs.length ; i++) {
            System.out.print(ladybugs[i] + " ");
        }
    }


}
