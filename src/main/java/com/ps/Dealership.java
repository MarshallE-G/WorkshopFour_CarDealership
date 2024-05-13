package com.ps;

/*
Dealership will hold information about the dealership (name, address, ...) and maintain a list of vehicles. Since it
has the list of vehicles, It will also have the methods that search the list for matching vehicles as well as
add/remove vehicles.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Dealership {
    private String name;
    private String address;
    private String phoneNum;
    private ArrayList<Vehicle> inventory; // inventory of all vehicles
    private ArrayList<Dealership> allDealerships = new ArrayList<>(); // May need to create a new class for this
    private HashMap<String, Dealership> dealershipSearcher = new HashMap<>(); // May need to create a new class for this

    public Dealership(String name, String address, String phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.inventory = new ArrayList<>();
    }



    public ArrayList<Dealership> getAllDealerships() { // May need to add to a new class that stores all dealerships
        return allDealerships;
    }

    public void addDealership(Dealership dealership) { // May need to add to a new class that stores all dealerships
        allDealerships.add(dealership);
        dealershipSearcher.put(dealership.getName(), dealership);
    }

    public void updateDealership(String dealershipName, Dealership dealership) {
        Dealership oldDealership = dealershipSearcher.get(dealershipName);
        int indexOfDealership = allDealerships.indexOf();

        allDealerships.set
    }

    public ArrayList<Vehicle> getVehiclesByPrice(float min, float max) {
        ArrayList<Vehicle> priceRangeFilteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            float vehiclePrice = vehicle.getPrice();
            if (vehiclePrice <= max && vehiclePrice >= min) {
                priceRangeFilteredVehicles.add(vehicle);
            }
        }

        return priceRangeFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> makeModelFilteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            String vehicleMake = vehicle.getMake();
            String vehicleModel = vehicle.getModel();

            if (vehicleMake.equalsIgnoreCase(make) && vehicleModel.equalsIgnoreCase(model)) {
                makeModelFilteredVehicles.add(vehicle);
            }
        }
        return makeModelFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> yearRangeFilteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            int vehicleYear = vehicle.getYear();
            if (vehicleYear <= max && vehicleYear >= min) {
                yearRangeFilteredVehicles.add(vehicle);
            }
        }
        return yearRangeFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> colorFilteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            String vehicleColor = vehicle.getColor();

            if (vehicleColor.equalsIgnoreCase(color)) {
                colorFilteredVehicles.add(vehicle);
            }
        }
        return colorFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> mileageRangeFilteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            int vehicleMileage = vehicle.getOdometer();
            if (vehicleMileage <= max && vehicleMileage >= min) {
                mileageRangeFilteredVehicles.add(vehicle);
            }
        }
        return mileageRangeFilteredVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String inputVehicleType) {
        ArrayList<Vehicle> vehicleTypeFilteredVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            String vehicleType = vehicle.getVehicleType();

            if (vehicleType.equalsIgnoreCase(inputVehicleType)) {
                vehicleTypeFilteredVehicles.add(vehicle);
            }
        }
        return vehicleTypeFilteredVehicles;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }


    /**
     * Getters and setters
     *
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
