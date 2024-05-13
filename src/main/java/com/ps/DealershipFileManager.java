package com.ps;

/*
Will be responsible for reading the dealership file, parsing the data, and creating a Dealership object full of
vehicles from the file. It will also be responsible for saving a dealership and the vehicles back into the file in
the same pipe-delimited format.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {
    static String fileName = "inventory.txt";
    static AllDealerships allDealerships = new AllDealerships();
    static ArrayList<Dealership> listOfDealerships = allDealerships.getAllDealerships();

    // Loads and reads from file
    public static Dealership getDealership() {
        Dealership dealership = null; // placeholder value

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(fileName));

            String line;
            int lineNum = 1;
            while ((line = bufReader.readLine()) != null && lineNum != 2) { // Reads ONLY the first line of file
                String[] splitLine = line.split("\\|");
                lineNum++;

                // Set properties of Dealership
                String name = splitLine[0];
                String address = splitLine[1];
                String phoneNum = splitLine[2];
                dealership = new Dealership(name, address, phoneNum);

                if (doesDealershipExist(dealership)) {
                    break;
                } else {
                    allDealerships.addDealership(dealership); // Adds dealership info to an ArrayList of all dealerships
                }
            }

            while ((line) != null) { // Adds properties that are on the lines AFTER the first line
                String[] splitLine = line.split("\\|");
                int vin = Integer.parseInt(splitLine[0]);
                int year = Integer.parseInt(splitLine[1]);
                String make = splitLine[2];
                String model = splitLine[3];
                String vehicleType = splitLine[4];
                String color = splitLine[5];
                int odometer = Integer.parseInt(splitLine[6]);
                float price = Float.parseFloat(splitLine[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);

                line = bufReader.readLine(); // Had to move this here because the 2nd line would be skipped.
            }
            bufReader.close();
            return dealership;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership; // = null
    }

    // Overwrites inventory.txt file with the current Dealership information and inventory list.
    public static void saveDealership(Dealership dealership) {
        BufferedWriter bufWriter;
        String oldDealershipName = getDealership().getName(); // The current dealership name BEFORE overwriting the file.
        ArrayList<Vehicle> inventory = dealership.getAllVehicles();

        try {
            bufWriter = bufWriterAppends(false);
            bufWriter.write(String.format("%s|%s|%s",
                    dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhoneNum()
                    ));

            bufWriter = bufWriterAppends(true);
            for (Vehicle vehicle : inventory) {
                bufWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()
                ));
            }
            bufWriter.close();

            // Might have to check if either file is empty or if the dealership already exists FIRST or do both.
            Dealership updatedDealership = getDealership(); // The dealership after the file has been overwritten.
            allDealerships.updateDealership(oldDealershipName, updatedDealership); // Replaces (updated) dealership info to an ArrayList of all dealerships.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Decides whether a BufferedWriter object is set to append or not, without having to create multiple
     * BufferedWriter variables/objects.
     *
     * @param isAppend
     * @return BufferedWriter
     */
    public static BufferedWriter bufWriterAppends(boolean isAppend) {
        try {
            return new BufferedWriter(new FileWriter(fileName, isAppend));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean doesDealershipExist(Dealership dealership) {
        boolean dealershipDoesExist = false;
        for (Dealership dealership1 : listOfDealerships) {
            String currentDealershipName = dealership.getName(); // the dealership that was just created.
            String dealershipName = dealership1.getName(); // the name of the dealership(s) that's already in the list of all dealerships.

            if (currentDealershipName.equalsIgnoreCase(dealershipName)) {
                dealershipDoesExist = true;
            }
        }
        return dealershipDoesExist;
    }

}
