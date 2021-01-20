package timesheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompanyFileReader {

    public static final String REGEX = " ";

    public List<Employee> readEmployees(InputStream is) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(REGEX);
                employees.add(new Employee(parts[0], parts[1]));
            }
            return employees;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File can not read");
        }
    }

    public List<Project> readProjects(InputStream is) {
        List<Project> projects = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                projects.add(new Project(line));
            }
            return projects;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File can not read");
        }
    }
}
