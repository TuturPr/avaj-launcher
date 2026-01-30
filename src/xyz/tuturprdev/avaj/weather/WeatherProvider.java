package xyz.tuturprdev.avaj.weather;

import xyz.tuturprdev.avaj.vehicle.Coordinates;

public class WeatherProvider {

    private static WeatherProvider instance = null;

    private WeatherProvider() {}

    public static WeatherProvider getInstance()
    {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return  instance;
    }


    public String getCurrentWeather(Coordinates p_coordinates)
    {
        int total =
                p_coordinates.getLongitude()
                + p_coordinates.getLatitude()
                + p_coordinates.getHeight();
        WeatherConditions[] conditions = WeatherConditions.values();
        int weather = (total % conditions.length) + 1;
        return (conditions[weather].name());
    }
}
