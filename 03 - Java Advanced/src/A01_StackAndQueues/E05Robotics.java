package A01_StackAndQueues;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Scanner;

public class E05Robotics {
//    Somewhere in the future, there is a robotics factory. The current project is assembly line robots.
//    Each robot has a processing time, the time it needs to process a product. When a robot is free it should
//    take a product for processing and log his name, product and processing start time.
//    Each robot processes a product coming from the assembly line. A product is coming from the line each second
//    (so the first product should appear at [start time + 1 second]). If a product passes the line and there is not
//    a free robot to take it, it should be queued at the end of the line again.
//    The robots are standing on the line in the order of their appearance.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String name = data[0];

            int time = Integer.parseInt(data[1]);
            robots[i] = name;
            processTime[i] = time;

        }
        String startTime = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();

        String inputProduct = scanner.nextLine();

        while (!inputProduct.equals("End")){
            products.offer(inputProduct);
            inputProduct = scanner.nextLine();
        }

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        LocalTime time = LocalTime.of(hours, minutes, seconds);

//        int beginSeconds = hours * 3600 + minutes * 60 + seconds;

        while (!products.isEmpty()){
            time = time.plusSeconds(1);
            //            beginSeconds++;

            String product = products.poll();
            boolean isAssigned = false;

            for (int i = 0; i < robots.length; i++) {
                if(workTime[i] == 0 && !isAssigned){
                    workTime[i] = processTime[i];
                    isAssigned = true;
                    printRobotData(robots[i], product, time);
                }

                if(workTime[i] > 0){
                    workTime[i]--;
                }
            }

            if(!isAssigned){
                products.offer(product);
            }
        }
    }

    private static void printRobotData(String robot, String product, LocalTime time) {
//        int outputHours = (beginSeconds / 3600) % 24;
//        int outputMinutes = (beginSeconds / 60) % 60;
//        int outputSeconds = beginSeconds % 60 ;

//        System.out.println(
//                String.format("%s - %s [%02d:%02d:%02d]",
//                        robot,
//                        product,
//                        outputHours,
//                        outputMinutes,
//                        outputSeconds
//                        )
//                );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.printf("%s - %s [%s]%n", robot, product, time);
    }
}
