package com.ps;

import java.util.ArrayList;
import java.util.HashMap;

public class AllDealerships {
    private ArrayList<Dealership> listOfDealerships;
    private HashMap<String, Dealership> dealershipSearcher;


    public AllDealerships() {
        listOfDealerships = new ArrayList<>();
        dealershipSearcher = new HashMap<>();
    }

    public ArrayList<Dealership> getAllDealerships() {
        return listOfDealerships;
    }

    public void addDealership(Dealership dealership) {
        listOfDealerships.add(dealership);
        dealershipSearcher.put(dealership.getName(), dealership);
    }

    /**
     * Replaces old dealership object with updated dealership object within the listOfDealerships ArrayList.
     *
     * @param oldDealershipName
     * @param dealership
     */
    public void updateDealership(String oldDealershipName, Dealership dealership) {
        Dealership oldDealership = searchForDealership(oldDealershipName);
        int indexOfDealership = listOfDealerships.indexOf(oldDealership);

        listOfDealerships.set(indexOfDealership, dealership);
    }

    public Dealership searchForDealership(String dealershipName) {
        Dealership dealership = dealershipSearcher.get(dealershipName);

        return dealership;
    }



}
