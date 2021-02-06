package datedaylight.zonedaylight;

import java.time.*;

public class WorkHoursCalculator {

    LocalDateTime startTime;
    ZoneId zone;

    public WorkHoursCalculator(int startYear, Month startMonth, int startDay, int startHour, ZoneId zone) {
        startTime = LocalDateTime.of(startYear, startMonth, startDay, startHour, 0);
        this.zone = zone;
    }

    public long calculateHours(int year, Month month, int day, int hour) {
        ZonedDateTime startZoneTime = ZonedDateTime.of(startTime, zone);
        ZonedDateTime endZoneTime = ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, 0), zone);
        return Duration.between(startZoneTime, endZoneTime).toHours();
    }

    public ZonedDateTime getStartDateTime() {
        return ZonedDateTime.of(startTime,zone);
    }
}
