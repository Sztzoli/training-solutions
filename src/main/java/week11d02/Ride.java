package week11d02;

public class Ride {
    private final int day;
    private final int stopNumber;
    private final int kilometer;

    public Ride(int day, int stopNumber, int kilometer) {
        this.day = day;
        this.stopNumber = stopNumber;
        this.kilometer = kilometer;
    }

    public int getDay() {
        return day;
    }

    public int getStopNumber() {
        return stopNumber;
    }

    public int getKilometer() {
        return kilometer;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "day=" + day +
                ", stopNumber=" + stopNumber +
                ", kilometer=" + kilometer +
                '}';
    }
}
