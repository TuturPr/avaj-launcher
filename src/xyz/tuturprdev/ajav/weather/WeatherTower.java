package xyz.tuturprdev.ajav.weather;

import xyz.tuturprdev.ajav.vehicle.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates)
    {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather()
    {
        conditionChanged();
    }
}
