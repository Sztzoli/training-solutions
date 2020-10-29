package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    public Performance() {
        date = LocalDate.of(2020,10,29);
        artist = "artist";
        startTime = LocalTime.of(10,00);
        endTime = LocalTime.of(12,00);
    }

    private LocalDate date;
    private String artist;
    private LocalTime startTime;
    private LocalTime endTime;

    public LocalDate getDate() {
        return date;
    }

    public String getArtist() {
        return artist;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getInfo(){
        return artist+": "+ date+" "+startTime+" - "+ endTime;
    }
}
