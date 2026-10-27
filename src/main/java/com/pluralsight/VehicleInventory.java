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

        inventory[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        inventory[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        inventory[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        inventory[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        inventory[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        inventory[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);


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
                    break;
                case 4:
                    searchByColor(inventory, counter, myScanner);
                    break;
                case 5:
                    if (counter < inventory.length) {
                        Vehicle vehicle = inventory[counter];
                        inventory[counter] = addVehicle(inventory, counter, myScanner);
                        counter++;
                        break;
                    } else {
                        System.out.println("Car inventory is full!");
                        break;
                    }
                default:
                    break;
            }

        } while (choice != 6);

    }

    private static void listAllVehicles(Vehicle[] inventory, int counter) {
        for (int i = 0; i < counter; i++) {
            System.out.println(inventory[i].getMakeModel());
        }
    }

    //region search by...
    private static void searchByMakeModel(Vehicle[] inventory, int counter, Scanner myScanner) {

        int carCount = 0;
        String[] cars = new String[20];

        System.out.print("Enter make: ");
        String makeInput = myScanner.next();
        System.out.print("Enter model: ");
        String modelInput = myScanner.next();

        String carMakeModel = makeInput + " " + modelInput;

        for (int i = 0; i < counter; i++) {

            if (inventory[i].getMakeModel().equals(carMakeModel)) {
                String car = inventory[i].getMakeModel();
                cars[carCount] = inventory[i].getMakeModel();
                System.out.print(car + " Found\n");
                System.out.println(cars[carCount]);
                carCount++;
            }
        }
        if (carCount == 0) {
            System.out.println("Car Not Found");
        }
    }

    private static void searchByPrice(Vehicle[] inventory, int counter, Scanner myScanner) {

        int carCount = 0;
        String[] cars = new String[20];

        System.out.print("Enter Price: $");
        String priceInput = myScanner.next();
        double price = Double.parseDouble(priceInput);
        double minPrice = price - 500;
        double maxPrice = price + 500;

        System.out.printf("Cars found at $%.2f", price);
        System.out.print(" price range ($500 price range): \n");

        for (int i = 0; i < counter; i++) {

            if (inventory[i].getPrice() >= minPrice && inventory[i].getPrice() <= maxPrice) {
                cars[carCount] = inventory[i].getMakeModel();
                System.out.println((i + 1) + " - " + cars[carCount]);
                carCount++;
            }
        }
        if (carCount == 0) {
            System.out.println("Car Not Found");
        }

    }

    private static void searchByColor(Vehicle[] inventory, int counter, Scanner myScanner) {

        String color = "";
        int carCount = 0;
        String[] cars = new String[20];

        System.out.print("Enter color: ");
        String colorInput = myScanner.next();

        for (int i = 0; i < counter; i++) {

            if (inventory[i].getColor().equals(colorInput)) {
                color = inventory[i].getColor();
                cars[carCount] = inventory[i].getMakeModel();
                System.out.print(color + " Found\n");
                System.out.println(cars[carCount]);
                carCount++;
            }
        }
        if (carCount == 0) {
            System.out.println("Car Not Found");
        }

    }

    //endregion

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

}
