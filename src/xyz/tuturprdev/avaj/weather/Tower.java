package xyz.tuturprdev.avaj.weather;

import xyz.tuturprdev.avaj.vehicle.Flyable;
import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public void register(Flyable p_flyable)
    {
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable)
    {
        return ;
    }
    protected void conditionChanged()
    {
        for (Flyable f : observers) {
            f.updateConditions();
        }
    }
}
