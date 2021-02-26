package activitytracker;

import java.time.LocalDate;

public class TrackPoint {
    private long id;
    private LocalDate time;
    private int lat;
    private int lon;

    public TrackPoint( LocalDate time, int lat, int lon) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public TrackPoint(long id, LocalDate time, int lat, int lon) {
        this.id = id;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public void checkTrackPoint() {
        if(!checkLat(this.getLat()) || !checkLon(this.getLon()) ) {
            throw new IllegalArgumentException("Wrong TrackPoint");
        }
    }

    private boolean checkLat(int lat) {
        return lat<90 && lat>-90;
    }

    private boolean checkLon(int lon) {
        return lon<180 && lon>-180;
    }

    public long getId() {
        return id;
    }

    public LocalDate getTime() {
        return time;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }
}
