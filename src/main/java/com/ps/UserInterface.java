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
        Scanner scanner = new Scanner(System.in);

        int homeMenuOption;
        do {
            processAllVehiclesRequest();


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
                    // processGetByPriceRequest()
                    break;
                case 2:
                    // processGetByMakeModelRequest()
                    break;
                case 3:
                    // processGetByYearRequest()
                    break;
                case 4:
                    // processGetByColorRequest()
                    break;
                case 5:
                    // processGetByMileageRequest()
                    break;
                case 6:
                    // processGetByVehicleTypeRequest()
                    break;
                case 7:
                    // processGetAllVehiclesRequest()
                    break;
                case 8:
                    // processAddVehicleRequest()
                    break;
                case 9:
                    // processRemoveVehicleRequest()
                    break;
                case 99:
                    // Quit/Exit
                    break;
                default:
            }
        } while (homeMenuOption != 99);
    }

    // Implemented in all getVehicle-type methods
    private void displayVehicles(ArrayList<Vehicle> dealershipInventory) {
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
    }

    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> dealershipInventory = dealership.getAllVehicles();
        displayVehicles(dealershipInventory);
    }

    // processGetByPriceRequest()
    // processGetByMakeModelRequest()
    // processGetByYearRequest()
    // processGetByColorRequest()
    // processGetByMileageRequest()
    // processGetByVehicleTypeRequest()
    // processGetAllVehiclesRequest()
    // processAddVehicleRequest()
    // processRemoveVehicleRequest()

}
