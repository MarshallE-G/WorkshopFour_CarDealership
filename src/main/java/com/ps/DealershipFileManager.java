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

public class DealershipFileManager {
    static String fileName = "inventory.txt";

    // Read from file and write to file methods go here or in different/separate class.
        // Name read from file: getDealership()
        // getDealership() : Dealership

    // Loads and reads from file
    public static Dealership getDealership() {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(fileName));

            String line;
            int lineNum;
            while ((line = bufReader.readLine()) != null) {
                String[] splitLine = line.split("\\|");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Overwrites inventory.txt file with the current Dealership information and inventory list.
    public static void saveDealership(Dealership dealership) {
        BufferedWriter bufWriter = bufWriterAppends(true);

        bufWriter.write(String.format("||||"));
    }

    // Create a method that takes in a parameter for whether to APPEND or NOT
    public static BufferedWriter bufWriterAppends(boolean isAppend) {
        try {
            return new BufferedWriter(new FileWriter(fileName, isAppend));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Save dealership everytime user adds or removes a vehicle. (Optional/Bonus; will touch upon in a later project)

}
