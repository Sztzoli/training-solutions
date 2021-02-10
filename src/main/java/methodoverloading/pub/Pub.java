package methodoverloading.pub;

import methodoverloading.Time;

public class Pub {
    private final String name;
    private final Time openFrom;

    public String getName() {
        return name;
    }

    public Time getOpenFrom() {
        return openFrom;
    }

    public Pub(String name, int hours, int minutes){
        openFrom = new Time(hours,minutes);
        this.name = name;
    }
    public String toString() {
        return name+";"+openFrom.getHours()+":"+openFrom.getMinutes();
    }

}
