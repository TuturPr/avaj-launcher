package xyz.tuturprdev.ajav;

import com.sun.istack.internal.NotNull;
import xyz.tuturprdev.ajav.parsing.Parser;
import xyz.tuturprdev.ajav.vehicle.Aircraft;
import xyz.tuturprdev.ajav.vehicle.Flyable;
import xyz.tuturprdev.ajav.weather.WeatherProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ajav {

    public static List<Flyable> aircraftList = new ArrayList<>();
    public static void main (@NotNull String[] args)
    {
        try {
            if (args.length != 1)
                throw new IllegalArgumentException("Usage : Java <program name> <file name>");
            int simNum;
            simNum = Parser.parseScenario(args[0]);
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error : " + e.getMessage());
        }
    }
}
