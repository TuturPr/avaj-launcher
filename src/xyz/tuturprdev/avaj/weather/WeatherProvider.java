package xyz.tuturprdev.avaj.weather;

import xyz.tuturprdev.avaj.vehicle.Coordinates;

public class WeatherProvider {

    private static WeatherProvider instance = null;
    private String[] weather = {"RAIN", "FOG", "SNOW", "SUN"};
    private static int counter = 0;

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return  instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int total =
                p_coordinates.getLongitude()
                + p_coordinates.getLatitude()
                + p_coordinates.getHeight()
                + counter;
        int Weather = (total % weather.length);
        counter++;
        return (weather[Weather]);
    }
}
