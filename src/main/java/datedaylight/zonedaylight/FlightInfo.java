package datedaylight.zonedaylight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FlightInfo {

    private ZonedDateTime zonedDateTime;

    public FlightInfo(String dateString, String pattern, Locale locale, ZoneId zone) {
        if (dateString==null || dateString.isBlank()) {
            throw new IllegalArgumentException("Empty date string parameter!");
        }
        if (pattern==null || pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string parameter!");
        }
        if (locale==null) {
            throw new NullPointerException("Locale must not be null!");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withLocale(locale);
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
        zonedDateTime = ZonedDateTime.of(localDateTime, zone);
    }

    public ZonedDateTime getArrivalDateTime(ZoneId zone, int flightHours, int flightMinutes) {
        ZonedDateTime arrivalDate = zonedDateTime.plusHours(flightHours).plusMinutes(flightMinutes).withZoneSameInstant(zone);
        return arrivalDate;
    }

    public ZonedDateTime getDepartureDateTime() {
        return zonedDateTime;
    }
}
