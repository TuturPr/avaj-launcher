package xyz.tuturprdev.avaj.weather;

import xyz.tuturprdev.avaj.vehicle.Flyable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tower {
    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.printf("Tower says: %s registered to weather tower%n", p_flyable.getCallsign());
    }

    @Deprecated
    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.printf("Tower says: %s unregistered from weather tower%n", p_flyable.getCallsign());
    }

    protected boolean conditionChanged() {
        if (observers.isEmpty())
            return false;

        Iterator<Flyable> it = observers.iterator();
        while (it.hasNext()) {
            Flyable f = it.next();
            f.updateConditions();

            if (f.getCoordinates().getHeight() <= 0) {
                f.getCoordinates().setHeight(0);
                System.out.printf("%s landing.%n", f.getCallsign());
                it.remove();
                System.out.printf("Tower says: %s unregistered from weather tower%n", f.getCallsign());
            }
        }
        return true;
    }

}
