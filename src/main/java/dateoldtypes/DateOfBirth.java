package dateoldtypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateOfBirth {

    private Date date;

    public DateOfBirth(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.set(year, month - 1, day);
        date = calendar.getTime();
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: ");
        }
    }

    public DateOfBirth(String dateString, String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Illegal date string, cannot parse: ");
        }
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
    }

    public String toString(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Illegal pattern string, cannot use: " + pattern);
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public boolean isWeekDay() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY;
    }
}
