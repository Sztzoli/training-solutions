package stringconcat.employee;

public class Employee {

    private String name;
    private String position;
    private int salary;

    public Employee(String name, String position, int salary) {
        if (name == null || name.trim().isEmpty() ) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        if (position == null || position.equals("") ) {
            throw new IllegalArgumentException("Job must not be empty.");
        }
        if (salary%1000!=0 || salary<0){
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - "+ position +" - "+salary +" Ft";
    }
}
