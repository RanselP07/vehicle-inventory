package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {

    static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        Vehicle[] inventory = new Vehicle[20];
        int counter = 6;
        int choice;

        String menu = """
                What do you want to do?
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit
                Enter your command:""";

        String newVehicle = """
                """;

        Vehicle vehicle1 = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        Vehicle vehicle2 = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        Vehicle vehicle3 = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        Vehicle vehicle4 = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        Vehicle vehicle5 = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        Vehicle vehicle6 = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        inventory[0] = vehicle1;
        inventory[1] = vehicle2;
        inventory[2] = vehicle3;
        inventory[3] = vehicle4;
        inventory[4] = vehicle5;
        inventory[5] = vehicle6;


        do {
            System.out.print("\n" + menu + " ");
            choice = myScanner.nextInt();

            if (choice < 1 || choice > 6) {
                System.out.println("\nERROR: Invalid input, please try again.");
            }

            switch (choice) {
                case 1:
                    listAllVehicles(inventory, counter);
                    break;
                case 2:
                    searchByMakeModel(inventory, counter, myScanner);
                    break;
                case 3:
                    searchByPrice(inventory, counter, myScanner);
                case 4:
                    searchByColor(inventory, counter, myScanner);
                    break;
                case 5:
                    Vehicle vehicle = inventory[counter];
                    inventory[counter] = addVehicle(inventory, counter, myScanner);
                    counter++;
                default:
                    break;
            }

        } while (choice != 6);

    }

    private static void searchByPrice(Vehicle[] inventory, int counter, Scanner myScanner) {

        boolean priceFound = false;
        double price = 0;

        System.out.print("Enter price: ");
        String colorInput = myScanner.next();

        for (int i = 0; i < counter; i++) {
            if (inventory[i].getColor().equals(colorInput)) {
                priceFound = true;
                price = inventory[i].getPrice();
            }
        }

        if (priceFound) {
            System.out.print(price + " Found");
        } else {
            System.out.println("Car Color Not Found.");
        }

    }

    private static void searchByColor(Vehicle[] inventory, int counter, Scanner myScanner) {

        boolean colorFound = false;
        String color = "";

        System.out.print("Enter color: ");
        String colorInput = myScanner.next();

        for (int i = 0; i < counter; i++) {
            if (inventory[i].getColor().equals(colorInput)) {
                colorFound = true;
                color = inventory[i].getColor();
            }
        }

        if (colorFound) {
            System.out.print(color + " Found");
        } else {
            System.out.println("Car Color Not Found.");
        }

    }

    private static Vehicle addVehicle(Vehicle[] inventory, int counter, Scanner myScanner) {

        System.out.print("Enter Vehicle ID: ");
        String stringID = myScanner.next();
        long vehicleID = Long.parseLong(stringID);

        System.out.print("Enter make: ");
        String make = myScanner.next();
        System.out.print("Enter model: ");
        String model = myScanner.next();
        String makeModel = make + " " + model;

        System.out.print("Enter color: ");
        String color = myScanner.next();

        System.out.print("Enter odometer reading: ");
        String stringOdometer = myScanner.next();
        int odometerReading = Integer.parseInt(stringOdometer);

        System.out.print("Enter price: ");
        String stringPrice = myScanner.next();
        double price = Double.parseDouble(stringPrice);

        return new Vehicle(vehicleID, makeModel, color, odometerReading, price);
    }

    private static void searchByMakeModel(Vehicle[] inventory, int counter, Scanner myScanner) {

        boolean carFound = false;
        String car = "";

        System.out.print("Enter make: ");
        String makeInput = myScanner.next();
        System.out.print("Enter model: ");
        String modelInput = myScanner.next();

        String carMakeModel = makeInput + " " + modelInput;

        for (int i = 0; i < counter; i++) {
            if (inventory[i].getMakeModel().equals(carMakeModel)) {
                carFound = true;
                car = inventory[i].getMakeModel();
            }
        }

        if (carFound) {
            System.out.println(car + " Found.");
        } else {
            System.out.println("Car Not Found.");
        }
    }


    private static void listAllVehicles(Vehicle[] inventory, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.println(inventory[i].getMakeModel());
        }
    }

}
