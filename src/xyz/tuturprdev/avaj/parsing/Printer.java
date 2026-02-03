package xyz.tuturprdev.avaj.parsing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Printer {
    private static Printer instance = null;
    private static BufferedWriter writer;

    private Printer() {
        try {
            writer = new BufferedWriter(new FileWriter("simulation.txt"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return  instance;
    }

    public void write(String toPrint) {
        try {
            writer.write(toPrint);
            writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
