package xyz.tuturprdev.avaj.vehicle;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        if (p_longitude < 0)
            throw new IllegalArgumentException("Longitude must be positive");

        if (p_latitude < 0)
            throw new IllegalArgumentException("Latitude must be positive");

        if (p_height <= 0 || p_height >= 100)
            throw new IllegalArgumentException("Height must be strictly between 0 and 100");

        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }
}
