package dateperiod;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class PensionCalculator {

    private final List<Period> pensionPeriods = new ArrayList<>();

    public void addEmploymentPeriod(Period period) {
        pensionPeriods.add(period);
    }

    public Period sumEmploymentPeriods() {
        return pensionPeriods.stream().
                reduce(Period.ZERO,
                        Period::plus)
                .normalized();
    }

    public Period modifyByDays(Period period, int days) {
        return period.plusDays(days);
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        checkDate(fromDate, toDate);
        return Period.between(fromDate, toDate);
    }

    private void checkDate(LocalDate fromDate, LocalDate toDate) {
        if (fromDate == null || toDate == null) {
            throw new NullPointerException("Null parameters are not allowed!");
        }
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        checkParams(fromDate, toDate, pattern);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate startDate = LocalDate.parse(fromDate, formatter);
        LocalDate endDate = LocalDate.parse(toDate, formatter);
        return getPeriodBetweenDates(startDate, endDate);

    }

    private void checkParams(String fromDate, String toDate, String pattern) {
        if (isValidStringParam(fromDate)) {
            throw new IllegalArgumentException("Empty from date string, cannot use: ");
        }
        if (isValidStringParam(toDate)) {
            throw new IllegalArgumentException("Empty to date string, cannot use: ");
        }

        if (isValidStringParam(pattern)) {
            throw new IllegalArgumentException("Empty pattern string, cannot use: ");
        }
    }

    private boolean isValidStringParam(String str) {
        return str == null || str.isBlank();
    }

    public int calculateTotalDays(Period period) {
        return period.getYears()* 365 + period.getMonths() * 30 + period.getDays();
    }
}
