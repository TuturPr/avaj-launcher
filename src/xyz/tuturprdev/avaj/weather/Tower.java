package xyz.tuturprdev.avaj.weather;

import xyz.tuturprdev.avaj.vehicle.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable)
    {
        observers.add(p_flyable);
        System.out.printf("Tower says: %s registered to weather tower%n", p_flyable.getCallsign());
    }

    public void unregister(Flyable p_flyable)
    {
        observers.remove(p_flyable);
        System.out.printf("Tower says: %s unregistered from weather tower%n", p_flyable.getCallsign());
    }
    protected void conditionChanged()
    {
        for (Flyable f : new ArrayList<>(observers)) {
            f.updateConditions();
        }
    }
}
