package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
//    D & B Used Cars|111 Old Benbrook Rd|817-555-5555    <------ Dealership info
//    10112|1993|Ford|Explorer|SUV|Red|525123|995.00      <------ List of vehicles
//    37846|2001|Ford|Ranger|truck|Yellow|172544|1995.00
//    44901|2012|Honda|Civic|SUV|Gray|103221|6995.00

    static String fileName = "inventory.txt";


    public static void main(String[] args) {
        // Instance of UserInterface

        // display() method

    }

    // Read from file and write to file methods go here or in different/separate class.
        // Name read from file: getDealership()
            // getDealership() : Dealership

//    // Loads and reads from file
//    public static Dealership getDealership() {
//        try {
//            BufferedReader bufReader = new BufferedReader(new FileReader(fileName));
//
//            String line;
//            int lineNum;
//            while ((line = bufReader.readLine()) != null) {
//                String[] splitLine = line.split("\\|");
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    // Overwrites inventory.txt file with the current Dealership information and inventory list.
//    public static void saveDealership(Dealership dealership) {
//        BufferedWriter bufWriter = bufWriterAppends(true);
//
//        bufWriter.write(String.format("||||"));
//    }
//
//    // Create a method that takes in a parameter for whether to APPEND or NOT
//    public static BufferedWriter bufWriterAppends(boolean isAppend) {
//        try {
//            return new BufferedWriter(new FileWriter(fileName, isAppend));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // Save dealership everytime user adds or removes a vehicle. (Optional/Bonus; will touch upon in a later project)

}