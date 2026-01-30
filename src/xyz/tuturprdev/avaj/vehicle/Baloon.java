package xyz.tuturprdev.avaj.vehicle;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        switch (weatherTower.getWeather(coordinates)) {
            case "RAIN":
                coordinates.setHeight(coordinates.getHeight() - 5);
                System.out.printf("%s: Damn you rain! You messed up my baloon. %n", getCallsign());
                break;
            case "FOG":
                coordinates.setHeight(coordinates.getHeight() - 3);
                System.out.printf("%s: I can't see anything !%n", getCallsign());
                break;
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                System.out.printf("%s: Let's enjoy the good weather and take some pics.%n", getCallsign());
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 15);
                System.out.printf("%s:  It's snowing. We're gonna crash.%n", getCallsign());
                if ((coordinates.getHeight() - 15) <= 0) {
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
