package xyz.tuturprdev.avaj.vehicle;

import xyz.tuturprdev.avaj.weather.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract void updateConditions();
    public abstract String getCallsign();

    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
        p_tower.register(this);
    }
}
