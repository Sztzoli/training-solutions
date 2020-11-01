package debug.employee;


import java.util.ArrayList;

public class CompanyMain {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Joe", 31);
        Employee employee2 = new Employee("Jack", 32);
        Employee employee3 = new Employee("Joe Doe", 47);
        Employee employee4 = new Employee("Ferenc", 31);
        Employee employee5 = new Employee("János", 20);
        Employee employee6 = new Employee("Géza", 14);

        Company company = new Company(new ArrayList<>());
        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);
        company.addEmployee(employee4);
        company.addEmployee(employee5);
        company.addEmployee(employee6);

        System.out.println(company.toString());


        Employee Joe = company.findEmployeeByName("Joe");
        System.out.println(Joe.getName()+" "+Joe.getYearOfBirth());

        System.out.println(company.listEmployeeNames().toString());
    }
}
