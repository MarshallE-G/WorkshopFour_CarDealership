package com.ps;

/*
UserInterface will be responsible for all output to screen, reading of user input, and "dispatching" of the commands
to the Dealership as needed. (ex: when the user selects "List all Vehicles", UserInterface would call the appropriate
Dealership method and then display the vehicles it returns.)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    // dealership : Dealership
    private Dealership dealership;
    private static Scanner scanner = new Scanner(System.in);
//    private static DealershipFileManager fileManager = new DealershipFileManager(); <---- Not really necessary


    public UserInterface() {} // Constructor

    public void display() {
        init();
        displayHomeMenu();
    }

    // Creates a dealership object
    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    public void displayHomeMenu() {

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
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nERROR: Must select options 1 - 9 or 99!\n\n");
            }
        } while (homeMenuOption != 99);
        scanner.close();
    }

    // Implemented in all getVehicle-type methods
    private void displayVehicles(List<Vehicle> dealershipInventory) {
        System.out.println("\n");
        for (Vehicle vehicle : dealershipInventory) {
            System.out.printf("%d | %d | %s | %s | %s | %s | %d | $%.2f\n",
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

    public void processGetAllVehiclesRequest() {
        List<Vehicle> dealershipInventory = dealership.getAllVehicles();
        String pageTitle = "Displaying all Vehicles";

        if (!dealershipInventory.isEmpty()) {
            System.out.printf("\n%45s\n", pageTitle);
            displayVehicles(dealershipInventory);
        } else {
            System.out.println("\nThis dealership has no available vehicles.\n\n");
        }
    }

    public void processGetByPriceRequest() {
        float min;
        float max;
        String pageTitle = "Displaying all Vehicles By Price";

        System.out.println("\nEnter a minimum price:");
        min = scanner.nextFloat();

        System.out.println("\nEnter a maximum price:");
        max = scanner.nextFloat();

        List<Vehicle> priceRangeFilteredVehicles = dealership.getVehiclesByPrice(min, max);
        if (!priceRangeFilteredVehicles.isEmpty()) {
            System.out.printf("\n%45s\n", pageTitle);
            displayVehicles(priceRangeFilteredVehicles);
        } else {
            System.out.println("\nThere are no vehicles within this price range.\n\n");
        }
    }

    public void processGetByMakeModelRequest() {
        String make;
        String model;
        String pageTitle = "Displaying all Vehicles By Make and Model";

        // Consumes extra carriage
        scanner.nextLine();

        System.out.println("\nEnter vehicle make:");
        make = scanner.nextLine();

        System.out.println("\nEnter vehicle model:");
        model = scanner.nextLine();

        List<Vehicle> makeModelFilteredVehicles = dealership.getVehiclesByMakeModel(make, model);
        if (!makeModelFilteredVehicles.isEmpty()) {
            System.out.printf("\n%48s\n", pageTitle);
            displayVehicles(makeModelFilteredVehicles);
        } else {
            System.out.println("\nEither there are no vehicles with this make and model or your input was spelled incorrectly.\n\n");
        }
    }

    public void processGetByYearRequest() {
        int min;
        int max;
        String pageTitle = "Displaying all Vehicles By Year";

        System.out.println("\nFrom (year):");
        min = scanner.nextInt();

        System.out.println("\nTo (year):");
        max = scanner.nextInt();

        List<Vehicle> yearRangeFilteredVehicles = dealership.getVehiclesByYear(min, max);
        if (!yearRangeFilteredVehicles.isEmpty()) {
            System.out.printf("\n%45s\n", pageTitle);
            displayVehicles(yearRangeFilteredVehicles);
        } else {
            System.out.println("\nThere are no vehicles within this year range.\n\n");
        }
    }

    public void processGetByColorRequest() {
        String color;
        String pageTitle = "Displaying all Vehicles By Color";

        // Consumes extra carriage
        scanner.nextLine();

        System.out.println("\nEnter vehicle color:");
        color = scanner.nextLine();

        List<Vehicle> colorFilteredVehicles = dealership.getVehiclesByColor(color);
        if (!colorFilteredVehicles.isEmpty()) {
            System.out.printf("\n%45s\n", pageTitle);
            displayVehicles(colorFilteredVehicles);
        } else {
            System.out.println("\nEither there are no vehicles with this color or your input was spelled incorrectly.\n\n");
        }
    }

    public void processGetByMileageRequest() {
        int min;
        int max;
        String pageTitle = "Displaying all Vehicles By Mileage";

        System.out.println("\nEnter minimum mileage:");
        min = scanner.nextInt();

        System.out.println("\nEnter maximum mileage:");
        max = scanner.nextInt();

        List<Vehicle> mileageRangeFilteredVehicles = dealership.getVehiclesByMileage(min, max);
        if (!mileageRangeFilteredVehicles.isEmpty()) {
            System.out.printf("\n%45s\n", pageTitle);
            displayVehicles(mileageRangeFilteredVehicles);
        } else {
            System.out.println("\nThere are no vehicles within this mileage range.\n\n");
        }
    }

    public void processGetByVehicleTypeRequest() {
        String inputVehicleType;
        String pageTitle = "Displaying all Vehicles By Vehicle Type";

        // Consumes extra carriage
        scanner.nextLine();

        System.out.println("\nEnter vehicle type:");
        inputVehicleType = scanner.nextLine();

        List<Vehicle> vehicleTypeFilteredVehicles = dealership.getVehiclesByType(inputVehicleType);
        if (!vehicleTypeFilteredVehicles.isEmpty()) {
            System.out.printf("\n%48s\n", pageTitle);
            displayVehicles(vehicleTypeFilteredVehicles);
        } else {
            System.out.println("\nEither there are no vehicles with this vehicle type or your input was spelled incorrectly.\n\n");
        }
    }

    public void processAddVehicleRequest() {
        int vin; // Like an ID#
        int year;
        String make;
        String model;
        String vehicleType; // (car, truck, etc.)
        String color;
        int odometer; // Instrument used to track mileage
        float price;

        System.out.println("\nYou selected the Add Vehicle option.\n");

        // Ask for vehicle details
        System.out.println("What is the vehicle's vin#?");
        vin = scanner.nextInt();

        System.out.println("What year was the release year of the vehicle?");
        year = scanner.nextInt();

        // Consumes extra carriage
        scanner.nextLine();

        System.out.println("Who is the maker of this vehicle? (e.g. Honda)");
        make = scanner.nextLine();

        System.out.println("What is the vehicle model? (e.g. Civic)");
        model = scanner.nextLine();

        System.out.println("What is the vehicle type? (e.g. SUV)");
        vehicleType = scanner.nextLine();

        System.out.println("What is the color of the vehicle?");
        color = scanner.nextLine();

        System.out.println("What is the vehicle's mileage?");
        odometer = scanner.nextInt();

        System.out.println("What is the price of the vehicle?");
        price = scanner.nextFloat();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        // Add vehicle to dealership ArrayList
        this.dealership.addVehicle(vehicle);
        System.out.printf("\nYou added: %d | %d | %s | %s | %s | %s | %d | %.2f\n\n\n",
                vehicle.getVin(),
                vehicle.getYear(),
                vehicle.getMake(),
                vehicle.getModel(),
                vehicle.getVehicleType(),
                vehicle.getColor(),
                vehicle.getOdometer(),
                vehicle.getPrice()
        );

        // Write to the file and save dealership
        DealershipFileManager.saveDealership(this.dealership);
    }

    public void processRemoveVehicleRequest() {
        int vinInput; // Like an ID#

        System.out.println("\nYou selected the Remove a Vehicle option.\n");

        // Ask for vehicle details
        System.out.println("What is the vin# of the vehicle you would like to remove?");
        vinInput = scanner.nextInt();

        System.out.println(); // Extra new line for aesthetics

        int vehicleVin;
        for (Vehicle vehicle : this.dealership.getAllVehicles()) {
            vehicleVin = vehicle.getVin(); // vin# of each vehicle in the dealership
            if (vehicleVin == vinInput) {
                this.dealership.removeVehicle(vehicle);
                System.out.printf("You removed: %d | %d | %s | %s | %s | %s | %d | %.2f\n\n\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()
                );
                // Write to the file and save/update dealership
                DealershipFileManager.saveDealership(this.dealership);
                return; // Returns out of for loop as soon as vehicle is removed.
            }
        }

        System.out.println("Vehicle not found.\n");
    }

}
