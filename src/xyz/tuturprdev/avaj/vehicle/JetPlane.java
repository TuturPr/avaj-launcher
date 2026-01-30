package xyz.tuturprdev.avaj.vehicle;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates)) {
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                System.out.printf("%s: It's raining. Better watch out for lightings.%n", getCallsign());
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                System.out.printf("%s: Oh puree de pois baguette%n", getCallsign());
                break;
            case "SUN":
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                System.out.printf("%s: Nice weather, let's enjoy the view !%n", getCallsign());
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 7);
                System.out.printf("%s: OMG! Winter is coming!%n", getCallsign());
                if ((coordinates.getHeight() - 7) <= 0) {
                    System.out.printf("%s landing.%n", getCallsign());
                    weatherTower.unregister(this);
                    break;
                }
                break;
        }
    }

    @Override
    public String getCallsign() {
        return String.format("%s#%s(%d)", getClass().getSimpleName(), name, id);
    }
}
