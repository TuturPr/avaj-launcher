package xyz.tuturprdev.ajav.vehicle;

import xyz.tuturprdev.ajav.weather.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower)
    {
        return ;
    }
}
