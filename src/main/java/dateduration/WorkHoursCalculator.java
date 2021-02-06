package dateduration;

import java.time.Duration;
import java.time.format.DateTimeParseException;

public class WorkHoursCalculator {


    private Duration workHours = Duration.ZERO;

    public void addWorkTime(Duration duration) {
        workHours = workHours.plus(duration);
    }

    public void addWorkTime(int days, int hours, int minutes) {
        workHours = workHours.plusDays(days).plusHours(hours).plusMinutes(minutes);
    }

    public void addWorkTime(String durationString) {
        if (durationString == null || durationString.isBlank()) {
            throw new IllegalArgumentException("Parameter must not be empty!");
        }
        Duration duration;
        try {
            duration = Duration.parse(durationString);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Parameter must match PnDTnHnM pattern, but found: " + durationString, e);
        }

        addWorkTime(duration);
    }

    public int calculateWorkHours() {
        return (int) workHours.toHours();
    }

    public Duration getWorkDuration() {
        return workHours;
    }

    public String toString() {
        return String.format("Days: %d, hours: %d, minutes: %d",workHours.toDaysPart(),workHours.toHoursPart(),workHours.toMinutesPart());
    }

}
