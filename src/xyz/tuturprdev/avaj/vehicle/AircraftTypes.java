package xyz.tuturprdev.avaj.vehicle;

public enum AircraftTypes {
    NONE("NONE"),
    BALOON("Baloon"),
    HELICOPTER("Helicopter"),
    JETPLANE("JetPlane");
    
    private final String type;
    
    AircraftTypes (String type) {
        this.type = type;
    }

    static AircraftTypes get_for_type(String type)
    {
        for (AircraftTypes value : AircraftTypes.values()) {
            if (value.matchType(type))
                return value;
        }
        return AircraftTypes.NONE;
    }

    public boolean matchType(String arg) {
        return (arg.equals(this.type));
    }
    
}
