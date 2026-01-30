package xyz.tuturprdev.avaj.parsing;

import xyz.tuturprdev.avaj.Avaj;
import xyz.tuturprdev.avaj.vehicle.AircraftFactory;
import xyz.tuturprdev.avaj.vehicle.Coordinates;

import java.io.*;

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

                Avaj.aircraftList.add(
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
