package constructoroverloading.bus;

public class SimpleTime {

    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes){
        this(hours);
        this.minutes=minutes;
    }

    public SimpleTime(int hours){
        this.hours=hours;
    }

    public SimpleTime(SimpleTime time){
        hours=time.hours;
        minutes=time.minutes;
    }

    public int difference(SimpleTime time){
        return timeInMinutes()-time.timeInMinutes();
    }

    public String toString(){
        return String.format("%d:%d",hours,minutes);
    }

   public int timeInMinutes(){
        return 60*hours+minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
