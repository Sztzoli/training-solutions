package week12d05;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilter {

    List<Employee> countSeniorDevs(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getSkillLevel() >= 3 && employee.getSkills().contains("programming"))
                .collect(Collectors.toList());
    }
}
