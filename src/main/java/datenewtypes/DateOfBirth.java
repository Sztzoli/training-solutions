package datenewtypes;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

private LocalDate dateOfBirth;

    public DateOfBirth(String date, String pattern, Locale locale) {
        checkPattern(pattern);
        checkLocale(locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern,locale);
        this.dateOfBirth = LocalDate.parse(date,formatter);
    }

    public DateOfBirth(String date, String pattern) {
        checkPattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        this.dateOfBirth = LocalDate.parse(date,formatter);
    }

    public DateOfBirth(int year, int month, int day) {
        dateOfBirth = LocalDate.of(year, month, day);

    }

    public DateOfBirth(int year, Month month, int day) {
        this(year, month.getValue(), day);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private void checkPattern(String pattern){
        if (pattern.isBlank()) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
    }

    private void checkLocale(Locale locale){
        if (locale==null) {
            throw new NullPointerException("Locale must not be null!");
        }
    }
    private void checkDateOfBirth(LocalDate now){
        if (now.isBefore(this.dateOfBirth)) {
            throw new IllegalStateException("Birthdate is in the future!");
        }
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        checkLocale(locale);
        return dateOfBirth.getDayOfWeek().getDisplayName(TextStyle.FULL,locale);
    }

    public String findDayOfWeekForBirthDate(Locale locale , LocalDate later) {
        checkLocale(locale);
        return later.getDayOfWeek().getDisplayName(TextStyle.FULL,locale);
    }

    public long countDaysSinceBirth(LocalDate now) {
        checkDateOfBirth(now);
        return ChronoUnit.DAYS.between(dateOfBirth,now);
    }

    public long countDaysBetween(DateOfBirth dateOfBirth2) {
        return ChronoUnit.DAYS.between(this.dateOfBirth,dateOfBirth2.dateOfBirth);
    }


    public String toString(String pattern) {
        checkPattern(pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(dateOfBirth);
    }
}
