package t04_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E11ArrayManipulator {
//    The array may be manipulated by one of the following commands
//            •	exchange {index} – splits the array after the given index, and exchanges the places of the two resulting sub-arrays. E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
//    o	If the index is outside the boundaries of the array, print “Invalid index”
//            •	max even/odd– returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
//            •	min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even > print 3
//    o	If there are two or more equal min/max elements, return the index of the rightmost one
//    o	If a min/max even/odd element cannot be found, print “No matches”
//            •	first {count} even/odd– returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
//            •	last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
//    o	If the count is greater than the array length, print “Invalid count”
//    o	If there are not enough elements to satisfy the count, print as many as you can. If there are zero even/odd elements, print an empty array “[]”
//            •	end – stop taking input and print the final state of the array

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        String[] inputData = reader.readLine().split("\\s+");

        int[] numbers = new int[inputData.length];

        for (int i = 0; i < inputData.length; i++) {
            numbers[i] = Integer.parseInt(inputData[i]);
        }

        String input = "";

        while (!"end".equals(input = reader.readLine())){
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command){
                case "exchange":
                    exchangeArray(numbers, Integer.parseInt(data[1]));
                    break;
                case "min":
                    minMaxElementIndex(numbers, data[1], "min");
                    break;
                case "max":
                    minMaxElementIndex(numbers, data[1], "max");
                    break;
                case "first":
                    firstCountElements(numbers, Integer.parseInt(data[1]), data[2]);
                    break;
                case "last":
                    lastCountElements(numbers, Integer.parseInt(data[1]), data[2]);
                    break;
                default:
                    break;

            }
        }

        System.out.println(Arrays.toString(numbers));
    }

    private static void lastCountElements(int[] numbers, int count, String command) {
        if (validateAddCount(numbers, count)) return;
        int num = command.equals("even") ? 0 : 1;

        int index = 0;
        fillElementsByCriteria(numbers, count, num, index, "last");

    }

    private static void firstCountElements(int[] numbers, int count, String command) {

        if (validateAddCount(numbers, count)) return;
        int num = command.equals("even") ? 0 : 1;

        int index = 0;
        fillElementsByCriteria(numbers, count, num, index, "first");
    }

    private static boolean validateAddCount(int[] numbers, int count) {
        if(count < 0 || count > numbers.length){
            System.out.println("Invalid count");
            return true;
        }
        return false;
    }

    private static void fillElementsByCriteria(int[] numbers, int count, int num, int index, String criteria) {
        int[] result = new int[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == num) {
                if (index == result.length) {
                    result = changeArraySize(result);
                }
                result[index++] = numbers[i];
            }
        }

        if (index == 0) {
            System.out.println("[]");
        } else {
            int minCount = Math.min(count, result.length);
            String output = "[";

            if(criteria.equals("first")){
                for (int i = 0; i < minCount; i++) {
                    if (i < minCount - 1) {
                        output += result[i] + ", ";
                    } else {
                        output += result[i] + "]";
                    }
                }
            }else {
                int countElements = 0;
                for (int i = 0; i < minCount; i++) {
                    if (i < minCount - 1) {
                        output += result[result.length - minCount + countElements++] + ", ";
                    } else {
                        output += result[result.length - minCount + countElements++] + "]";
                    }
                }
            }

            System.out.println(output);
        }
    }

    private static int[] changeArraySize(int[] result) {
        int[] newArray = new int[result.length+1];

        int count = 0;
        for (int i = 0; i < result.length; i++) {
            newArray[i] = result[i];
        }
        return newArray;
    }

    private static void minMaxElementIndex(int[] numbers, String command, String condition) {
        int num = command.equals("even") ? 0 : 1;
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == num){

                    switch (condition){
                        case "max":
                            if(numbers[i] >= maxElement) {
                                maxElement = numbers[i];
                                index = i;
                            }
                            break;
                        case "min":
                            if(numbers[i] <= minElement) {
                                minElement = numbers[i];
                                index = i;
                            }
                            break;
                    }


            }
        }

        if(index == -1){
            System.out.println("No matches");
        }else {
            System.out.println(index);
        }
    }

    private static void exchangeArray(int[] numbers, int index) {
        if(index < 0 || index >= numbers.length){
            System.out.println("Invalid index");
            return;
        }

        int[] result = new int[numbers.length];
        int resultIndex = 0;
        for (int i = index +1; i < numbers.length; i++) {
            result[resultIndex++] = numbers[i];
        }
        for (int i = 0; i <= index; i++) {
            result[resultIndex++] = numbers[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = result[i];
        }
    }

}
