package datenewtypes;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Rendezvous {

    LocalTime localTime;

    public Rendezvous(String time, String pattern) {
        checkTime(time);
        checkPattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            localTime = LocalTime.parse(time, formatter);
        } catch (DateTimeException dte) {
            throw new IllegalArgumentException("Illegal time string: " + time);
        }
    }

    public Rendezvous(int hour, int minutes) {
        localTime = LocalTime.of(hour, minutes);
    }


    public String toString(String pattern) {
        checkPattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(localTime);
    }

    private void checkTime(String time) {
        if (!checkString(time)) {
            throw new IllegalArgumentException("Illegal time string: ");
        }
    }

    private void checkPattern(String pattern) {
        if (!checkString(pattern)) {
            throw new IllegalArgumentException("Empty pattern string!");
        }
    }

    private boolean checkString(String str) {
        return str != null && !str.isBlank();
    }

    public long countMinutesLeft(LocalTime now) {
        long minutesLeft = ChronoUnit.MINUTES.between(now, localTime);
        if (minutesLeft<=0){
            throw new MissedOpportunityException("Too late!");
        }
        return minutesLeft;
    }

    public void pushLater(int hour, int minutes) {
        localTime = localTime.plusHours(hour).plusMinutes(minutes);
    }

    public void pullEarlier(int hour, int minutes) {
        localTime = localTime.minusHours(hour).minusMinutes(minutes);
    }
}
