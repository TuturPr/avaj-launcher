package xyz.tuturprdev.avaj.weather;

import xyz.tuturprdev.avaj.vehicle.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates)
    {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public boolean changeWeather()
    {
        return conditionChanged();
    }
}
