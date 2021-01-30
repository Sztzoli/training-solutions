package datenewtypes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;

public class DateBirth {

    public static final Locale LOCALE = new Locale("hu", "HU");
    private LocalDate date;

    public DateBirth(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }

    public DateBirth(String dateString) {
        this.date = LocalDate.parse(dateString);
    }

    public String findDayOfWeek() {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, LOCALE);
    }

    public boolean isWeekDay() {
        Set<DayOfWeek> weekend = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
        return weekend.contains(date.getDayOfWeek());
    }

    public boolean wasItALeapYear() {
        return date.isLeapYear();
    }

    public String findBirthDayOfWeekLater(int year) {
        LocalDate later = LocalDate.of(year, date.getMonth(), date.getDayOfMonth());
        return later.getDayOfWeek().getDisplayName(TextStyle.FULL, LOCALE);
    }

    public LocalDate getDate() {
        return date;
    }
}
