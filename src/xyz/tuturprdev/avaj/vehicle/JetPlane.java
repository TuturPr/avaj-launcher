package xyz.tuturprdev.avaj.vehicle;

import xyz.tuturprdev.avaj.parsing.Printer;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates)) {
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                Printer.getInstance().write(String.format("%s: It's raining. Better watch out for lightings.%n", getCallsign()));
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                Printer.getInstance().write(String.format("%s: Oh puree de pois baguette%n", getCallsign()));
                break;
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                Printer.getInstance().write(String.format("%s: Nice weather, let's enjoy the view !%n", getCallsign()));
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 7);
                Printer.getInstance().write(String.format("%s: OMG! Winter is coming!%n", getCallsign()));
        }
    }

    @Override
    public String getCallsign() {
        return String.format("%s#%s(%d)", getClass().getSimpleName(), name, id);
    }
}
