package datenewtypes;

import java.time.LocalTime;

public class DailyRoutine {

    LocalTime time;

    public DailyRoutine(int hour, int minute) {
        time = LocalTime.of(hour, minute);
    }
    public DailyRoutine(String timeString) {
        time = LocalTime.parse(timeString);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setFutureTime(int minutes) {
        time = time.plusMinutes(minutes);
    }
    public boolean isBeforeNoon() {
        return time.isBefore(LocalTime.NOON);
    }

    public static void main(String[] args) {
        DailyRoutine dr = new DailyRoutine(9, 0);
        System.out.println(dr.getTime());
        DailyRoutine dailyRoutine = new DailyRoutine("09:00");
        System.out.println(dailyRoutine.getTime());
        dr.setFutureTime( 3 * 45 + 20);
        System.out.println(dr.getTime());
        System.out.println(dr.isBeforeNoon());
    }
}
