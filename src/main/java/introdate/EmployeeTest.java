package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name");
        String name = scanner.nextLine();
        System.out.println("year of birthdate:");
        int year=scanner.nextInt();
        System.out.println("month of birthdate:");
        int month=scanner.nextInt();
        System.out.println("day of birthdate:");
        int day=scanner.nextInt();

        Employee employee = new Employee(name, year, month, day);

        System.out.println(employee.getName()+" birth: "+employee.getDateOfBirth()+". start date: "+employee.getBeginEmployment() );



    }

}
