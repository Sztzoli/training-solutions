package timesheet;


import java.io.InputStream;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Company {

    private final List<Employee> employees;
    private final List<Project> projects;
    private final List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    Company(InputStream employeesFile, InputStream projectsFile) {
        employees = new CompanyFileReader().readEmployees(employeesFile);
        projects = new CompanyFileReader().readProjects(projectsFile);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public void addTimeSheetItem(Employee employee,
                                 Project project,
                                 LocalDateTime beginDate,
                                 LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));

    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {

        List<TimeSheetItem> filteredList = listByNameYearMonth(employeeName, year, month);
        Map<Project, Long> reportLineMap = listToMap(filteredList);
        return mapToList(reportLineMap);

    }


    public void printToFile(String nameEmployee, int year, int month, Path file) {

        new CompanyFileWriter().write(file, formatToString(nameEmployee, year, month));


    }

    private String formatToString(String nameEmployee, int year, int month) {

        StringBuilder sb = new StringBuilder(String.format("%s\t%s\t%d", nameEmployee, convertDateToString(year, month), sumTime(nameEmployee, year, month)));
        sb.append("\n");
        for (ReportLine report : calculateProjectByNameYearMonth(nameEmployee, year, month)) {
            if (report.getTime() != 0) {
                sb.append(report.getProject().getName()).append("\t").append(report.getTime()).append("\n");
            }
        }
        return sb.toString();
    }

    private String convertDateToString(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM");
        return date.format(pattern);
    }

    private Long sumTime(String nameEmployee, int year, int month) {
        return calculateProjectByNameYearMonth(nameEmployee, year, month).stream()
                .mapToLong(ReportLine::getTime).sum();
    }

    private List<TimeSheetItem> listByNameYearMonth(String employeeName, int year, int month) {
        List<TimeSheetItem> filterByName = timeSheetItems.stream()
                .filter(tsi -> employeeName.equals(tsi.getEmployee().getName()))
                .collect(Collectors.toList());
        if (filterByName.isEmpty()) {
            throw new IllegalArgumentException("name is not correct");
        }
        return filterByName.stream()
                .filter(tsi -> year == tsi.getBeginDate().getYear())
                .filter(tsi -> month == tsi.getBeginDate().getMonthValue())
                .collect(Collectors.toList());
    }

    private Map<Project, Long> listToMap(List<TimeSheetItem> list) {

        Map<Project, Long> map = new LinkedHashMap<>();
        for (Project project : projects) {
            map.put(project, 0L);
        }
        for (TimeSheetItem tsi : list) {
            Project key = tsi.getProject();
            Long value = tsi.hoursBetweenDates();
            map.put(key, map.get(key) + value);

        }
        return map;
    }

    private List<ReportLine> mapToList(Map<Project, Long> map) {
        List<ReportLine> list = new ArrayList<>();
        for (Map.Entry<Project, Long> entry : map.entrySet()) {
            list.add(new ReportLine(entry.getKey(), entry.getValue()));
        }
        return list;
    }
}
