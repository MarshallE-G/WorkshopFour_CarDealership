package com.ps;

/*
Dealership will hold information about the dealership (name, address, ...) and maintain a list of vehicles. Since it
has the list of vehicles, It will also have the methods that search the list for matching vehicles as well as
add/remove vehicles.
 */

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phoneNum;
    private ArrayList<Vehicle> inventory; // inventory of all vehicles
    private ArrayList<Dealership> allDealerships = new ArrayList<>();

    public Dealership(String name, String address, String phoneNum) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.inventory = new ArrayList<>();
    }

    public void addDealership(Dealership dealership) {
        allDealerships.add(dealership);
    }

    // getVehiclesByPrice (min, max)
    // getVehiclesByMakeModel (make, model)
    // getVehiclesByYear (min, max)
    // getVehiclesByColor (color)
    // getVehiclesByMileage (min, max)
    // getVehiclesByType (vehicleType)
    // getAllVehicles() : ArrayList<Vehicle>
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

    // Getters and setters (except for inventory)
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
