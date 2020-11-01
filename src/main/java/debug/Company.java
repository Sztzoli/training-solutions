package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {
    public List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee a){
        employees.add(a);
    }

    public Employee findEmployeeByName(String name){
        for (Employee a: employees
             ) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

    public List<String> listEmployeeNames(){
        List<String> namesOfEmployees=new ArrayList<>();
        for (Employee a: employees
             ) {
            namesOfEmployees.add(a.getName());
        }


        return namesOfEmployees;
    }
}
