package defaultconstructor.date;

import java.util.stream.Stream;

public class SimpleDate {

    private int year;
    private int month;
    private int day;
    private static final int[] DAYOFMONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,};
    private static final int[] DAYOFMONTHLEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,};

    public void setDate(int year, int month, int day) {
       if (!isCorrect(year, month, day)){
           throw new IllegalArgumentException(String.format("One or more given parameter cannot be applied! %d, %d, %d",year, month, day));
       }
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

    private boolean leapYear(int year) {
        boolean leap = true;
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
            leap = false;
        }
        return leap;
    }

    private boolean isCorrect(int year, int month, int day){
        if (year < 1900 || year > 2020) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (leapYear(year) ?  (day < 1 || day > DAYOFMONTHLEAP[month -1]): (day < 1 || day > DAYOFMONTH[month -1])){
            return false;
        }
        return true;
    }

}
