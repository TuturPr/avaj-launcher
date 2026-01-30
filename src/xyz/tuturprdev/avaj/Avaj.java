package xyz.tuturprdev.avaj;

import xyz.tuturprdev.avaj.exception.BadExecException;
import xyz.tuturprdev.avaj.parsing.Parser;
import xyz.tuturprdev.avaj.vehicle.Flyable;
import xyz.tuturprdev.avaj.weather.WeatherTower;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Avaj {

    public static List<Flyable> aircraftList = new ArrayList<>();
    public static void main (String[] args) {
        try {
            if (args.length != 1)
                throw new BadExecException("Usage : Java <program name> <file name>");
            int simNum;
            simNum = Parser.parseScenario(args[0]);
            WeatherTower tower = new WeatherTower();
            for (Flyable f : aircraftList)
                f.registerTower(tower);
            while (simNum != 0) {
                if (!tower.changeWeather())
                    break;
                simNum--;
            }
        } catch (IOException | IllegalArgumentException | BadExecException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}
