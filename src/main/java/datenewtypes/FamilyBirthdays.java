package datenewtypes;

import java.time.LocalDate;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyBirthdays {

    private List<LocalDate> birthDays = new ArrayList<>();

    public FamilyBirthdays(LocalDate ... birthDays) {
        this.birthDays.addAll(Arrays.asList(birthDays));
    }

    public boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day   = date.get(ChronoField.DAY_OF_MONTH);

        for (LocalDate birthday: birthDays) {
            if ((birthday.get(ChronoField.MONTH_OF_YEAR) == month) &&
                    (birthday.get(ChronoField.DAY_OF_MONTH) == day)) {
                return true;
            }
        }
        return false;
    }

    public int nextFamilyBirthDay(TemporalAccessor date) {
        int year = date.get(ChronoField.YEAR);
        LocalDate base = LocalDate.of(year, date.get(ChronoField.MONTH_OF_YEAR), date.get(ChronoField.DAY_OF_MONTH));

        int min = Integer.MAX_VALUE;

        for (LocalDate birthday: birthDays) {
            LocalDate nextBirthday = birthday.withYear(year);
            if (nextBirthday.isBefore(base)) {
                nextBirthday = birthday.withYear(year + 1);
            }
            int diff = (int) ChronoUnit.DAYS.between(base, nextBirthday);
            if (min > diff) {
                min = diff;
            }
        }
        return min;
    }
}
