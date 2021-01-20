package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeSheetItem {
    private final Employee employee;
    private final Project project;
    private final LocalDateTime beginDate;
    private final LocalDateTime endDate;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {

        this.employee = employee;
        this.project = project;
        if (beginDate.toLocalDate().equals(endDate.toLocalDate()) && !beginDate.isAfter(endDate)) {
            this.beginDate = beginDate;
            this.endDate = endDate;
        }
        else {
            throw new IllegalArgumentException();
        }


    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public long hoursBetweenDates() {
        return Duration.between(beginDate,endDate).toHours();
    }

    @Override
    public String toString() {

        return employee +" "+project+" "+hoursBetweenDates();

    }
}
