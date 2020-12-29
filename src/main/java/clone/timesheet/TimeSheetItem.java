package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }
    public TimeSheetItem(TimeSheetItem another) {
        this.employee=another.employee;
        this.project=another.project;
        this.to=another.to;
        this.from=another.from;;
    }


    private TimeSheetItem(TimeSheetItem another,LocalDate localDate) {
        this.employee=another.employee;
        this.project=another.project;
        this.to=LocalDateTime.of(localDate.getYear(),localDate.getMonth(),localDate.getDayOfMonth(),another.to.getHour(),another.to.getMinute());
        //this.to = LocalDateTime.of(localDate, another.to.toLocalTime());
        this.from = LocalDateTime.of(localDate,another.from.toLocalTime());
        //this.from=LocalDateTime.of(localDate.getYear(),localDate.getMonth(),localDate.getDayOfMonth(),another.from.getHour(),another.from.getMinute());;
    }

    static TimeSheetItem withDifferentDay(TimeSheetItem timeSheetItem, LocalDate localDate){
        return new TimeSheetItem(timeSheetItem, localDate);
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
