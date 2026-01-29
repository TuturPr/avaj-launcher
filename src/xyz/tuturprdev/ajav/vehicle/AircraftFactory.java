package xyz.tuturprdev.ajav.vehicle;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class AircraftFactory {

    private static AircraftFactory instance = null;
    private static final AtomicLong counter = new AtomicLong(0);
    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (AircraftTypes.get_for_type(p_type))
        {
            case BALOON:
                return new Baloon(counter.incrementAndGet(), p_name, p_coordinates);
            case JETPLANE:
                return new JetPlane(counter.incrementAndGet(), p_name, p_coordinates);
            case HELICOPTER:
                return new Helicopter(counter.incrementAndGet(), p_name, p_coordinates);
            case NONE:
            default:
                throw new IllegalArgumentException("Invalid aircraft type '" + p_type + "'");
        }

    }
}
