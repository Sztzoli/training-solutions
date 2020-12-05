package exceptionclass.course;

public class SimpleTime {
    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        checkParametersAndInit(hour, minute);
    }

    public SimpleTime(String time) {
        if (time == null) {
            throw new InvalidTimeException("Time is null");
        }
        String[] array = time.split(":");
        int[] arrayConverted = convert(array);
        checkParametersAndInit(arrayConverted[0], arrayConverted[1]);
    }

    private void checkParametersAndInit(int hour, int minute) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.minute = minute;
    }

    private int[] convert(String[] array) {
        int[] arrayConvert = new int[2];
        for (int i = 0; i < array.length; i++) {
            String actualArrayElement = array[i];
            if (actualArrayElement.startsWith("0")) {
                actualArrayElement = actualArrayElement.substring(1);
            }
            try {
                arrayConvert[i] = Integer.parseInt(actualArrayElement);
            } catch (NumberFormatException e) {
                throw new InvalidTimeException("Time is not hh:mm");
            }
        }
        return arrayConvert;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%s:%s"
                , hour < 10 ? "0" + hour : "" + hour
                , minute < 10 ? "0" + minute : "" + minute);
    }
}
