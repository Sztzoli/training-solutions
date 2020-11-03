package finalmodifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week {

    public static final List<String> week= Arrays.asList("Hétfő", "Kedd", "Szerda", "csütörtök", "péntek", "szombat", "vasárnap");
    public static void main(String[] args) {
        week.set(1,"Szerda");
        System.out.println(week);// átírja
        Week week=new Week();
        Week anotherWeek=week; //sikerült


    }
}
