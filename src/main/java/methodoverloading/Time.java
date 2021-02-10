package methodoverloading;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int timeWithSecond() {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(int hours) {
        this.hours = hours;
    }

    public Time(Time time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
        this.seconds = time.seconds;
    }


    public boolean isEqual(Time time) {
        if (timeWithSecond() == time.timeWithSecond()) {
            return true;
        }
        return false;
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        if (timeWithSecond() == new Time(hours, minutes, seconds).timeWithSecond()) {
            return true;
        }
        return false;
    }

    public boolean isEarlier(Time time) {
        if (timeWithSecond() < time.timeWithSecond()) {
            return true;
        }
        return false;
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        if (timeWithSecond() < new Time(hours, minutes, seconds).timeWithSecond()) {
            return true;
        }
        return false;
    }
}
