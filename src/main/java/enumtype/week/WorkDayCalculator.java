package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkDayCalculator {

    public List<DayType> dayTypes(Day firstDay, int numberOfDays){
        List<DayType> dayTypes=new ArrayList<>();
        Day temp=firstDay;
        for (int i = 0; i < numberOfDays; i++) {
            dayTypes.add(temp.getDayType());
            temp = nextDay(temp);
        }
        return dayTypes;
    }

    private  Day nextDay(Day day){
        if (day.ordinal()==Day.values().length-1){
            return Day.values()[0];
        }
        else {
            return Day.values()[day.ordinal()+1];
        }
    }

}
