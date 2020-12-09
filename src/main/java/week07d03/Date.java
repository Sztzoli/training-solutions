package week07d03;

public class Date {
    private final int year;
    private final int month;
    private final int day;

    public static final int[] DAYSOFMONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int[] DAYSOFMONTHLEAPYEAR = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static Date of(int year, int month, int day) {
        return new Date(year, month, day);
    }

    public Date withYear(int year) {
        return new Date(year, month, day);
    }

    public Date withMonth(int month) {
        return new Date(year, month, day);
    }

    public Date withDay(int day) {
        return new Date(year, month, day);

    }

    private void paramCheck(int year, int month, int day) {
        if (month<1 || month>12) {
            throw new IllegalArgumentException("wrong month");
        }
        if (leapYear(year)) {
            if(day<1 || day>DAYSOFMONTHLEAPYEAR[month]) {
                throw new IllegalArgumentException("wrong day");
            }

        } else {
            if (day<1 || day>DAYSOFMONTH[month]) {
                throw new IllegalArgumentException("wrong day");
            }
        }
    }

    private boolean leapYear(int year) {
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
            return false;
        }
        return true;
    }


}
