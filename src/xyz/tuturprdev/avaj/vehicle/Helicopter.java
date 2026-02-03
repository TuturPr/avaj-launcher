package xyz.tuturprdev.avaj.vehicle;

import xyz.tuturprdev.avaj.parsing.Printer;

public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates)) {
            case "RAIN":
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                Printer.getInstance().write(String.format("%s: It's raining. Glad I took my umbrella.%n", getCallsign()));
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                Printer.getInstance().write(String.format("%s: Cutting the clouds !%n", getCallsign()));
                break;
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 4);
                Printer.getInstance().write(String.format("%s: : This is hot.%n", getCallsign()));
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 12);
                Printer.getInstance().write(String.format("%s:  My rotor is going to freeze!%n", getCallsign()));
        }
    }

    @Override
    public String getCallsign() {
        return String.format("%s#%s(%d)", getClass().getSimpleName(), name, id);
    }
}
