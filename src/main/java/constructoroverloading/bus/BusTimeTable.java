package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {
    private List<SimpleTime> timeTable= new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable){
        this.timeTable=timeTable;
    }
    public BusTimeTable(int firstHour, int lastHour, int everyMinute){
        for (int i = firstHour; i <= lastHour; i++) {
            timeTable.add(new SimpleTime(i,everyMinute));
        }
    }

    public List<SimpleTime> getTimeTable(){
        return timeTable;
    }
    public SimpleTime nextBus(SimpleTime actual){
        for (SimpleTime busTime : timeTable) {
            if (actual.timeInMinutes() < busTime.timeInMinutes()) {
                return busTime;
            }
        }
        throw new IllegalStateException("No more buses today!");
    }
}
