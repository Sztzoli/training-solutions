package intromethods;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee=new Employee("János",2010,10);
        System.out.println(employee);
        employee.setName("Karcsi");
        employee.raiseSalary(1000);
        System.out.println(employee);

    }
}
