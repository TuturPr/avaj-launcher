package xyz.tuturprdev.ajav.weather;

import xyz.tuturprdev.ajav.vehicle.Coordinates;

public class WeatherProvider {

    private String[] weather;
    private static WeatherProvider instance = null;

    private WeatherProvider()
    {
    }

    public static WeatherProvider getInstance()
    {
        if (instance == null)
        {
            instance = new WeatherProvider();
        }
        return  instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates)
    {
        return "PLACEHOLDER";
    }
}
