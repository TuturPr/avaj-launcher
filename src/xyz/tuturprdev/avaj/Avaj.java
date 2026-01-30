package xyz.tuturprdev.avaj;

import com.sun.istack.internal.NotNull;
import xyz.tuturprdev.avaj.parsing.Parser;
import xyz.tuturprdev.avaj.vehicle.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Avaj {

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
