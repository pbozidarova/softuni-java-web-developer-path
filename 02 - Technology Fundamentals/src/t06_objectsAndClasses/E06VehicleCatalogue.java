package t06_objectsAndClasses;

import java.awt.*;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06VehicleCatalogue {
//    Until you receive the command “End” you will receive lines of input in the format:
//    {typeOfVehicle} {model} {color} {horsepower}
//    After the “End” command, you will start receiving models of vehicles. Print for every received vehicle its
//    data in the format:
//    Type: {typeOfVehicle}
//    Model: {modelOfVehicle}
//    Color: {colorOfVehicle}
//    Horsepower: {horsepowerOfVehicle}
//
//    When you receive the command "Close the Catalogue", stop receiving input and print the average horsepower
//    for the cars and for the trucks in the format:
//            "{typeOfVehicles} have average horsepower of {averageHorsepower}."
//    The average horsepower is calculated by dividing the sum of horsepower for all vehicles of the type by
//    the total count of vehicles from the same type.
//    Format the answer to the 2nd decimal point.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = "";

        List<Vehicle> vehicles = new ArrayList<>();
        while (!"End".equals(input = scanner.nextLine())){
            String[] data = input.split("\\s+");

            Vehicle vehicle = new Vehicle(
                data[0], data[1], data[2], Integer.parseInt(data[3])
            );

            vehicles.add(vehicle);
        }

        String model = scanner.nextLine();

        while (!"Close the Catalogue".equals(model)){
            String finalModel = model;
            vehicles.stream()
                    .filter(v -> v.getModel().equals(finalModel))
                    .forEach(System.out::print);

            model = scanner.nextLine();
        }

        List<Vehicle> cars = vehicles.stream()
                .filter(v -> v.getType().equals("car"))
                .collect(Collectors.toList());

        List<Vehicle> trucks = vehicles.stream()
                .filter(v -> v.getType().equals("truck"))
                .collect(Collectors.toList());

        System.out.printf("Cars have average horsepower of: %.2f.%n", average(cars));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", average(trucks));
    }

    private static double average(List<Vehicle> vehicles){
        if(vehicles.size() == 0){
            return 0.0;
        }

        double sum = 0;

        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getHorsepower();
        }

        return sum / vehicles.size();
    }

}

class Vehicle{
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\n" +
                "Model: %s\n" +
                "Color: %s\n" +
                "Horsepower: %d\n",
                this.getType().toUpperCase().charAt(0) + this.getType().substring(1),
                this.getModel(),
                this.getColor(),
                this.getHorsepower());
    }
}
