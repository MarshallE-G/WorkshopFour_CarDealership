package com.ps;

/*
UserInterface will be responsible for all output to screen, reading of user input, and "dispatching" of the commands
to the Dealership as needed. (ex: when the user selects "List all Vehicles", UserInterface would call the appropriate
Dealership method and then display the vehicles it returns.)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    // dealership : Dealership
    Dealership dealership;
    static Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public void display() {
        init();
        displayHomeMenu();
    }

    // Creates a dealership object
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    private void displayHomeMenu() {

        int homeMenuOption;
        do {
            System.out.println("1) Find vehicles within a price range");
            System.out.println("2) Find vehicles by make/model");
            System.out.println("3) Find vehicles by year range");
            System.out.println("4) Find vehicles by color");
            System.out.println("5) Find vehicles by mileage range");
            System.out.println("6) Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7) List ALL vehicles");
            System.out.println("8) Add a vehicle");
            System.out.println("9) Remove a vehicle");
            System.out.println("99) Quit");

            System.out.println("\nEnter selection here:");
            homeMenuOption = scanner.nextInt();


            switch (homeMenuOption) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    // processAddVehicleRequest()
                    break;
                case 9:
                    // processRemoveVehicleRequest()
                    break;
                case 99:
                    // Quit/Exit
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nERROR: Must select options 1 - 9 or 99!\n\n");
            }
        } while (homeMenuOption != 99);
    }

    // Implemented in all getVehicle-type methods
    private void displayVehicles(ArrayList<Vehicle> dealershipInventory) {
        System.out.println("\n");
        for (Vehicle vehicle : dealershipInventory) {
            System.out.printf("%d | %d | %s | %s | %s | %s | %d | %.2f\n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );
        }
        System.out.println("\n");
    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> dealershipInventory = dealership.getAllVehicles();
        if (dealershipInventory.size() > 0) {
            displayVehicles(dealershipInventory);
        } else {
            System.out.println("\nThis dealership has no available vehicles.\n\n");
        }
    }

    // processGetByPriceRequest()
    public void processGetByPriceRequest() {
        float min;
        float max;

        System.out.println("\nEnter a minimum price:");
        min = scanner.nextFloat();

        System.out.println("\nEnter a maximum price:");
        max = scanner.nextFloat();

        ArrayList<Vehicle> priceRangeFilteredVehicles = dealership.getVehiclesByPrice(min, max);
        if (priceRangeFilteredVehicles.size() > 0) {
            displayVehicles(priceRangeFilteredVehicles);
        } else {
            System.out.println("\nThere are no vehicles within this price range.\n\n");
        }
    }

    // processGetByMakeModelRequest()
    public void processGetByMakeModelRequest() {
        String make;
        String model;

        System.out.println("\nEnter vehicle make:");
        scanner.nextLine(); // consumes extra line
        make = scanner.nextLine();

        System.out.println("\nEnter vehicle model:");
        model = scanner.nextLine();

        ArrayList<Vehicle> makeModelFilteredVehicles = dealership.getVehiclesByMakeModel(make, model);
        if (makeModelFilteredVehicles.size() > 0) {
            displayVehicles(makeModelFilteredVehicles);
        } else {
            System.out.println("\nEither there are no vehicles with this make and model or your input was spelled incorrectly.\n\n");
        }
    }

    // processGetByYearRequest()
    public void processGetByYearRequest() {
        int min;
        int max;

        System.out.println("\nFrom (year):");
        min = scanner.nextInt();

        System.out.println("\nTo (year):");
        max = scanner.nextInt();

        ArrayList<Vehicle> yearRangeFilteredVehicles = dealership.getVehiclesByYear(min, max);
        if (yearRangeFilteredVehicles.size() > 0) {
            displayVehicles(yearRangeFilteredVehicles);
        } else {
            System.out.println("\nThere are no vehicles within this year range.\n\n");
        }
    }

    // processGetByColorRequest()
    public void processGetByColorRequest() {
        String color;

        System.out.println("\nEnter vehicle color:");
        scanner.nextLine(); // consumes extra line
        color = scanner.nextLine();

        ArrayList<Vehicle> colorFilteredVehicles = dealership.getVehiclesByColor(color);
        if (colorFilteredVehicles.size() > 0) {
            displayVehicles(colorFilteredVehicles);
        } else {
            System.out.println("\nEither there are no vehicles with this color or your input was spelled incorrectly.\n\n");
        }
    }

    // processGetByMileageRequest()
    public void processGetByMileageRequest() {
        int min;
        int max;

        System.out.println("\nEnter minimum mileage:");
        min = scanner.nextInt();

        System.out.println("\nEnter maximum mileage:");
        max = scanner.nextInt();

        ArrayList<Vehicle> mileageRangeFilteredVehicles = dealership.getVehiclesByMileage(min, max);
        if (mileageRangeFilteredVehicles.size() > 0) {
            displayVehicles(mileageRangeFilteredVehicles);
        } else {
            System.out.println("\nThere are no vehicles within this mileage range.\n\n");
        }
    }

    // processGetByVehicleTypeRequest()
    public void processGetByVehicleTypeRequest() {
        String inputVehicleType;

        System.out.println("\nEnter vehicle type:");
        scanner.nextLine(); // consumes extra line
        inputVehicleType = scanner.nextLine();

        ArrayList<Vehicle> vehicleTypeFilteredVehicles = dealership.getVehiclesByType(inputVehicleType);
        if (vehicleTypeFilteredVehicles.size() > 0) {
            displayVehicles(vehicleTypeFilteredVehicles);
        } else {
            System.out.println("\nEither there are no vehicles with this vehicle type or your input was spelled incorrectly.\n\n");
        }
    }

    // processAddVehicleRequest()
    public void processAddVehicleRequest() {

    }

    // processRemoveVehicleRequest()

}
