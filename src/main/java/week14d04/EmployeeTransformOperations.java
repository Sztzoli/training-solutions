package week14d04;


import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {

    public List<Employee> transformToUppercased(List<Employee> employees) {
        return employees.stream()
                .map(e -> e.getName().toUpperCase())
                .map(Employee::new)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee("zoli"),new Employee("sanyi"), new Employee("marci"));

        System.out.println(new EmployeeTransformOperations().transformToUppercased(employees));
        System.out.println(employees);
    }

}
