package activity;

public class Coordinate {
    private final double latitude;
    private final double longitude;

    public Coordinate(double latitude, double longitude) {
        checkingParam(latitude,longitude);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void checkingParam(double latitude, double longitude) {
        if (latitude<-90 || latitude>90) {
            throw new IllegalArgumentException();
        }
        if (longitude<-180 || longitude>180) {
            throw new IllegalArgumentException();
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
