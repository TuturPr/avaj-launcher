package xyz.tuturprdev.ajav.parsing;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import xyz.tuturprdev.ajav.Ajav;
import xyz.tuturprdev.ajav.vehicle.AircraftFactory;
import xyz.tuturprdev.ajav.vehicle.AircraftTypes;
import xyz.tuturprdev.ajav.vehicle.Coordinates;

import java.io.*;
import java.util.Scanner;

public class Parser {

    public static int parseScenario(String fileName) throws IOException {
        int simNum;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            if (line == null) {
                throw new IllegalArgumentException("Empty file");
            }

            try {
                simNum = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("First line must be a number");
            }

            if (simNum <= 0) {
                throw new IllegalArgumentException("Simulation number must be greater than 0");
            }

            int lineNumber = 2;
            AircraftFactory aircraftFactory = AircraftFactory.getInstance();
            while ((line = reader.readLine()) != null) {
                String[] splitted = line.trim().split("\\s+");

                if (splitted.length != 5)
                    throw new IllegalArgumentException("Invalid number of arguments on line " + lineNumber);

                Ajav.aircraftList.add(
                        aircraftFactory.newAircraft(
                            splitted[0],
                            splitted[1],
                            new Coordinates(
                                    Integer.parseInt(splitted[2]),
                                    Integer.parseInt(splitted[3]),
                                    Integer.parseInt(splitted[4])
                            )
                        )
                );
                lineNumber++;
            }
        }
        return simNum;
    }
}
